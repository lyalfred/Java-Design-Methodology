package adapter;
import java.util.*;
import java.io.*;
import exception.FixProblems;
import model.*;
import util.*;
import util.Properties;

public abstract class ProxyAutomobile {
	
	Scanner in = new Scanner(System.in);
	private static SelectedOptions selectedOptions;
	private static Automobile a1;
	private static ArrayList<SelectedOptions>choices = new ArrayList<SelectedOptions>();
	LinkedHashMap<String, Automobile> autoHM = new LinkedHashMap<String, Automobile>();
	Set entrySet;
	Set keySet;
	Iterator entryItr;
	Iterator keyItr;
	
	public void BuildAuto(String filename) throws FixProblems{
		addAuto(filename);
	}
	
	private void addAuto(String filename) throws FixProblems {
	//	Automobile auto = new ReadSource().readFile(filename);
		Automobile auto = new FileIO().readFile(filename);
		autoHM.put(auto.getModel(), auto);
	}
	private void deleteAuto(String autoMobile) {
		autoHM.remove(autoMobile);
	}

	public void printAuto(String autoMobile) {
		System.out.println(autoHM.get(autoMobile));
	}
	
	public void updateOptSetName(String autoModel, String OptionSetname,
			String newName) throws FixProblems {
		
		autoHM.get(autoModel).updateOptionSetName(OptionSetname, newName);
	}
	
	public void updateOptionPrice(String autoModel, String OptionSetname, 
			String Option, double newprice) throws FixProblems {
		
		autoHM.get(autoModel).updateOptionPrice(OptionSetname, Option, newprice);
	}
	
	public void selectOptionSet() throws FixProblems{
		System.out.println("Please select an OptionSet to begin.");
		String optSetChoice = in.nextLine();
		System.out.println("Please select an option from your selected OptionSet");
		String optChoice = in.nextLine();
		String name = a1.findOpSelectName(optSetChoice, optChoice);
		Double price = a1.findOpSelectPrice(optSetChoice, optChoice);
		selectedOptions = new SelectedOptions(name, price);
		choices.add(selectedOptions);
		System.out.println("Choices size: "+ choices.size());
	}
	
	public void userAutoProperties(Properties properties)throws ClassNotFoundException, FixProblems{
		FileIO fileIO = new FileIO();		
//		Properties prop = fileIO.deserProperties(properties);
//		Automobile auto = fileIO.buildProp(prop);
//		autoHM.put(auto.getModel(), auto);
		Automobile auto = fileIO.buildProp(properties);
		autoHM.put(auto.getModel(), auto);
	}
	
}

