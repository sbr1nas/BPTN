package com.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.capstone.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping(value = "/admin/weather/archive/range/{fromDate}/{toDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> archiveWeatherDataToHistory(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate){
		try 
		{
			adminService.archiveWeatherDataToHistory(fromDate, toDate);
			return new ResponseEntity<>("Weather Data Archived", HttpStatus.OK);			
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value = "/admin/weather/archive/range/{fromDate}/{toDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteWeatherData(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate){
		try 
		{
			adminService.deleteWeatherData(fromDate, toDate);
			return new ResponseEntity<>("Weather Data Deleted", HttpStatus.OK);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
