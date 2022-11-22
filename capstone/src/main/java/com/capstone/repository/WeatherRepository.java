package com.capstone.repository;

import java.util.List;
import java.time.Instant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.models.City;
import com.capstone.models.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
	
	List<Weather>findWeatherByCityId(City city); 
	
	List<Weather>findWeatherByUpdatedOn(Instant updatedOn);
	
	Weather findWeatherByWeatherId(int weatherId);
	
	List<Weather>findWeatherByCreatedOnBetween(Instant from, Instant to); 


}
