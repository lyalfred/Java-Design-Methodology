The following are the capabilities of the software:

	Although not implemented, the structure of the program allows it to
	read from multiple files, and create multiple automobile objects, storing
	each into a Linked Hash Map.
	
	The program is able to demonstrate allowing a user to choose an option
	from the available optionsets. In this version, only one option can be
	chosen. In future version, I will include a while loop that will end
	once the user has selected all of their choices.

Additions to the program from the previous version:
	In addition to the added Linked Hash Map, I wrote a new interface called
	SelectOptions, which handles the options the user selects.
		A new arraylist was added to ProxyAutomobile called 'choices' with
		datatype 'SelectedOptions'.
			When the user types in a option that they want to select, 
			it calls findOpSelectName and findOpSelectPrice in the Automobile
			class. These two methods search the opset and opt arraylist for the
			appropriate object. After locating, it returns the string/double value
			and is stored in a tempVariables. These tempVariables are then passed into
			SelectedOptions constructor.
			
			After this, the SelectedOptions object is pushed onto the choices arraylist.
		In future versions, I will write a calculateTotalPriceOfChoice method which will calculate
		the total price of all the chosen options in the 'choice' arraylist.

Note:
	I have not programmed Exception Handling for catching all invalid inputs when searching an arraylist. As a
	result, if the user inputs an invalid OptionSet or Option name, the program will run into a NullPointerException
	or ArrayListOutOfBoundsException.