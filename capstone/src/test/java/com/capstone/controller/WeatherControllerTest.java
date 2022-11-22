package com.capstone.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.capstone.AbstractTest;
import com.capstone.models.City;
import com.capstone.models.Weather;
import com.capstone.repository.CityRepository;
import com.capstone.repository.WeatherRepository;
import com.google.gson.JsonParser;

public class WeatherControllerTest extends AbstractTest {

	@MockBean
	private CityRepository cityRepo;
	
	@MockBean
	private WeatherRepository weatherRepo;
	
	@Override
	@Before
	public void setUp() {
		super.setUp(); 
	}
	
	@Test
	public void weatherQueryTest() throws Exception {
		String country = "London"; 
		String uri = "/weather/query/" + country; 
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).contentType("application/json").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		when(cityRepo.save(any())).thenReturn(new City());
		when(weatherRepo.save(any())).thenReturn(new Weather());
		
		String result = JsonParser.parseString(mvcResult.getResponse().getContentAsString()).getAsJsonArray().get(0).getAsJsonObject().get("name").toString();
		result = result.replaceAll("\"", "");
		assertEquals(country, result); 
	}
}
