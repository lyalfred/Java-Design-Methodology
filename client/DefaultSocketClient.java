package client;

import java.io.*;
import java.net.*;
import java.util.*;

import exception.FixProblems;
import util.FileIO;
import util.Properties;

public class DefaultSocketClient extends Thread implements ClientInterface, ClientValues {

	protected ObjectInputStream inSt;
	protected ObjectOutputStream outSt;
	protected Socket socket;
	protected String host;
	protected String temp = null;
	
	protected int intPortVal;
	
	// default constructor
	public DefaultSocketClient (String host, int intPortVal){
		stHost(host);
		stPort(intPortVal);
	}
	
	public static void main(String[] args){
		//Automatically configure IPaddress, so don't have to
		//manual lookup.
		String iP;
		try{
			iP = InetAddress.getLocalHost().getHostAddress().toString();
			DefaultSocketClient tempD = new DefaultSocketClient(iP, iDAYTIME_PORT);
		} catch(UnknownHostException e){
			// TODO Auto-generated catch block
			// In future versions, create method to manually
			//input ipinfo.
			System.out.println("Could not find information");
		}
	}

	
	@Override
	public boolean connection() {
		// TODO Auto-generated method stub
		//Try to create a socket using user inputed values
		try{
			socket = new Socket(host, intPortVal);
		}catch(IOException e){
			if(DEBUG) {
				System.out.println("Unable to connect");
			}
			return false;
		}
		//Try to create Input/Output streams
		try{
			outSt = new ObjectOutputStream(socket.getOutputStream());
		}catch(IOException e){
			if(DEBUG){
				System.out.println("Unable to establish input/output streams");
			}
			return false;
		}
		return true;
	}

	@Override
	public void openSession(){
		Properties prop = null;
		FileIO fileIO = new FileIO();
		String temp = null;
		String tempLower = null;
		String fullFile = null;
		Scanner in = new Scanner(System.in);
		// TODO Auto-generated method stub
	/*	if(DEBUG){
			System.out.println("Connection Established");
		//TODO rewrite
		
		try{
			try {
				while((temp = (String)inSt.readObject()) != null){
					System.out.println(temp);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Error with ObjectInputStream");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	*/		System.out.println("Select an option:");
			System.out.println("a. Initiate Prop File");
			System.out.println("b. configure a car");
			temp = in.nextLine();
			tempLower = temp.toLowerCase();
			if(temp == "a") {
				System.out.println("Please enter the full .prop file name");
				fullFile = in.nextLine();
				try{
					prop = fileIO.parse(fullFile);
				}catch(IOException e){
					System.out.println("Unable to open file");
					System.exit(1);
				}
				try{
					outSt.writeObject(prop);
				}catch(IOException e){
					System.out.println("Unable to send file");
					System.exit(1);
				}
			}
			else if(temp == "b"){
				//TODO: configure car
			}
			else{
				System.out.println("Invalid choice");
			}
		}	
		

	@Override
	public void closeSession() throws IOException {
		// TODO Auto-generated method stub
		//Set everything to null
		inSt = null;
		outSt = null;
		socket.close();		
	}
	
	public void stHost(String host){
		this.host = host;
	}
	public void stPort(int port) {
		this.intPortVal = port;
	}
	public String gtHouse() {
		return host;
	}
	public int gtPort() {
		return intPortVal;
	}
	
	public void outPut(String output) {
		try {
			outSt.writeObject(output);
		}catch(IOException e){
			// TODO Auto-generated catch block
			System.out.println("error writing to objectStream");
		}
	}
	//Run method
	public void run() {
		if(connection()){
			openSession();
			try {
				closeSession();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Did not successfully close");
			}
		}
	}
}
