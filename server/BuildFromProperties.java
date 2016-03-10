package server;

import java.io.*;
import adapter.*;
import exception.*;
import util.*;

public class BuildFromProperties implements AutoServer {
	private BuildAuto buildAuto;
	
	@Override
	public void userAutoProperties(Properties properties) throws ClassNotFoundException, FixProblems {
		// TODO Auto-generated method stub
		this.userAutoProperties(properties);
	}
	
	public BuildFromProperties(BuildAuto buildAuto){
		this.buildAuto = buildAuto;
	}
	
	public void print(String auto){
		buildAuto.printAuto(auto);
	}

}
