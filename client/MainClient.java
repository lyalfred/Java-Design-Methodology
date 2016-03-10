package client;

import java.io.*;
import java.net.*;
import util.*;

public class MainClient {

	private FileIO fileIO;
	
	public MainClient() {
		fileIO = new FileIO();
	}
	public void sendToProp(String filename){
		Properties prop;
		try {
			prop = fileIO.parse(filename);
			fileIO.serProp(prop);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
