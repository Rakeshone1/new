package com.wipro.exception;

public class ResourceNotFoundException extends RuntimeException {
	private static String msg;

	public ResourceNotFoundException(String string) {
		super(msg);
	}

	

}
