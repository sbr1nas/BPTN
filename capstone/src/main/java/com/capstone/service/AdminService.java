package com.capstone.service;


public interface AdminService {

	void archiveWeatherDataToHistory(String fromDate, String toDate)throws Exception;
	
	void deleteWeatherData(String fromDate, String toDate)throws Exception;
	
	void deleteUser(String username)throws Exception; 
}
