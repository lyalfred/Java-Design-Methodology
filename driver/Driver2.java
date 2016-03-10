/*
///////THIS DRIVER IS USED TO TEST LAB3
package driver;
import java.io.*;
import java.util.*;
import adapter.*;
import exception.*;

public class Driver2 {
	public static void main(String [] args) throws IOException {
		Scanner in = new Scanner(System.in);
		boolean fileOkay = false;
		//create error log text file.
		PrintWriter writer = new PrintWriter("errorlog.txt");
		//Create interface objects
		CreateAuto createAuto = new BuildAuto();
		UpdateAuto updateAuto = new BuildAuto();
		SelectAuto selectAuto = new BuildAuto();
		String Option;
		String temp;
		String newName;
		Double newprice;
		
		System.out.println("Please enter filename");
		System.out.println("use test.txt to display all correct info");
		System.out.println("use badTest.txt to test self-healing cases");
		String fileName = in.nextLine();
		AutoException fileOpener = new AutoException(fileName);
		do {
			try {
				fileOkay = fileOpener.openFile();
				
				createAuto.BuildAuto(fileOpener.getString());
				createAuto.printAuto();
				
				System.out.println("Which OptionSet Name would you like "
						+ "to change?");
				String OptionSetname = in.nextLine();
				System.out.println("what is the new name?");
				newName = in.nextLine();
				updateAuto.updateOptSetName(OptionSetname,
						newName); 		
				createAuto.printAuto();
				System.out.println("\n Now testing UpdateOptionPrice \n");
				System.out.println("Type in optionset name: ");
				OptionSetname = in.nextLine();
				System.out.println("Which option would you like to select");
				Option = in.nextLine();
				System.out.println("What would you like to change the price to?");
				newprice = in.nextDouble();
				updateAuto.updateOptionPrice(OptionSetname,
						Option, newprice);

				System.out.println("\n\n Now printing changes made to"
						+ "Automobile object \n\n");
				createAuto.printAuto(); 
				
				System.out.println("\n\n Time to select options from each OptionSet:");
				selectAuto.selectOptionSet();
			}
			catch(FixProblems e)
			{
				fileOpener.setString(e.fixString(1));
			}
		}while(fileOkay == false);
	in.close();
	} //main bracket
}//class bracket 
*/