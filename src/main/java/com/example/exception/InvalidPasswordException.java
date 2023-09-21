package com.example.exception;

public class InvalidPasswordException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException(String message) {
        super(message);
    }
    
    // Add this constructor
    public InvalidPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
