package com.capstone.exceptions;

public class InvalidRequestException extends Exception {
	
	public InvalidRequestException() {
        super("Invalid Request Exception");
    }
	
	public InvalidRequestException(String msg){
	    super(msg);
	}


}
