package com.cg.healthassist.exception;

public class AuthenticationException extends Exception {
	private String msg;

	public AuthenticationException(String msg) {
		super(msg);
	}
	
	

}