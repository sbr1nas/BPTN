package com.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.models.WeatherHistory;
import com.capstone.service.HistoryService;


@Controller
public class WeatherHistoryController {

	@Autowired
	private HistoryService historyService;
	
	@GetMapping(value = "/weather/history/city/{cityName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getWeatherHistoryByCityName(@PathVariable("cityName") String cityName){
		try 
		{
			List<WeatherHistory> historyList = historyService.findWeatherByCityId(cityName);
			return new ResponseEntity<>(historyList, HttpStatus.OK);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/weather/history/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getWeatherHistoryById(@PathVariable("id") int id){
		try 
		{
			WeatherHistory hisWeather = historyService.findWeatherHistoryByWeatherId(id);
			return new ResponseEntity<>(hisWeather, HttpStatus.OK);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/weather/history/updatedon/{updatedOn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getWeatherHistoryByUpdatedOn(@PathVariable("updatedOn") String updatedOn){
		try 
		{
			List<WeatherHistory> historyList = historyService.findWeatherByUpdatedOn(updatedOn);
			return new ResponseEntity<>(historyList, HttpStatus.OK);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/weather/history/range/{fromDate}/{toDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getWeatherHistoryByCreatedOnBetween(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate){
		try 
		{
			List<WeatherHistory> hisList = historyService.findWeatherByCreatedOnBetween(fromDate, toDate);
			return new ResponseEntity<>(hisList, HttpStatus.OK);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
