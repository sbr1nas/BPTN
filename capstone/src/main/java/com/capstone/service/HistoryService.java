package com.capstone.service;

import java.util.List;

import com.capstone.models.WeatherHistory;

public interface HistoryService {

	List<WeatherHistory> findWeatherByCityId(String city) throws Exception; 
	
	List<WeatherHistory> findWeatherByUpdatedOn(String updatedOn) throws Exception; 
	
	WeatherHistory findWeatherHistoryByWeatherId(int weatherId) throws Exception; 
	
	List<WeatherHistory> findWeatherByCreatedOnBetween(String from, String to) throws Exception; 
}
