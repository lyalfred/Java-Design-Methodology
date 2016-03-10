package scale;

import adapter.*;
import exception.*;

public class EditOptions extends Thread implements CreateAuto, SelectAuto, UpdateAuto {
	private BuildAuto buildAuto;
	
	public EditOptions(BuildAuto buildAuto){
		this.buildAuto = buildAuto;
	}

	@Override
	public void updateOptSetName(String autoModel, String OptionSetname, String newName) throws FixProblems {
		buildAuto.updateOptSetName(autoModel, OptionSetname, newName);
	}

	@Override
	public void updateOptionPrice(String autoModel, String OptionSetname, String Option, double newprice) throws FixProblems {
		buildAuto.updateOptionPrice(autoModel, OptionSetname, Option, newprice);
	}

	@Override
	public void selectOptionSet() throws FixProblems {
		buildAuto.selectOptionSet();
	}

	@Override
	public void BuildAuto(String filename) throws FixProblems {
		buildAuto.BuildAuto(filename);
	}

	@Override
	public void printAuto(String autoModel) throws FixProblems {
		buildAuto.printAuto(autoModel);
	}

	




}
