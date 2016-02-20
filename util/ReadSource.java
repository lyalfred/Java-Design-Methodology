package util;

import java.io.*;
import java.util.Scanner;

import model.*;
import exception.*;

public class ReadSource {
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
            Automobile auto = new Automobile(model, name, fPrice, fSize); //calls constructor
            
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
          /*          	try {
                           	String[]optionSplit = optionName.split(",");
                    	}
                    	catch(ArrayIndexOutOfBoundsException f){
                    		System.out.println("Missing Option Price, please enter here:" );
                    		optionSplit[1] = in.nextLine();
                    	} */
                    	String[]optionSplit = optionName.split(",");
                    	String tempString = optionSplit[1];
                    	this.parseDouble(tempString);
                    	Double fdoubPrice = tryParse.getNumber();
                    	auto.buildOption(temp, optionSetIndex, optionSplit[0], fdoubPrice);
                    
                    }
            }
            buff.close(); 
            return auto;
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
		return null;		
    } // readFile bracket
	private void parseDouble(String temp) throws IOException {
		tryParse.setString(temp);
		boolean flag = false;
		do {
			try {
				flag = tryParse.parseValue();
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
	}
	*/
} // class bracket
