package com.capstone.exceptions;

public class NoWeatherExistException extends Exception {

	public NoWeatherExistException(String msg){
	    super(msg);
	}

	public NoWeatherExistException(String msg, Throwable throwable){
	    super(msg, throwable);
	}

}
