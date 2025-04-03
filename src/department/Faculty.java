package department;

import java.util.ArrayList;

class Faculty extends Academics implements Comparable<Object>{
	
	//All instance variables for Faculty class
	protected ArrayList<Student> advising;
	protected ArrayList<Student> TA;
	protected boolean populated = false; 
	
	/**
	 * Overloaded Faculty constructor that sets up the faculty. The employeeID is also set
	 * and the arraylist for advising and TA is initialised.
	 * @param firstName is the first name of the faculty object.
	 * @param lastName is the last name of the faculty object.
	 * @param age is the age of the faculty object.
	 * @param gender is the gender of the faculty object.
	 * @param address is the address of the faculty object.
	 */
	public Faculty(String firstName, String lastName, int age, String gender, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = this.firstName + this.lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		advising = new ArrayList<Student>();
		TA = new ArrayList<Student>();
		uniqueID++;
		setEmployeeID(this);
		this.employeeID = getEmployeeID();
	}
	
	/**
	 * 
	 * @param program is the program that is set for the faculty object.
	 */
	public void setProgram(String program) {
		this.program = program;
	}
	
	/**
	 * 
	 * @return it returns the program of the faculty object.
	 */
	public String getProgram() {
		return this.program;
	}
	
	/**
	 * @return returns the required string to view the Faculty information.
	 */
	@Override
	public String toString() {
		return "Faculty " + this.program + "[[" + this.employeeID + ", " + this.salary + "[" + this.firstName +", " + this.lastName + 
		                                     ", " + this.age + ", " + this.gender + ", " + this.address + "]]]";
	}
	
	/**
	 * 
	 * @param student is used to add the student to the current faculty object.
	 */
	public void setAdvising(Student student) {
		advising.add(student);
	}
	
	/**
	 * 
	 * @return returns the advising arrayList that the faculty has.
	 */
	public ArrayList<Student> getAdvisingUgrads() {
		return advising;
	}

	/**
	 * 
	 * @return returns the TA arrayList that the faculty has.
	 */
	public ArrayList<Student> getTAs() {
		return TA;
	}
	
	/**
	 * 
	 * @param student is the graduate student that is added as a TA for the current faculty.
	 */
	public void setTA(Student student) {
		TA.add(student);
	}

	/**
	 * 
	 * @return returns the number of advisees the current faculty has.
	 */
	public int getNumOfAdvisingUGrads() {
		return advising.size();
	}

	/**
	 * 
	 * @return returns the number of TA's the current faculty has.
	 */
	public int getNumOfTAs() {
		return TA.size();
	}
	
	/**
	 * Two objects are equal if they have the same employeeID, first name, last name, age, gender and address.
	 * @param object is the object to check if it is equal with.
	 * @return returns whether the current object and object are equal.
	 */
	@Override
	public boolean equals(Object object) {
		//Grad grad = (Grad) object;
		Faculty faculty = (Faculty) object;
			if(this.employeeID == faculty.employeeID && this.firstName == faculty.firstName 
					&& this.lastName == faculty.lastName && this.age == faculty.age
					&& this.gender == faculty.gender && this.address == faculty.address) {
				return true;
			}
			else {
				return false;
			}
	}

	/**
	 * compareTo checks if the fullName is the same or which string is greater than the other.
	 * @param o is the object to be compared to.
	 * @return returns an integer based on comparing the fullName of the object.
	 */
	@Override
	public int compareTo(Object o) {
		Faculty faculty = (Faculty) o;
		
		if(this.fullName == faculty.fullName) {
			return 0;
		}
		else if(this.fullName.compareTo(faculty.fullName) < 0){
			return -1;
		}
		else {
			return 1;
		}	
	}
}
