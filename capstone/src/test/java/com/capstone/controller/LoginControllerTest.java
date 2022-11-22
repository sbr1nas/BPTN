package com.capstone.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any; 

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.capstone.AbstractTest;
import com.capstone.models.User;
import com.capstone.request.LoginRequest;
import com.capstone.request.SignupRequest;
import com.capstone.service.AuthUserDetailService;

public class LoginControllerTest extends AbstractTest {

	@MockBean
	private AuthUserDetailService authUserDetailService; 
	
	@Override
	@Before
	public void setUp() {
		super.setUp(); 
	}
	
	@Test
	public void loginTest() throws Exception{
		String uri = "/login"; 
		LoginRequest loginRequest = new LoginRequest(); 
		loginRequest.setPassword("sabTest1321");
		loginRequest.setUsername("sabTest123");
		
		String requestJson = mapToJson(loginRequest); 
		User user = new User(); 
		user.setUserId(999);
		when(authUserDetailService.login(Mockito.anyString(), Mockito.anyString())).thenReturn(user);
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).content(requestJson).contentType("application/json").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		User response = mapFromJson(mvcResult.getResponse().getContentAsString(), User.class); 
		assertEquals(200, status); 
		assertEquals(999, (int)response.getUserId()); 
	}
	
	@Test
	public void signupTest() throws Exception{
		String uri = "/signup"; 
		String signupRequest = 
				"{\"username\":\"sabTest\",\"password\":\"sabTest\",\"firstName\":\"Sleepless\",\"lastName\":\"Seattle\",\"emailId\":\"insomnia@nyquil.com\",\"isAdmin\":false,\"address\":\"overthemoon\",\"cityName\":\"City of Angles\",\"country\":\"Acute\",\"securityQuestion1\":\"What is question?\",\"securityQuestion2\":\"What is?\",\"securityQuestion3\":\"What?\",\"securityAnswer1\":\"Answer\",\"securityAnswer2\":\"Existential\",\"securityAnswer3\":\"Rude\"}";
		
		User user = new User(); 
		user.setUserId(222);
		when(authUserDetailService.signup(any(SignupRequest.class))).thenReturn(user); 
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).content(signupRequest).contentType("application/json").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus(); 
		User response = mapFromJson(mvcResult.getResponse().getContentAsString(), User.class); 
		assertEquals(200, status); 
		assertEquals(222, (int)response.getUserId()); 
	}
}
