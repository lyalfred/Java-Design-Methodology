package adapter;

import exception.FixProblems;

public interface CreateAuto {

	public boolean BuildAuto(String filename) throws FixProblems;
	
	public void printAuto() throws FixProblems;
}
