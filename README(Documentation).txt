The following are the capabilities of the software:

	The program is able to implement interfaces, and build/print using the
	CreateAuto interface.
		This is demonstrated in Driver2.java (29-30)

	The program is able to update OptionSet's name, as well as Option's price
	using the UpdateAuto interface
		This is demonstrated in Driver2.java (35-38)
		Option name and Option price have been hard coded into the program to demonstrate
		the update methods.
	
	The program applies concepts of self-healing software, this is noted in
	the program's ability to recover if the user is trying to parse an invalid
	string. (This occurs in ReadSource.java)
		Several methods were written to implement self-healing concepts, for
		the parse-string method, a helper class (FixProblems) was written
		to delegate fixes for each method. (AutoException) was written 
		to implement the fixes.
	
Notes:
	Attempts were made to implement self-healing concepts in the findOptionSet method in
	Automobile.java. However, I was unsuccessful in implementing these methods
	as I could not figure out a way to test the new input after throwing an exception.
	I will research into this problem more on my own.
		However, because of this, if the user tries to input an OptionSet name, the program
		will encounter an NullPointerException. The findOptionSet method returns null
		if it is unable to find the OptionSet. Because the Update method calling this find method,
		the update will be trying to access an invalid arraylist index.
	
	Another attempt was made in implementing self-healing concepts for splitting a string
	using the "," delimiter (in ReadSource.java). However, I was unable to complete this method in time
	as it is taking me a while to figure out the design for the mechanism 
	behind testing the data in each array. (The index could be empty, which would
	result in an arrayindexoutofbounds exception if tried to access.

	
		