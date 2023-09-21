package com.example.util;

public class ApiResponse<T> {
    private boolean success;
    private T data;
    private String message;
    
    
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ApiResponse(boolean success, T data, String message) {
		super();
		this.success = success;
		this.data = data;
		this.message = message;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
    
    

    // Constructors, getters, and setters
}