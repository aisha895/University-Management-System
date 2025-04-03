package department;

class Academics extends Person{
	
	//Setting up instance variables that all subclasses will share.
	protected int employeeID = 98;
	protected static int uniqueID = 1;
	protected double salary;
	boolean a = false;
	protected String program;

	
	/**
	 * 
	 * @return it returns the employeeID of the object.
	 */
	public int getEmployeeID(){
		return employeeID;
	}
	
	/**
	 * 
	 * @param academics is the object who's employeeID needs to be set.
	 */
	public void setEmployeeID(Academics academics) {
		employeeID += uniqueID;
	}
	
	/**
	 * 
	 * @return returns the salary of the object.
	 */
	public double getsalary() {
		return this.salary;
	}
	
	/**
	 * 
	 * @param salary is used to set the salary of the object.
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}