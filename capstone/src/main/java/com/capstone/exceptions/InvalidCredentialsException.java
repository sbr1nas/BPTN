package com.capstone.exceptions;

public class InvalidCredentialsException extends Exception {
	
	public InvalidCredentialsException() {
        	super("Invalid Credentials Exception");
    }
	
	public InvalidCredentialsException(String msg){
	    super(msg);
	}




}

