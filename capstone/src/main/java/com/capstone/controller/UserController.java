package com.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capstone.models.User;
import com.capstone.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/users/userid/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserById(@PathVariable("userId") int userId){
		try 
		{
			User user = userService.findUserByUserId(userId);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		} 
	}
	
	@GetMapping(value="/users/username/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserByUsername(@PathVariable("userName") String username){
		try 
		{
			User user = userService.findUserByUsername(username);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value="/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateUser(@RequestBody User user){
		try 
		{
			return new ResponseEntity<>(userService.updateUserById(user), HttpStatus.OK); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}

