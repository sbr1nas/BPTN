package com.capstone.service;

import java.util.List;
import com.capstone.models.Weather;

public interface WeatherService {

	List<Weather> findWeatherByCityName(String cityName) throws Exception;
	
	Weather findWeatherByWeatherId(int id) throws Exception;
	
	List <Weather> findWeatherByUpdatedOn(String updatedOn)throws Exception;
	
	Weather createWeather(Weather weather) throws Exception;
	
	List<Weather> getWeatherFromWeatherAPI(String query) throws Exception; 
	
	List<Weather> findWeatherByCreatedOnBetween(String from, String to) throws Exception;
	
}
