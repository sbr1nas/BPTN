package com.capstone.exceptions;

public class NoWeatherHistoryExistException extends Exception {
	
	public NoWeatherHistoryExistException(String msg){
	    super(msg);
	}

	public NoWeatherHistoryExistException(String msg, Throwable throwable){
	    super(msg, throwable);
	}

}
