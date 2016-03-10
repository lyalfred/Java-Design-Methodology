package util;

import java.io.*;
import java.util.*;
	
public class Properties {
	private LinkedHashMap<String, String> properties;
	
	public LinkedHashMap<String, String> getProperties() {
		return properties;
	}
	public void setProp(LinkedHashMap<String, String> properties){
		this.properties = properties;
	}
	
	private void putProp(String splitLine[]) {
		properties.put(splitLine[0], splitLine[1]);
	}
	public String getProp(String name) {
		return properties.get(name);
	}
	public void buildProp(BufferedReader in) {
		BufferedReader propertiesBuffer = new BufferedReader(in);
		String temp;
		String[] splitTemp;
		try {
			while((temp = propertiesBuffer.readLine()) != null) {
				splitTemp = temp.split("=");
				putProp(splitTemp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in building Properties");
		}
	}	
}//main closing bracket
