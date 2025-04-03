package department;

class Grad extends Student{
	
	/**
	 * Overloaded constructor to set the attributes of the graduate class.
	 * It also sets the StudentID of the graduate student.
	 * @param firstName is the firstName of the graduate student.
	 * @param lastName is the lastName of the graduate student.
	 * @param age is the age of the graduate student.
	 * @param gender is the gender of the graduate student.
	 * @param address is the address of the graduate student.
	 */
	public Grad(String firstName, String lastName, int age, String gender, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = this.firstName + this.lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		uniqueID++;
		setStudentID(this);
		this.studentID = getStudentID();
	}
	

	/**
	 * @return returns the required string that shows information for the graduate student.
	 */
	public String toString() {
		return "Graduate [" + this.studentID + "[[" + this.firstName + ", " + this.lastName + 
				", " + this.age + ", " + this.gender + ", " + this.address + "]]]";
	}
}