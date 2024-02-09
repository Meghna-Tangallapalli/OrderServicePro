package com.order.exception;


public class DataNotFoundException extends RuntimeException {
	
	private String message;

	public DataNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	

}
