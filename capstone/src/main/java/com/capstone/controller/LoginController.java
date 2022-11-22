package com.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capstone.models.User;
import com.capstone.request.LoginRequest;
import com.capstone.request.SignupRequest;
import com.capstone.service.AuthUserDetailService;


@Controller
public class LoginController {

	@Autowired
	private AuthUserDetailService authUserDetailService;
	
	@PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>login(@RequestBody LoginRequest loginRequest ){
		try 
		{
			User user = authUserDetailService.login(loginRequest.getUsername(), loginRequest.getPassword());
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>("CREDENTIALS COULD NOT BE VALIDATED", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> signup(@RequestBody SignupRequest signup){
		try 
		{
			User user = authUserDetailService.signup(signup);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>("INVALID CREDENTIALS. NOT REGISTERED", HttpStatus.BAD_REQUEST);
		}
	}
}
