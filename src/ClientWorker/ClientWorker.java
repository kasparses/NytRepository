package ClientWorker;

import java.io.DataOutputStream;
import java.net.Socket;

public class ClientWorker implements  Runnable{
	private Socket connectionSocketConected;
	private GiantSwitch GS = new GiantSwitch();
	private encryption cryp = new encryption();

	ClientWorker(Socket connectionSocket){
		this.connectionSocketConected = connectionSocket;
	}
	/**
	 * This method receives a Json object from the client through the socket. First the object received is decrypted and thereafter
	 * the giantSwitchMethod method in the giantSwitch class is called with the now decrypted object.
	 * What is returned from the giantSwitchMethod method is now encrypted and sent back to the client.
	 * 
	 */
	public void run(){
		try{

			//Byte array where the byte stream from the inputstream gets read and saved into
			byte[] b = new byte[500000];
			int count = connectionSocketConected.getInputStream().read(b);

			//Decryption of the inputstream
			String ny = cryp.decrypt(b);
			
			//Creates an object of the data which is to be send back to the client, via the connectionSocket
			String returnSvar = (String) GS.GiantSwitchMethod(ny);

			DataOutputStream outToClient = new DataOutputStream(connectionSocketConected.getOutputStream());

			//Encrypt the data before sending the return answer
			byte[] input = returnSvar.getBytes();
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
