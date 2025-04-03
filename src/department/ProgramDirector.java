package department;

class ProgramDirector extends Administrator{
	
	/**
	 * Overloaded constructor to set up the ProgramDirector
	 * @param firstName is the first name Of the programDirector
	 * @param lastName is the last name Of the programDirector
	 * @param age is the age Of the programDirector
	 * @param gender is the gender Of the programDirector
	 * @param address is the address Of the programDirector
	 */
	public ProgramDirector(String firstName, String lastName, int age, String gender, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	/**
	 * 
	 * @param program sets the program for the programDirector 
	 */
	public void setProgram(String program) {
		this.program = program;		
	}
}
