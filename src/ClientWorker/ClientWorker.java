package ClientWorker;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import JsonClasses.DeleteCalendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.simple.JSONObject;

import JsonClasses.DeleteCalendar;
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
			
			byte[] b = new byte[500000];
			int count = connectionSocketConected.getInputStream().read(b);
			
			//Creates an object of the data which is to be send back to the client, via the connectionSocket
					
			String ny = cryp.decrypt(b);
		
			String returnSvar = (String) GS.GiantSwitchMethod(ny);
			
//			Gson gson = new GsonBuilder().create();
//			String gsonString = gson.toJson(returnSvar);
			
			DataOutputStream outToClient = new DataOutputStream(connectionSocketConected.getOutputStream());

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
