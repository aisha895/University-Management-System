package department;

class UGrad extends Student{
	
	/**
	 * Overloaded constructor that sets the information for undergrad student.
	 * It also sets the StudentID of the undergrad student.
	 * @param firstName is the first name of the undergrad student object.
	 * @param lastName is the last name of the undergrad student object.
	 * @param age is the age of the undergrad student object.
	 * @param gender is the gender of the undergrad student object.
	 * @param address is the address of the undergrad student object.
	 */
	public UGrad(String firstName, String lastName, int age, String gender, String address) {
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
	 * @return returns the required string that shows information for the undergraduate.
	 */
	public String toString() {
		return "Undergraduate [" + this.studentID + "[[" + this.firstName + ", " + this.lastName + 
				", " + this.age + ", " + this.gender + ", " + this.address + "]]]";
	}
}
