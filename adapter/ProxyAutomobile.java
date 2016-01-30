package adapter;
import exception.FixProblems;
import model.*;
import util.*;

public abstract class ProxyAutomobile {

	private static Automobile a1;
	private ReadSource read = new ReadSource();
	
	public boolean BuildAuto(String filename) throws FixProblems{
		a1 = read.readFile(filename);
		return true;
	}
	
	public void printAuto() {
		
		System.out.print(a1.toString());
	}
	
	public void updateOptionSetName(String OptionSetname,
			String newName) throws FixProblems {
		a1.updateOptionSetName(OptionSetname, newName);
	}
	
	public void updateOptionPrice(String OptionSetname, 
			String Option, double newprice) throws FixProblems {
		a1.updateOptionPrice(OptionSetname, Option, newprice);
		
	}
}

