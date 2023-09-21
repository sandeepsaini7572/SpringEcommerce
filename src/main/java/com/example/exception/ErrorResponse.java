package com.example.exception;

public class ErrorResponse {
    private String message;
    private int statusCode;

    // Constructors, getters, and setters
    
    // Default constructor
    public ErrorResponse() {
    }
    
    public ErrorResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
    
    // Getters and setters
    
    
}
