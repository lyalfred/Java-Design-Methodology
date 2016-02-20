package adapter;

import exception.FixProblems;

public interface UpdateAuto {
	
	public void updateOptSetName(String OptionSetName,
			String newName) throws FixProblems;
	
	public void updateOptionPrice(String OptionSetname, 
			String Option, double newprice) throws FixProblems;
	
}
