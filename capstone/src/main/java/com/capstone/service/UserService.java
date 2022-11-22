package com.capstone.service;

import com.capstone.models.User;


public interface UserService {
	
	User findUserByUserId(int userId) throws Exception;
	
	User validateUserById(int userId) throws Exception;
	
	void deleteUserById(int userId) throws Exception;
	
	User updateUserById(User user) throws Exception;
	
	User createUser(User user) throws Exception;
	
	User findUserByUsername(String username) throws Exception;

}
