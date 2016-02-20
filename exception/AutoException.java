package exception;
import java.io.*;
import java.util.regex.PatternSyntaxException;

public class AutoException {

	private String tempName;
	private Double tempNumber;
	
	public AutoException() {}
	public AutoException(String name){
		super();
		this.tempName = name;
	}
	
	public String getString() {
		return tempName; 
	}
	
	public void setString(String name) {
		this.tempName = name;
	}

	public Double getNumber() {
		return tempNumber;
	}

	public void setNumber(Double tempNumber) {
		this.tempNumber = tempNumber;
	}
	
	//Fix FileRead Error
	@SuppressWarnings("resource")
	public boolean openFile() throws FixProblems, IOException {
		boolean flag = false;
		try {
			FileInputStream a1 = new FileInputStream(tempName);	
			flag = true;
		}
		catch(FileNotFoundException f) {
			throw new FixProblems(1);
		}
		finally {
			
		}
		return flag;
	}
	public boolean compare(String opSetName) throws FixProblems, IOException {
		boolean flag = false;
		try {
			this.getString().matches(opSetName);
			flag = true;
		}
		catch(PatternSyntaxException e){
			throw new FixProblems(2);
		}
		finally {
			
		}
		return flag;
	}
	
	public boolean parseValue() throws FixProblems, IOException {
		boolean flag = false; 
		try {
			this.tempNumber = Double.parseDouble(tempName);
			flag = true;
		}
		catch(NumberFormatException f) {
			throw new FixProblems(10);
		}
		finally {
			
		}
		return flag;
	}
	/*
	public boolean splitString(String temp) throws FixProblems {
		boolean flag = false;
		try {
			String[] tempSplit = temp.split(",");
			if(tempSplit[0] == null || tempSplit[0] == "") {
				
			}
			return false;
		}
		catch(PatternSyntaxException e) {
			
		}
		return flag;
	}
*/
}
