package com.capstone.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any; 

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capstone.AbstractTest;
import com.capstone.models.AuthUserDetail;
import com.capstone.models.City;
import com.capstone.models.User;
import com.capstone.repository.AuthUserDetailRepository;
import com.capstone.repository.CityRepository;
import com.capstone.request.SignupRequest;

public class AuthUserDetailServiceTest extends AbstractTest {

	@MockBean
	private AuthUserDetailRepository authUserDetailRepo;
	
	@MockBean
	private UserService userService;
	
	@MockBean
	private CityRepository cityRepo;
	
	@Autowired
	private AuthUserDetailService authUserDetailService; 
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void loginTest() throws Exception{
		String username = "test";
		String userPassword = "test";
		User user = new User(); 
		user.setUserId(99);
		user.setUsername(username);
		when(userService.findUserByUsername(username)).thenReturn(user);
		
		AuthUserDetail authUser = new AuthUserDetail(); 
		authUser.setUserId(user);
		when(authUserDetailRepo.findAuthUserDetailByUserIdAndUserPassword(user, userPassword)).thenReturn(authUser);
		User result = authUserDetailService.login(username, userPassword);
		assertEquals(user, result);
	}

	@Test
	public void signupTest() throws Exception{
		String signupRequestJson = 
			"{\"username\":\"sbrie\",\"password\":\"@s@b@r@@\",\"firstName\":\"Sabrina\",\"lastName\":\"Seid\",\"emailId\":\"s.brina@netscape.ca\",\"address\":\"101 Makebelieve Dr\",\"cityName\":\"Rome\",\"country\":\"IT\",\"securityQuestion1\":\"Year of Birth\",\"securityQuestion2\":\"Place of Birth\",\"securityQuestion3\":\"Favourite Food\",\"securityAnswer1\":\"19??\",\"securityAnswer2\":\"Rome\",\"securityAnswer3\":\"peanut butter\"}";
			//changed string during office hours. remember to change it again!! this exists in database 
		SignupRequest signupRequest = mapFromJson(signupRequestJson, SignupRequest.class);
		AuthUserDetail authUser = new AuthUserDetail(); 
		authUser.setUserId(new User());
		when(authUserDetailRepo.save(any())).thenReturn(authUser); 
		
		City city = new City(); 
		when(cityRepo.findCityByCityName(signupRequest.getCityName())).thenReturn(city); 
		doThrow(Exception.class).when(userService).findUserByUsername(signupRequest.getUsername()); 
		when(cityRepo.save(city)).thenReturn(city); 
		when(userService.createUser(any())).thenReturn(authUser.getUserId()); 
		when(authUserDetailRepo.save(any())).thenReturn(authUser); 
		
		User user = authUserDetailService.signup(signupRequest); 
		assertEquals(authUser.getUserId(), user); 				    
	}
}
