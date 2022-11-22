package com.capstone.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.exceptions.NoUserExistException;
import com.capstone.exceptions.NoWeatherHistoryExistException;
import com.capstone.models.User;
import com.capstone.models.Weather;
import com.capstone.models.WeatherHistory;
import com.capstone.repository.UserRepository;
import com.capstone.repository.WeatherHistoryRepository;
import com.capstone.repository.WeatherRepository;
import com.capstone.service.AdminService;
import com.capstone.service.UserService;
import com.capstone.service.WeatherService;

@Service
public class AdminServiceImpl implements AdminService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private WeatherRepository weatherRepo;
	
	@Autowired
	private WeatherHistoryRepository weatherHistoryRepo;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void archiveWeatherDataToHistory(String fromDate, String toDate) throws Exception {
		log.info("Archiving Weather in Date Range From: {} To: {}", fromDate, toDate);
		List<Weather> weatherList = weatherService.findWeatherByCreatedOnBetween(fromDate, toDate); 
		List<WeatherHistory> historyList = new LinkedList<>(); 
		
		log.info("Converting Weather List to Weather History List: {}", historyList);
		for(Weather weather:weatherList) 
		{
			WeatherHistory history = new WeatherHistory(); 
			BeanUtils.copyProperties(weather, history);
			historyList.add(history);
		}
		if(historyList == null || historyList.isEmpty()) 
		{
			log.error("Archiving Unsuccessful");
			throw new NoWeatherHistoryExistException("WEATHER HISTORY COULD NOT BE ARCHIVED");
		}
		
		log.info("Finished Converting into History List: {}", historyList);
		
		log.info("Storing Weather into Weather History Database");
		weatherHistoryRepo.saveAll(historyList); 
		
		log.info("Deleting Weather from Current Weather Database");
		weatherRepo.deleteAll(weatherList); 	
		
	}

	@Override
	public void deleteWeatherData(String fromDate, String toDate) throws Exception {
		log.info("Deleting Weather in Date Range From: {} To: {}", fromDate, toDate);
		List<Weather> weatherList = weatherService.findWeatherByCreatedOnBetween(fromDate, toDate); 
		
		weatherRepo.deleteAll(weatherList); 
		log.info("Deleted Weather Records");	
	}

	@Override
	public void deleteUser(String username) throws Exception {
		log.info("Deleting User with Username: {}", username);
		User user = userService.findUserByUsername(username); 
		//don't need to check for null b/c user service method name will do it and throw exception
			userRepo.deleteById(user.getUserId());
			log.info("Deleted User with Username: {}", username);
			
	}

}
