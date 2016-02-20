package adapter;
import java.util.*;
import exception.FixProblems;
import model.*;
import util.*;

public abstract class ProxyAutomobile {
	
	Scanner in = new Scanner(System.in);
	private static SelectedOptions selectedOptions;
	private static Automobile a1;
	private static ArrayList<SelectedOptions>choices = new ArrayList<SelectedOptions>();
	LinkedHashMap<String, Automobile> AutoHashMap = new LinkedHashMap<String, Automobile>();
	Set entrySet;
	Set keySet;
	Iterator entryItr;
	Iterator keyItr;
	
	private ReadSource read = new ReadSource();
	
	public boolean BuildAuto(String filename) throws FixProblems{
		a1 = read.readFile(filename);
		AutoHashMap.put(a1.getModel(), a1);
		keySet = AutoHashMap.keySet();
		entrySet = AutoHashMap.entrySet();
		return true;
	}
	
	public void printAuto() {
		keyItr = keySet.iterator();
		entryItr = entrySet.iterator();
		while(entryItr.hasNext()) {
			Map.Entry me = (Map.Entry)entryItr.next();
			System.out.println(me.getValue());
		}
	}
	
	public void updateOptSetName(String OptionSetname,
			String newName) throws FixProblems {
		a1.updateOptionSetName(OptionSetname, newName);
	}
	
	public void updateOptionPrice(String OptionSetname, 
			String Option, double newprice) throws FixProblems {
		a1.updateOptionPrice(OptionSetname, Option, newprice);
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
	
}

