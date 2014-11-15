package ClientWorker;
import java.io.*;
import java.net.*;
import java.sql.SQLException;

import model.Model;
import model.database.DatabaseInit;
import GUI.OpenAdmin;
import JsonClasses.CalendarInfo;
import ClientWorker.ClientWorker;

import com.google.gson.stream.JsonReader;

class TCPServer extends Model{    
	

	public static void main(String argv[]) throws Exception       {
        new TCPServer().go();
	}
	
	public void go() throws SQLException, IOException {
	

        readfromSqlFile("src/SQLFiles/createDBscript.sql");

		OpenAdmin admin = new OpenAdmin();
		Thread adminthread = new Thread (admin, "OpenAdmin");
		adminthread.run();
		
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