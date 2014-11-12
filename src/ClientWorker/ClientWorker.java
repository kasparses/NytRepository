package ClientWorker;

import java.io.DataOutputStream;
import java.net.Socket;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ClientWorker implements  Runnable{
	private Socket connectionSocketConected;
	private GiantSwitch GS = new GiantSwitch();
	private encryption cryp = new encryption();
		
	
	ClientWorker(Socket connectionSocket){
		this.connectionSocketConected = connectionSocket;
	}
	
	public void run(){
		try{
			System.out.println("forbindelse Oprettet!");
			byte[] b = new byte[500000];
			int count = connectionSocketConected.getInputStream().read(b);
					
			String ny = cryp.decrypt(b);
			
			Object returnSvar = GS.GiantSwitchMethod(ny);
			
			Gson gson = new GsonBuilder().create();
			String gsonString = gson.toJson(returnSvar);
			
			DataOutputStream outToClient = new DataOutputStream(connectionSocketConected.getOutputStream());

			byte[] input = gsonString.getBytes();
			byte key = (byte) 3.1470;
			byte[] encrypted = input;
			for (int i = 0; i < encrypted.length; i++)
				encrypted[i] = (byte) (encrypted[i] ^ key);
			
			outToClient.write(encrypted);
			
		}catch(Exception exception){
			System.err.print(exception);
		}
	}

}
