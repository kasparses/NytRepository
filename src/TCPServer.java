import java.io.*;
import java.net.*;

import GUI.OpenAdmin;
import JsonClasses.CalendarInfo;

import com.google.gson.stream.JsonReader;

class TCPServer{    
	
	public static void main(String argv[]) throws Exception       {

		
		OpenAdmin admin = new OpenAdmin();
		Thread adminthread = new Thread (OpenAdmin, "OpenAdmin");
		OpenAdmin.run();
		
		//Creates a socket to send and recieve messages in port 8888
		ServerSocket welcomeSocket = new ServerSocket(8888);
		
		//While something is true
		while(true){
			//Creates a socket and a buffered reader which recieves some sort of input from somewhere around the internet!
			Socket connectionSocket = welcomeSocket.accept();
			ClientWorker client= new ClientWorker(connectionSocket);
			Thread clientthread = new Thread(client, "client");
			clientthread.start();
		}
	}
}
