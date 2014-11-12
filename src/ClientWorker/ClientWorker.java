package ClientWorker;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import JsonClasses.DeleteCalender;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.simple.JSONObject;

import JsonClasses.DeleteCalender;
import sun.font.CreatedFontTracker;



public class ClientWorker implements  Runnable{
	private Socket connectionSocketConected;
//	private CalendarInfo CI = new CalendarInfo();
	private GiantSwitch GS = new GiantSwitch();
	private encryption cryp = new encryption();
	private String incomingJson;
		
	
	ClientWorker(Socket connectionSocket){
		this.connectionSocketConected = connectionSocket;
	}
	
	public void run(){
		try{
			System.out.println("forbindelse Oprettet!");
			byte[] b = new byte[500000];
			int count = connectionSocketConected.getInputStream().read(b);
			
//			ByteArrayInputStream bais = new ByteArrayInputStream(b);
//			DataInputStream inFromClient = new DataInputStream(connectionSocketConected.getInputStream());		
			
			//Creates an object of the data which is to be send back to the client, via the connectionSocket
			
			System.out.println("Outtoclient oprettet!");
					
			String ny = cryp.decrypt(b);
			
			System.out.println("Besked modtaget!");
			//Sysout recieved message
			System.out.println("Received: " + ny);
			
//			String returnSvar = GS.GiantSwitchMethod(ny);	
			Object returnSvar = GS.GiantSwitchMethod(ny);	
			Gson gson = new GsonBuilder().create();
			String gsonString = gson.toJson(returnSvar);
			
			//Sends the capitalized message back to client!!
			System.out.println("returnSvar: "+returnSvar);
			
//			Gson gson = new GsonBuilder().create();
//			String gsonString = gson.toJson(returnSvar);
			
			DataOutputStream outToClient = new DataOutputStream(connectionSocketConected.getOutputStream());
			
//			byte[] input = returnSvar.getBytes();
			byte[] input = gsonString.getBytes();
			byte key = (byte) 3.1470;
			byte[] encrypted = input;
			for (int i = 0; i < encrypted.length; i++)
				encrypted[i] = (byte) (encrypted[i] ^ key);
			
			outToClient.write(encrypted);
			System.out.println("svar sendt");
			
		}catch(Exception exception){
			System.err.print(exception);
		}
	}
//	public ClientWorker(Object o) throws IOException{
//		Gson gson = new GsonBuilder().create();
//		String gsonString = gson.toJson(o);
//		System.out.println("gsonString: "+gsonString);
//		DataOutputStream outToClient = new DataOutputStream(connectionSocketConected.getOutputStream());
//		
//		byte[] input = gsonString.getBytes();
//		byte key = (byte) 3.1470;
//		byte[] encrypted = input;
//		for (int i = 0; i < encrypted.length; i++)
//			encrypted[i] = (byte) (encrypted[i] ^ key);
//		
//		outToClient.write(encrypted);
//		System.out.println("svar sendt");
//		
//	}

}
