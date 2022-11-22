package com.capstone.service.impl;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.capstone.exceptions.InvalidRequestException;
import com.capstone.exceptions.NoCityExistException;
import com.capstone.exceptions.NoWeatherExistException;
import com.capstone.models.City;
import com.capstone.models.Weather;
import com.capstone.repository.CityRepository;
import com.capstone.repository.WeatherRepository;
import com.capstone.response.WeatherApiResponse;
import com.capstone.service.WeatherService;
import com.capstone.util.ResponseToEntityMapping;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${api.key}")
	private String apiKey; 
	
	@Value("${api.base.url}")
	private String baseUrl; 
	
	@Autowired
	private WeatherRepository weatherRepo;

	@Autowired
	private CityRepository cityRepo;

	@Override
	public List<Weather> findWeatherByCityName(String cityName) throws Exception {
		log.info("Finding City by City Name: {}", cityName);
		City city = cityRepo.findCityByCityName(cityName);
		if(city == null)
		{
			log.error("CITY: {} NOT VALID INPUT", cityName);
			throw new NoCityExistException("NOT VALID INPUT FOR CITY NAME");
		}
		else 
		{
			log.info("City Input Valid. Retrieving Weather from Database");
			List<Weather> weatherList = weatherRepo.findWeatherByCityId(city);
			if(weatherList == null || weatherList.isEmpty()) 
			{
				log.error("Retrieved Weather Records Invalid");
				throw new NoWeatherExistException("NO WEATHER RECORDS RETRIEVED FROM DATABASE");
			}
			else 
			{
				log.info("Weather retrieved by City Name"); 
				return weatherList; 
			}
		}
	}

	@Override
	public Weather findWeatherByWeatherId(int id) throws Exception {
		log.info("Weather being retrieved by Weather ID: {}", id);
		Weather weather = weatherRepo.findWeatherByWeatherId(id);
		if(weather == null) 
		{
			log.error("Weather object not valid");
			throw new NoWeatherExistException("WEATHER COULD NOT BE RETRIEVED");
		}
		else 
		{
			log.info("Weather retrieved for Weather ID: {}", id);
			return weather;
		}
	}

	@Override
	public List<Weather> findWeatherByUpdatedOn(String updatedOn) throws Exception {
		log.info("Converting updatedOn: {} to Instant type", updatedOn);
		Instant instUpdatedOn = Instant.parse(updatedOn);
		
		log.info("Getting weather for updatedOn: {}", updatedOn);
		List<Weather> weatherList = weatherRepo.findWeatherByUpdatedOn(instUpdatedOn);
		if(weatherList == null || weatherList.isEmpty()) 
		{
			log.error("Retrieved Weather records invalid");
			throw new NoWeatherExistException("WEATHER RECORDS COULD NOT BE RETRIEVED");
		}
		else 
		{
			log.info("Weather retrieved for updatedOn: {}", updatedOn);
			return weatherList;
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Weather createWeather(Weather weather) throws Exception {
		if(weather == null) 
		{
			log.error("invalid weather record: {}", weather);
			throw new InvalidRequestException("INVALID WEATHER RECORD INPUT. NOT SAVED TO DATABASE");
		}
		else 
		{
			City city = weather.getCityId();
			if (city == null) 
			{
				log.error("invalid city retrieved from weather input: {}", city);
				throw new NoCityExistException("INVALID CITY INPUT. NOT SAVED TO DATABASE");
			}
			else 
			{
				log.info("Saving City object: {} to Database", city);
				cityRepo.save(city);
				log.info("Saving Weather object: {} to Database", weather);
				weatherRepo.save(weather); 
				return weather;
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Weather> getWeatherFromWeatherAPI(String query) throws Exception {
		log.info("Creating API url from query: {}", query);
		String url = buildApiUrl(query); 
		log.info("Created URL {}", url);
		
		List<Weather> weatherList = new LinkedList<>(); 
		log.info("Retrieving Weather and City info from 3rd Party API");
		WeatherApiResponse response = parseWeather(getWeatherFromOpenWeatherAPI(url)); 
		log.info("Converted API response to WeatherAPIResponse Object: {}", response.toString());
		Weather weather = ResponseToEntityMapping.weatherResponseMappingToWeatherEntity(response); 
		log.info("Converted Response Object to Weather object: {}", weather.toString());
		weatherList.add(weather); 
			
		log.info("Converting API response to City Object");
		City city = ResponseToEntityMapping.getCityMapping(response);
		log.info("Created City object: {}", city.toString());
		
		log.info("Storing Weather from API Response to Database");
		cityRepo.save(city);
		
		log.info("Storing Weather from API Response to Database");
		weatherRepo.save(weather); //have to save weather after city because of FK
		
		return weatherList;
	}

	private String buildApiUrl(String query) {
		StringBuilder url = new StringBuilder(); 
		url.append(baseUrl); 
		url.append("?cnt=1&mode=json&units=metric");
		url.append("&appid=" + apiKey); 
		url.append("&q=" + query); 
		
		return url.toString();
	}
	
	private WeatherApiResponse parseWeather(String weatherJsonString){
		JsonElement jsonElement = JsonParser.parseString(weatherJsonString);
		return new Gson().fromJson(jsonElement.getAsJsonObject(), WeatherApiResponse.class); 
	}
	
	private String getWeatherFromOpenWeatherAPI(String url){
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonElement jsonElement = JsonParser.parseString(result);
		String prettyJsonString = gson.toJson(jsonElement);
		return prettyJsonString;

	}

	@Override
	public List<Weather> findWeatherByCreatedOnBetween(String from, String to) throws Exception {
		log.info("Retrieving Weather Created on Date Range From: {} To: {}", from, to);
		List<Weather> weatherList = weatherRepo.findWeatherByCreatedOnBetween(Instant.parse(from), Instant.parse(to));
		log.info("Validating retrieved info");
		if(weatherList == null || weatherList.isEmpty()) 
		{
			log.error("Weather could not be retrieved for Created on Date Range From: {} To: {}", from, to);
			throw new NoWeatherExistException("WEATHER COULD NOT BE RETRIEVED FOR DATE RANGE"); 
		}
		else 
		{
			log.info("Validated");
			return weatherList; 
		}
	}	
	
}
