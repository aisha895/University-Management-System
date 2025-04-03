package department;

class Person{
	
	//Setting up variables that all subclasses will share
	protected String firstName;
	protected String lastName;
	protected String fullName;
	protected int age;
	protected String gender;
	protected String address;
	
	
	/**
	 * 
	 * @return the firstName of the person object
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * 
	 * @param firstName is used to set the firstName to the person object.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * 
	 * @return it returns the lastName of the person object.
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * 
	 * @param lastName is used to set the lastName of the person object.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * 
	 * @return it returns the age of the person object.
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * 
	 * @param age sets the age of the person object.
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * 
	 * @return it returns the gender of the person object.
	 */
	public String getGender() {
		return this.gender;
	}
	
	/**
	 * 
	 * @param gender is used to set the gender of the person object.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * 
	 * @return it returns the address of the person object.
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * 
	 * @param address is used to set the address of the person object.
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}

