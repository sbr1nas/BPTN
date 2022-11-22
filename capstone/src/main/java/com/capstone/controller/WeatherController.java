package com.capstone.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capstone.models.Weather;
import com.capstone.service.WeatherService;

@Controller
public class WeatherController {
	
	
	@Autowired
	private WeatherService weatherService;
	
	
	@GetMapping(value = "/weather/city/{cityName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getWeatherByCityName(@PathVariable("cityName") String cityName){
		try 
		{
			List<Weather> weatherList = weatherService.findWeatherByCityName(cityName); 
			return new ResponseEntity<>(weatherList, HttpStatus.OK); 
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/weather/id/{weatherId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getWeatherByWeatherId(@PathVariable("weatherId") int weatherId){
		try 
		{
			Weather weather = weatherService.findWeatherByWeatherId(weatherId);
			return new ResponseEntity<>(weather, HttpStatus.OK); 
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/weather/updatedon/{updatedOn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getWeatherByUpdatedOn(@PathVariable("updatedOn") String updatedOn){
		try 
		{
			List<Weather> weatherList = weatherService.findWeatherByUpdatedOn(updatedOn);
			return new ResponseEntity<>(weatherList, HttpStatus.OK); 
		}
		catch(Exception ex) 
		{
			ex.printStackTrace(); 
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/weather/range/{fromDate}/{toDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getWeatherCreatedOnBetween(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate){
		try 
		{
			List<Weather> weatherList = weatherService.findWeatherByCreatedOnBetween(fromDate, toDate);
			return new ResponseEntity<>(weatherList, HttpStatus.OK); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/weather/query/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getWeatherFromWeatherAPI(@PathVariable("city") String query){
		try 
		{
			List<Weather> weatherList = weatherService.getWeatherFromWeatherAPI(query); 
			return new ResponseEntity<>(weatherList, HttpStatus.OK); 
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/weather", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createWeather(@RequestBody Weather weather){
		try
		{
			Weather response = weatherService.createWeather(weather); 
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
