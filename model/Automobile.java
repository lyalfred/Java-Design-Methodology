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
	private String name;
	private double baseprice;
	private ArrayList<OptionSet>opset;
// Constructors
	public Automobile()
	{
		opset = new ArrayList<>(5);
	}
	public Automobile (String n, double baseprice, int size)
	{
		opset = new ArrayList<>(size);
		setBaseprice(baseprice);
		setName(n);
	}
	
	//Getters
	public String getName() {   //model name
		return name;
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
			if(getOpset(i).getName() == name) {
				return i;				}
		}
		
		return 0;
	}
	
	//Setters
	public void setName(String name) {
		this.name = name;
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
	public void updateOptionSet(int index, OptionSet opset){
		this.opset.set(index, opset);
	}
	
	public void updateOptionSetName(String OptionSetName, String newName) throws FixProblems {
		OptionSet temp = this.findOpset(OptionSetName);
		int index = this.findOpsetIndex(OptionSetName);
		temp.setName(newName);
		this.updateOptionSet(index, temp);
	}
	
	// ONLY EXISTS TO MAINTAIN ENCAPSULATION
	public void updateOptionName(String OptionSetName, String Option,
			String newName) throws FixProblems {
		OptionSet temp = this.findOpset(OptionSetName);
		temp.updateOptName(Option, newName);
	}
	
	// ONLY EXISTS TO MAINTAIN ENCAPSULATION
	public void updateOptionPrice(String OptionSetName, String Option, 
			double newprice) throws FixProblems {
		OptionSet temp = this.findOpset(OptionSetName);
		temp.updateOptPrice(Option, newprice);
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder(256);
	    sb.append("Name: ").append(name)
	            .append("\nBase Price: $").append(baseprice).append("\n");
	    for (int i=0; i < 5; i++) { //In future models: implement enhanced for loop
	    	sb.append(opset.get(i).toString());
	    }

	    return sb.toString();
	}
	

	public OptionSet buildAutoObject(String name, int size) {
		OptionSet optionSet = new OptionSet(name, size);	
		opset.add(optionSet);
		return optionSet;
	}
	public void buildOption(OptionSet optionSet, int index, String name, double price) {
		
		optionSet.addOptionToList(name,price);
		opset.add(index, optionSet);
	}
}

