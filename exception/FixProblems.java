package exception;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class FixProblems extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5416048973367196967L;
	private int errorno;
	private String errormsg;
	Scanner in = new Scanner(System.in);
	
	public FixProblems(int errorno) throws IOException {
		super();
		this.errorno = errorno;
		switch(errorno) {
		case 1:
			this.setErrormsg("File Not Found"); break;
		case 2:
			this.setErrormsg("OptionSet Name Not Found"); break;
		case 3:
			this.setErrormsg("Option Name Not Found"); break;
		case 4:
			this.setErrormsg("Error in Splitting String (Missing Option Name)"); break;
		case 5:
			this.setErrormsg("Error in parsing double from a string"); break;
		case 10:
			this.setErrormsg("Parsing double from string failed" ); break;
		case 11:
			this.setErrormsg("Error in Splitting String (Missing Option price)"); break;
			
		}
		this.printmyproblem();
	}
	
	public int getErrorno() {
		return this.errorno;
	}
		
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	
	public String getErrormsg() {
		return this.errormsg;
	}
	
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	public void printmyproblem() throws IOException{
		
		FileWriter fw = new FileWriter("errorlog.txt", true);
		BufferedWriter in = new BufferedWriter(fw);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd :: HH:mm.ss").format(new java.util.Date());
		System.out.println(timeStamp);
		String errorMsg = "Error Occured [errorno=" + this.getErrorno() + ", errormsg=" + this.getErrormsg() +"]";
		in.newLine();
		System.out.println(errorMsg); 
		in.write(timeStamp + errorMsg);
		in.close();
	}
	
	public String fixString(int num) {
		switch(num){
		case 1: 	System.out.println("Please enter valid file name");
			break;
		case 2:	    System.out.println("Please enter valid OptionSet name");
			break;
		case 3:		System.out.println("Please enter valid Option name");
			break;
		case 4:		System.out.println("Please enter Option Name");
			break;
		case 5:		System.out.println("Please enter valid double");
			break;
		default:
			break;
		}
		
		String temp = in.nextLine();
		return temp;
	}
	
	public Double fixDouble(int num) {
		switch(num){
		case 10: 	System.out.println("Please enter Option's price");	
			break;
		case 11:	
			break;
		case 12:	
			break;
		case 13:		
			break;
		case 14:
			break;
		default:
			break;
		}
		Double temp = in.nextDouble();
		return temp;
	}
	
}
