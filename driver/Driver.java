/*
             /////////// THIS IS THE OLD DRIVER FROM LAB 1  /////////// 

package driver;
import java.io.*;
import model.Automobile;
import util.ReadSource;

public class Driver {
	public static void main(String [] args) throws FileNotFoundException
	{
		ReadSource read = new ReadSource();
		Automobile FordZTW;
		//Build Automobile Object from a file.
		FordZTW = read.readFile("test.txt");
		
		//Print attributes before serialization
		System.out.print(FordZTW.toString());
		
		//Serialize the object.	
		try {
			ObjectOutputStream out = 
					new ObjectOutputStream(new FileOutputStream("auto.ser"));
		out.writeObject(FordZTW);
		out.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
		//Deserialize the object and read into memory.
		Automobile newFordZTW = null;
		try {
			FileInputStream fileIn = new FileInputStream("auto.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			newFordZTW = (Automobile) in.readObject();
			in.close();
			fileIn.close();
			newFordZTW.toString();
		}
		catch(ClassNotFoundException | IOException c) {
			System.out.println("Automotive class not found");
			c.printStackTrace();
			return;
		} 
		//Print new attributes.
		System.out.println("\nNOW PRINTING DESERIALIZED OBJECT\n");
		System.out.print(newFordZTW.toString()); 

	}

}

*/