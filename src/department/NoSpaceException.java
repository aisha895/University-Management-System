package department;

class NoSpaceException extends Exception{ // Exception for when there is no space.
	
	/**
	 * constructor for user created exception.
	 */
	public NoSpaceException() {
		super();
	}
	
	/**
	 * overloaded Constructor for the user created exception to display message  .
	 */
	public NoSpaceException(String message) {
		super(message);
	}
}