package driver;

import java.io.*;
import java.net.*;
import server.*;
import client.*;
import adapter.*;
import exception.*;

public class Driver4 implements ClientValues{

    public static void main(String[] args) throws IOException, 
		FixProblems, ClassNotFoundException {
		
		BuildAuto buildAuto = new BuildAuto();
		String filename = "test.txt";
		String host = null;
		
		buildAuto.BuildAuto(filename);
		try{
			host = InetAddress.getLocalHost().getHostAddress().toString();
		}catch(UnknownHostException e){
			System.out.println("Connection Failed");
			System.exit(1);
		}
		ServerAuto socket = new ServerAuto(host, iDAYTIME_PORT, buildAuto);
		socket.start();
	}
}
