package com.capstone.service.impl;

import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.exceptions.InvalidRequestException;
import com.capstone.exceptions.NoCityExistException;
import com.capstone.exceptions.NoWeatherHistoryExistException;
import com.capstone.models.City;
import com.capstone.models.WeatherHistory;
import com.capstone.repository.CityRepository;
import com.capstone.repository.WeatherHistoryRepository;
import com.capstone.service.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CityRepository cityRepo; 
	
	@Autowired
	private WeatherHistoryRepository weatherHistoryRepo; 
	
	@Override
	public List<WeatherHistory> findWeatherByCityId(String city) throws Exception {
		log.info("Retrieving City by City Name: {}", city);
		City cityResult = cityRepo.findCityByCityName(city);
		
		log.info("Validating City Records");
		if(cityResult == null) 
		{
			log.error("City Record Invalid");
			throw new NoCityExistException("COULD NOT RETRIEVE CITY INFO FROM DATABASE"); 
		}
		else 
		{
			log.info("City Record Validated. Retrieving Weather for City: {}", city);
			List<WeatherHistory> weatherList = weatherHistoryRepo.findWeatherByCityId(cityResult); 
			
			log.info("Validating Retrieved Weather Records");
			if(weatherList == null || weatherList.isEmpty()) 
			{
				log.error("Weather Could Not Be Retrieved for City: {}", city); 
				throw new NoWeatherHistoryExistException("WEATHER RECORDS COULD NOT BE RETRIEVED FROM DATABASE"); 
			}
			else 
			{
				log.info("Weather Records Validated");
				return weatherList; 
			}
		}
	}

	@Override
	public List<WeatherHistory> findWeatherByUpdatedOn(String updatedOn) throws Exception {
		log.info("Getting Weather by Updated on Date: {}", updatedOn);
		List<WeatherHistory>historyList = weatherHistoryRepo.findWeatherByUpdatedOn(Instant.parse(updatedOn));
		
		log.info("Validating Retrieved Records");
		if(historyList == null || historyList.isEmpty()) 
		{
			log.error("Invalid Weather History Records Retrieved");
			throw new NoWeatherHistoryExistException("WEATHER HISTORY FOR UPDATED ON DATE COULD NOT BE RETRIEVED");
		}
		else 
		{
			log.info("Validated");
			return historyList;
		}
	}

	@Override
	public WeatherHistory findWeatherHistoryByWeatherId(int weatherId) throws Exception {
		log.info("Validating Weather ID: {}", weatherId);
		if(weatherId < 0) 
		{
			log.error("Invalid Weather ID");
			throw new InvalidRequestException("INVALID WEATHER ID"); 	
		}
		else 
		{
			log.info("Weather ID validated. Retrieving Weather History"); 
			WeatherHistory history = weatherHistoryRepo.findWeatherHistoryByWeatherId(weatherId);
			log.info("Validating retrieved records");
			if(history == null) 
			{
				log.error("Invalid Weather History");
				throw new NoWeatherHistoryExistException("WEATHER HISTORY COULD NOT BE RETRIEVED"); 
			}
			else 
			{
				return history; 
			}
		}
	}

	@Override
	public List<WeatherHistory> findWeatherByCreatedOnBetween(String from, String to) throws Exception {
		log.info("Retrieving Weather History for Date Range From: {} To: {}", from, to);
		List<WeatherHistory> historyList = weatherHistoryRepo.findWeatherByCreatedOnBetween(Instant.parse(from), Instant.parse(to)); 
		
		log.info("Validating retrieved records"); 
		if(historyList == null || historyList.isEmpty()) 
		{
			log.error("Records invalid for Date Range From: {} To: {}", from, to);
			throw new NoWeatherHistoryExistException("WEATHER HISTORY FOR DATE RANGE COULD NOT BE RETRIEVED");
		}
		else 
		{
			log.info("Validated"); 
			return historyList; 
		}
	}

}
