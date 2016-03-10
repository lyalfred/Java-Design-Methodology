package server;

import java.io.*;
import java.net.*;
import adapter.*;
import util.*;
import client.*;
import exception.FixProblems;

public class ServerAuto extends DefaultSocketClient{

	private BuildFromProperties build;
	private ServerSocket server;
	private Properties prop = null;
	/*	
	public ServerAuto(BuildAuto buildAuto){
		build = new BuildFromProperties(buildAuto);
	}
*/	
	public ServerAuto(String host, int intPortVal, BuildAuto buildAuto){
		super(host, intPortVal);
		build = new BuildFromProperties(buildAuto);
	}
	
	@Override
	public boolean connection(){
		try{
			server = new ServerSocket(intPortVal);
		}catch(IOException e){
			if(DEBUG) System.out.println("Connection to: " + intPortVal + " failed.");
			return false;
		}
		try{
			socket = server.accept();
		}catch(IOException e){
			if(DEBUG) System.out.println("Did not accept connection");
			return false;
		}
		try{
			inSt = new ObjectInputStream(socket.getInputStream());
		}catch(IOException e){
			if(DEBUG) System.out.println("Unable to access input stream");
			return false;
		}
		return true;
	}
	
	@Override
	public void openSession() {
		try{
			if((prop = (Properties) inSt.readObject()) != null){
				build.userAutoProperties(prop);
				
			}
		}catch(IOException | ClassNotFoundException | FixProblems e){
			e.printStackTrace();
			System.out.println("Error occured in openSession: ServerAuto");
			System.exit(1);
		}
		System.out.println("Successfully added automobile");
		build.print(prop.getProp("CarModel"));
	}
	
	@Override
	public void closeSession() {
		inSt = null;
		outSt = null;
		server = null;
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*	
	@Override
	public void run() {
		ServerSocket server = null; 
		Socket client = null;
		
		//try to instantiate server side
		int port = 4444;
		try{
			server = new ServerSocket(port);
		} catch(IOException e) {
			System.out.println("Port: " + port + " invalid");
			System.exit(1);
		}
		
		//try to instantiate client side
		try {
			client = server.accept();
		}catch(IOException e) {
			System.out.println("Connection Failed");
			System.exit(1);
		}
		//Print out status
		PrintWriter out;
		try {
			out = new PrintWriter(client.getOutputStream(), true);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		//BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		ObjectInputStream clientStream;
		try {
			clientStream = new ObjectInputStream(client.getInputStream());
			try {
				while((clientStream = (ObjectInputStream) clientStream.readObject())!= null){
					try {
						build.userAutoProperties(clientStream);

						
					} catch (ClassNotFoundException | FixProblems e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	*/
}
