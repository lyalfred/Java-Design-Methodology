//Comment out for lab 5.


package util;

import java.io.*;
import java.util.*;
import model.*;
import exception.*;

public class FileIO {
	Scanner in = new Scanner(System.in);
	AutoException tryParse = new AutoException();
	public Automobile readFile(String fileName) throws FixProblems {
        try {
            FileReader file = new FileReader(fileName);
            BufferedReader buff = new BufferedReader(file);
            //Create initial object
            // In Future Version, implement string splits to make file cleaner.
            String name = buff.readLine();	//reads name
            String model = buff.readLine(); //reads model name
            String price = buff.readLine(); //reads base price
            String size = buff.readLine();	//reads array list size
            
            // Function to try and parse.
            this.parseDouble(price);
            Double fPrice = tryParse.getNumber();
            
            this.parseDouble(size);
            double fdoubSize = tryParse.getNumber();
            int fSize = (int) fdoubSize; //fixed size of array
            Automobile auto = new Automobile(name, model, fPrice, fSize); //calls constructor
            
            for(int optionSetIndex=0; optionSetIndex < fSize; optionSetIndex++) { // cycles 5 times for 5 different OptionSets

            		String optionChoice = buff.readLine(); //Read option set name
                   	String numOfChoices = buff.readLine(); //Read number of choices
                  
                   	this.parseDouble(numOfChoices);
                   	double fdoubChoice = tryParse.getNumber();
                   	int fChoices = (int) fdoubChoice;
                    OptionSet temp = auto.buildAutoObject(optionChoice, fChoices);
                    for(int j=0; j < fChoices; j++) { 
                    	String optionName = buff.readLine();//Reads option name & price.
              //do the split function here.      	
          //          	try {
          //                 	String[]optionSplit = optionName.split(",");
          //          	}
          //         	catch(ArrayIndexOutOfBoundsException f){
          //          		System.out.println("Missing Option Price, please enter here:" );
          //          		optionSplit[1] = in.nextLine();
          //          	} 
                    	String[]optionSplit = optionName.split(",");
                    	String tempString = optionSplit[1];
                    	this.parseDouble(tempString);
                    	Double fdoubPrice = tryParse.getNumber();
                    	auto.buildOption(temp, optionSetIndex, optionSplit[0], fdoubPrice);
                    
                    }
            }
            buff.close(); 
            file.close();
            return auto;
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
		return null;		
    } // readFile bracket
	private void parseDouble(String temp){
		tryParse.setString(temp);
		boolean flag = false;
		do {
			try {
				try {
					flag = tryParse.parseValue();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			catch(FixProblems e)
			{
				tryParse.setString(e.fixString(5));
			}
		}while(flag == false);
	}
/*	private void splitString(String stringSplit) {
		boolean flag = false;
		do{
			try {
				flag = tryParse.splitString(stringSplit);
			}
			catch(FixProblems f) {
				tryParse.setString(f.fixString(4));
			}
		}while(flag == false);
	}*/
	public Automobile buildProp(Properties prop) throws FixProblems {
		int opt = 1; //don't start at 0 (no such thing as zeroth option
		String temp, tempVal = null; 
		char optVal = 'a'; // starts with a..b..c..etc
		Automobile auto = new Automobile(prop.getProp("CarMake"),prop.getProp("CarModel"),0,5);
		//reading from prop "Option1...Option2...etc"
		while((temp = prop.getProp("Option" + opt)) != null) {
			// create an option set list to hold all the sub-options
			ArrayList<String> optSetList = new ArrayList<>(20);
			optSetList.add(temp);
			while((tempVal = prop.getProp("OptionValue"+ opt+optVal)) != null) {
				optSetList.add(tempVal);
				optSetList.add("0");
				optVal++;
			}
			//auto.buildOptSetProp((String[])optSetList.toArray());
			try{
				String optSet[] = new String[optSetList.size()];
				optSet = optSetList.toArray(optSet);
				auto.buildOptSetProp(optSet);
				
			}catch(FixProblems e){
				System.out.println("Error in building optionSet");
				System.exit(1);
			}
			opt++;
		}
		return auto;
	}
	
	public void serializeAuto(Automobile auto) throws FixProblems {
		//create filename from auto model
		String temp = auto.getModel();
		String temp1 = temp.toLowerCase();
		String temp2 = temp1.replaceAll(" ", "");
		String filename = temp2 + ".ser";	
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(filename));
			out.writeObject(auto);
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void serProp(Properties prop){
		String temp = prop.getProp("CarModel");
		String temp1 = temp.toLowerCase();
		String temp2 = temp1.replaceAll(" ", "");
		String filename = temp2 + ".ser";
		try{
			ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(filename));
				out.writeObject(prop);
				out.close();
			}catch(IOException e){
				e.printStackTrace();
		}
	}
	public Automobile deserAuto(String filename) throws FixProblems {
		Automobile auto1 = null;
		try{
			FileInputStream fileIn;
			try {
				fileIn = new FileInputStream(filename);
				ObjectInputStream in;
				try {
					in = new ObjectInputStream(fileIn);
					try {
						auto1 = (Automobile) in.readObject();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}catch(ClassNotFoundException e)
		{
			System.out.println("Automotive class not found");
			e.printStackTrace();
		}
		return auto1;
	}
	
	public Properties deserProperties(ObjectInputStream in) throws ClassNotFoundException {
		Properties prop;
		try {
			prop = (Properties) in.readObject();
			return prop;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in deserialising properties");
			return null;
		}
	}
	public Properties parse(String filename) throws IOException{
		Properties prop = new Properties();
		FileReader file;
		try {
			file = new FileReader(filename);
			BufferedReader in = new BufferedReader(file);
			prop.buildProp(in);
			return prop;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
} // class bracket

