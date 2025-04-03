package department;

class ChairPerson extends Administrator{
	
	/**
	 * Overloaded constructor for the ChairPerson
	 * @param firstName is the first name of the chairPerson
	 * @param lastName is the last name of the chairPerson
	 * @param age
	 * @param gender
	 * @param address
	 */
	public ChairPerson(String firstName, String lastName, int age, String gender, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		uniqueID++;
		setEmployeeID(this);
		this.employeeID = getEmployeeID();

	}
	
	/**
	 * 
	 * @return is returns the chairPerson
	 */
	public ChairPerson getChairPerson() {
		return this;
	}
	
	
	/**
	 * @return returns the required string that shows information for the chairperson.
	 */
	@Override
	public String toString() {
		return "Chair Person [[[" + this.employeeID + ", " + this.salary + "[" + this.firstName +", " + this.lastName + 
				", " + this.age + ", " + this.gender + ", " + this.address + "]]]]";
	}
}
