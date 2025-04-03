package department;

class NoSpecialtyException extends Exception{ // Exception for when there is no faculty member for the given program.
	
	/**
	 * Constructor for the user created exception.
	 */
	public NoSpecialtyException() {
		super();
	}
	
	/**
	 * overloaded Constructor for the user created exception to display message  .
	 */
	public NoSpecialtyException(String message) {
		super(message);
	}
}