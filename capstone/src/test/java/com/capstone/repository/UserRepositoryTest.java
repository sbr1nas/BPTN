package com.capstone.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capstone.AbstractTest;
import com.capstone.models.User;

public class UserRepositoryTest extends AbstractTest {

	@MockBean
	private UserRepository userRepo;
	
	private String username = "sbrie";
	private int userId = 4;
	private User user; 
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
		user = new User(); 
		user.setUsername(username);
		user.setUserId(userId);
	}
	
	@Test
	public void testFindUserByUsername() {
		when(userRepo.findUserByUsername(username)).thenReturn(user);
		User result = userRepo.findUserByUsername(username);
		assertEquals(username,result.getUsername());
		assertEquals(userId, (int)result.getUserId());
	}
	
	@Test
	public void testFindUserById() {
		when(userRepo.findUserByUserId(userId)).thenReturn(user);
		User result = userRepo.findUserByUserId(userId);
		assertEquals(username,result.getUsername());
		assertEquals(userId, (int)result.getUserId());
	}
}
