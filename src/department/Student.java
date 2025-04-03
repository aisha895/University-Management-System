package department;

import java.util.ArrayList;

class Student extends Person implements Comparable<Object>{
	
	//All instance variables of the student class
	protected static int uniqueID = 1;
	protected int studentID = 998;
	ArrayList<Student> students = new ArrayList<Student>();;
	Faculty faculty;
	
	
	/**
	 * 
	 * @return it returns the studentId of the current Object
	 */
	public int getStudentID(){
		return studentID;
	}
	
	/**
	 * 
	 * @param student is used to set the StudentID of the current Object
	 */
	public void setStudentID(Student student) {
		studentID += uniqueID;
	}
	
	/**
	 * 
	 * @param faculty is used to set the faculty of the current student object.
	 */
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	/**
	 * 
	 * @return it returns the faculty the student belongs to.
	 */
	public Faculty getAdvisor() {
		return this.faculty;
	}
	
	/**
	 * 
	 * @param student is the student who's faculty should be removed.
	 */
	public void removeFaculty(Student student) {
		student.faculty = null;
	}
	
	/**
	 * @param object is the object to check if it is equal with.
	 * @return returns whether the current object and object are equal.	 
	 */
	@Override
	public boolean equals(Object object) {
		//Grad grad = (Grad) object;
		Student grad = (Student) object;
		Student t = (Student) this;
			if(this.studentID == grad.studentID && this.firstName == grad.firstName 
					&& this.lastName == grad.lastName && this.age == grad.age
					&& this.gender == grad.gender && this.address == grad.address) {
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
		Student grad = (Student) o;
		
		if(this.fullName == grad.fullName) {
			return 0;
		}
		else if(this.fullName.compareTo(grad.fullName) < 0){
			return -1;
		}
		else {
			return 1;
		}
		
	}
}
