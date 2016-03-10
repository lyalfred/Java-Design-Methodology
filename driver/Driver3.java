////THIS DRIVER IS USED TO TEST LAB4
/*
package driver;

import java.io.IOException;
import java.util.*;
import adapter.*;
import exception.*;
import scale.*;

public class Driver3 {
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		
		BuildAuto buildAuto = new BuildAuto();
		//hard coding the modelname to test LinkedHashMap.
		String modelName = "Focus Wagon ZTW";
		String tempString = null;
		boolean fileOkay = false;
		System.out.println("Please enter filename");
		System.out.println("use test.txt to display all correct info");
		System.out.println("use badTest.txt to test self-healing cases");
		tempString = in.nextLine();
		AutoException fileOpener = new AutoException(tempString);
		do{
			try{
				fileOkay = fileOpener.openFile();
				buildAuto.BuildAuto(fileOpener.getString());
				buildAuto.printAuto(modelName);
				//Create two instances to test synchronization
				EditOptions firstThread = new EditOptions(buildAuto);
				EditOptions secondThread = new EditOptions(buildAuto);
				
				firstThread.start();
				secondThread.start();
				
				firstThread.updateOptSetName(modelName, "Color", "Pigment");
				secondThread.updateOptSetName(modelName,"Power Moonroof", "Sky Window");
				firstThread.updateOptionPrice(modelName, "Brakes/Traction Control", "Standard", 100.0);
				secondThread.updateOptionPrice(modelName, "Brakes/Traction Control", "ABS with Advance Trac", 1738.0);
				
				System.out.println("\n\n Now printing changes made to"
						+ " Automobile object \n\n");
				buildAuto.printAuto(modelName); 
				
			}
			catch(FixProblems e){
				fileOpener.setString(e.fixString(1));
			}
			}while(fileOkay == false);
		in.close();
		
	} // main closing bracket	
} //Driver3 closing bracket
*/
