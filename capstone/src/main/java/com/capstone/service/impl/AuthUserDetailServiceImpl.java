package com.capstone.service.impl;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.exceptions.InvalidCredentialsException;
import com.capstone.exceptions.NoUserExistException;
import com.capstone.models.AuthUserDetail;
import com.capstone.models.City;
import com.capstone.models.User;
import com.capstone.repository.AuthUserDetailRepository;
import com.capstone.repository.CityRepository;
import com.capstone.request.SignupRequest;
import com.capstone.service.AuthUserDetailService;
import com.capstone.service.UserService;

@Service
public class AuthUserDetailServiceImpl implements AuthUserDetailService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthUserDetailRepository authUserDetailRepo;
	
	@Autowired
	private UserService userService;

	
	@Autowired
	private CityRepository cityRepo;
	
	@Override
	public User login(String userName, String userPassword) throws Exception {
		log.info("Checking if Username: {} is valid input", userName);
		if(userName == null || userName.isEmpty()) 
		{
			log.error("Username Input Invalid");
			throw new InvalidCredentialsException("INVALID USERNAME");
		}
		else 
		{
			log.info("Checking if Password: {} is valid input", userPassword);
			if(userPassword == null || userPassword.isEmpty()) 
			{
				log.error("Password Input Invalid");
				throw new InvalidCredentialsException("INVALID PASSWORD");
			}
			else 
			{
				User user = userService.findUserByUsername(userName);
				//don't need to validate user because user service will and will throw exception fwd
					AuthUserDetail authUser = authUserDetailRepo.findAuthUserDetailByUserIdAndUserPassword(user, userPassword);
					log.info("Checking if retrived valid AuthUser Object: {}", authUser);
					if(authUser == null) 
					{
						log.error("AuthUser Object Invalid");
						throw new NoUserExistException("COULD NOT AUTHORIZE USER");
					}
					else 
					{
						return user; 
					}
				}
			}
		}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public User signup(SignupRequest signupRequest) throws Exception {
		City city = null; 
		User user = null;
		boolean userExists = true; 
		
		log.info("Checking if new user's city: {} exists in database already", signupRequest.getCityName());
		city = cityRepo.findCityByCityName(signupRequest.getCityName());
		if(city == null) 
		{
			log.info("New User's city does not exist; creating new city records");
			city = new City(); 
			city.setCountry(signupRequest.getCountry());
			city.setCityName(signupRequest.getCityName());
		}
		
		try 
		{
			log.info("User Already Exists in Database. Retrieving Records");
			user=userService.findUserByUsername(signupRequest.getUsername());
		}
		catch(Exception ex)
		{
			userExists=false; 
		}
		
		if(!userExists) 
		{
			log.info("User doesn't exist in database. Saving sign up user to database");
			user = new User();
			user.setUsername(signupRequest.getUsername());
			user.setAddress(signupRequest.getAddress());
			user.setEmailId(signupRequest.getEmailId());
			user.setCreatedOn(Instant.now());
			user.setFirstName(signupRequest.getFirstName());
			user.setLastName(signupRequest.getLastName());
			user.setAdmin(signupRequest.isAdmin());
			user.setPhone(signupRequest.getPhone() + "");
			
			log.info("Saving New AuthUserDetail to Database");
			AuthUserDetail authUserDetail = new AuthUserDetail();
			authUserDetail.setUsername(signupRequest.getUsername());
			authUserDetail.setPassword(signupRequest.getPassword());
			authUserDetail.setSecurityAnswer1(signupRequest.getSecurityAnswer1());
			authUserDetail.setSecurityAnswer2(signupRequest.getSecurityAnswer2());
			authUserDetail.setSecurityAnswer3(signupRequest.getSecurityAnswer3());
			authUserDetail.setSecurityQuestion1(signupRequest.getSecurityQuestion1());
			authUserDetail.setSecurityQuestion2(signupRequest.getSecurityQuestion2());
			authUserDetail.setSecurityQuestion3(signupRequest.getSecurityQuestion3());
			log.info("Finished Setting Authorized User Detail Object: {}", authUserDetail);
			
			city = cityRepo.save(city);
			log.info("New City Saved: {}", city);
			user.setCityId(city);
			try {
			    userService.createUser(user);
			    log.info("New User Saved: {}", user);
			    authUserDetail.setUserId(user);
			    authUserDetailRepo.save(authUserDetail);
			    log.info("New Auth UserDetails Saved: {}", authUserDetail);
			} catch (Exception e) {
			    log.error("Create user error");
			    log.error(e.toString());
			}
		}
		return user;		
	}
}
