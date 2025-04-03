package department;

class NoTAException extends Exception{ // Exception for when there is no TA in a faculty.
	
	/**
	 * Constructor for the user created exception.
	 */
	public NoTAException() {
		super();
	}
	
	/**
	 * overloaded Constructor for the user created exception to display message  .
	 */
	public NoTAException(String message) {
		super(message);
	}
}
