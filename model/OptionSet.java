package model;

import java.io.Serializable;
import java.util.*;

/*
 * The purpose of this class is to populate values for 
 * Properties of each element in OptionSet
 */
public class OptionSet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Option>opt;
	
	public OptionSet(){
		 setOpt(new ArrayList<>(10));
	}
	public OptionSet(String n, int size)
	{
		setOpt(new ArrayList<>(size)); //
		setName(n);
	}
	// remember to make all of these protected. & option class as well
	// Getters
	protected String getName() {	// get optionset name
		return name;
	}
	protected Option getOpt(int index) {
		return opt.get(index);
	}
	// Finders	
	protected Option findOp(String name){
		for(int i=0; i < opt.size(); i++) {
			System.out.println(getOpt(i).getName());
			if(getOpt(i).getName().matches(name)) {
				return getOpt(i);
			}
		}
		return null;
	}
	
	public int findOpInt(String name) {
		for(int i=0; i < opt.size(); i++) {
			if(getOpt(i).getName() == name) {
				return i;
			}
		}
		return 0;
	}	
	
	// Setters
	protected void setName(String name) {
			this.name = name;
	}
	protected void setOpt(ArrayList<Option> opt) {
			this.opt = opt;
	}
	// Delete
		protected void deleteOpt(String name) {
		// maybe implement try-catch in future versions
			if(opt.remove(findOp(name))) 
				System.out.println(name + "removed");
			else
				System.out.println(name + "not removed");
			
	}
	// Update
		protected void updateOptions(int index, Option opt) {
		this.opt.set(index, opt);
	}
		protected void updateOptName(String Option, String newName) {
			/*
			 * Pull out section of optionset arraylist
			 * Update the first element of the arraylist to new name
			 * Push the new arraylist back to OptionSet arraylist
			 */
			Option tempOpt = findOp(Option);
			int temp = findOpInt(Option);
			tempOpt.setName(newName);
			opt.set(temp, tempOpt);
		}
		protected void updateOptPrice(String Option, double newprice) {
			/*
			 * Same concept as updateOptionName
			 */
			Option tempOpt = findOp(Option);
			int temp = findOpInt(Option);
			tempOpt.setPrice(newprice);
			opt.set(temp, tempOpt);
			
		}
	protected void addOptionToList(String name, double price) {
		Option obj = new Option(name, price);
		opt.add(obj);	
	}
		
		
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder(256);
	    sb.append("\nProperty: ").append(name).append("\n");
	    for (Option option : opt) {
	    	sb.append(option.toString()).append("\n");	 
	    }	    	
	    return sb.toString();
		}
	
	
private class Option implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String name;
		private double price;
		
		public Option(String name, double price){
			setName(name);
			setPrice(price);
		}
		
		//getters			
		protected String getName() {		// get optionset name
			return name;
		}
		@SuppressWarnings("unused")
		protected double getPrice() {
			return price;
		}
		// setters
		protected void setName(String name) {		
			this.name = name;
		}
		protected void setPrice(double price) {
			this.price = price;
		}
		@Override
		public String toString() {
		    StringBuilder sb = new StringBuilder();
		    sb.append(name).append(":: Price: ").append("$").append(price);
		    return sb.toString();
		}
	}
}

