package com.capstone.repository;

import java.util.List;
import java.time.Instant;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.models.City;
import com.capstone.models.WeatherHistory;

public interface WeatherHistoryRepository extends JpaRepository<WeatherHistory, Integer> {

	List<WeatherHistory>findWeatherByCityId(City city);
	
	List<WeatherHistory>findWeatherByUpdatedOn(Instant updatedOn); 
	
	WeatherHistory findWeatherHistoryByWeatherId(int weatherId);
	
	List<WeatherHistory> findWeatherByCreatedOnBetween(Instant from, Instant to); 
}
