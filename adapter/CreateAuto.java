package adapter;

import exception.FixProblems;

public interface CreateAuto {

	public void BuildAuto(String filename) throws FixProblems;
	
	public void printAuto(String autoModel) throws FixProblems;
}
