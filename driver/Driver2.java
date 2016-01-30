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
		String Option = "Fort Knox Gold Clearcoat Metallic";
		String newName = "Pigment";
		Double newprice = 1000.00;
		
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
				updateAuto.updateOptionPrice(OptionSetname,
						Option, newprice);
				updateAuto.updateOptionSetName(OptionSetname,
						newName); 
				System.out.println("\n\n Now printing changes made to"
						+ "Automobile object \n\n");
				createAuto.printAuto(); 
			}
			catch(FixProblems e)
			{
				fileOpener.setString(e.fixString(1));
			}
		}while(fileOkay == false);
		
	} //main bracket
}//class bracket 
