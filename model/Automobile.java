package model;

import java.io.Serializable;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import exception.*;

public class Automobile implements Serializable{  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String make;
	private String model;
	private double baseprice;
	private ArrayList<OptionSet>opset;
// Constructors
	public Automobile()
	{
		opset = new ArrayList<>(5);
	}
	public Automobile (String make, String model, double baseprice, int size)
	{
		opset = new ArrayList<>(size);
		setBaseprice(baseprice);
		setModel(model);
		setMake(make);
	}
	
	//Getters
	public String getMake() {
		return make;
	}
	public String getModel() {   //model name
		return model;
	}
	public double getBaseprice() {	
		return baseprice;
	}
	public OptionSet getOpset(int index) {
		return opset.get(index);
	}

	//Finders
	public OptionSet findOpset(String name) throws FixProblems{
		// TRY TO IMPLEMENT SELF-HEALING HERE.
//		AutoException tempName = new AutoException(name);
//		boolean flag = false;
//		do {
			for(int i =0; i < opset.size(); i++)
			{				
				if(getOpset(i).getName().matches(name)){
//					flag = true;
					return getOpset(i);
				} 
			} 
			/*If you search the entire arraylist and nothing matches, the method
			 * will return null, which will result in a null pointer exception
			 * However, the below method "tempName.compare(getOpset(0).getName();
			 * will attempt to search the arraylist again based on a user's different
			 * input. This is inefficient, but works, or so I thought
			 * 
			 */
/*			try {
				System.out.print(getOpset(0).getName());
				flag = tempName.compare(getOpset(0).getName());
				return getOpset(0);
			}
			catch(FixProblems e){
				tempName.setName(e.fixString());
			} */
//		}while(flag == false);
		return null;
	}
	public int findOpsetIndex(String name) {
		for(int i=0; i < opset.size(); i++) {
			if(getOpset(i).getName().matches(name)) {
				return i;				}
		}
		
		return 0;
	}
	//findOpSeelctName and findOpSeelctPrice exists to parse data from 
	//OptionSet & option arraylists into a new object. (Select Options)
	public String findOpSelectName(String optionSetName, String optionName) throws FixProblems{
		OptionSet tempOption = this.findOpset(optionSetName);
		String tempName = tempOption.findOpSelectionName(optionName);
		return tempName;
	}
	public Double findOpSelectPrice(String optionSetName, String optionName) throws FixProblems{
		OptionSet tempOption = this.findOpset(optionSetName);
		Double tempPrice = tempOption.findOpSelectionPrice(optionName);
		return tempPrice;
	}
	public void setMake(String name){
		this.make = name;
	}
	public void setModel(String name) {
		this.model = name;
	}
	public void setBaseprice(double baseprice) {
		this.baseprice = baseprice;
	}

	//Delete
	public void deleteOpset(String name) throws FixProblems {
		//maybe implement try-catch in future versions
		if(opset.remove(findOpset(name)))
			System.out.println(name + "removed");
		else
			System.out.println(name + "not removed");
	}
	
	//Update
	public synchronized void updateOptionSet(int index, OptionSet opset){
		this.opset.set(index, opset);
	}
	
	public synchronized void updateOptionSetName(String optionSetName, String newName) throws FixProblems {
		OptionSet temp = this.findOpset(optionSetName);
		int index = this.findOpsetIndex(optionSetName);
		temp.setName(newName);
		this.updateOptionSet(index, temp);
	}
	
	// ONLY EXISTS TO MAINTAIN ENCAPSULATION
	public synchronized void updateOptionName(String OptionSetName, String Option,
			String newName) throws FixProblems {
		OptionSet temp = this.findOpset(OptionSetName);
		temp.updateOptName(Option, newName);
	}
	
	// ONLY EXISTS TO MAINTAIN ENCAPSULATION
	public synchronized void updateOptionPrice(String OptionSetName, String Option, 
			double newprice) throws FixProblems {
		OptionSet temp = this.findOpset(OptionSetName);
		temp.updateOptPrice(Option, newprice);
	}

	@Override
	public synchronized String toString() {
	    StringBuilder sb = new StringBuilder(256);
	    sb.append("Make: ").append(make).append("\nModel: ").append(model)
	            .append("\nBase Price: $").append(baseprice).append("\n");
	    for (int i=0; i < 5; i++) { //In future models: implement enhanced for loop
	    	sb.append(opset.get(i).toString());
	    }

	    return sb.toString();
	}
	

	public synchronized OptionSet buildAutoObject(String name, int size) {
		OptionSet optionSet = new OptionSet(name, size);	
		opset.add(optionSet);
		return optionSet;
	}
	public synchronized void buildOption(OptionSet optionSet, int index, String name, double price) {
		
		optionSet.addOptionToList(name,price);
		opset.add(index, optionSet);
	}
	//For Properties
	public synchronized void buildOptSetProp(String splitLine[]) throws FixProblems {
		int numOptions = (splitLine.length -1)/2;
		OptionSet optSet = new OptionSet(splitLine[0], numOptions);
		optSet.addOpt(splitLine,numOptions);
		this.opset.add(optSet);
	}
}

