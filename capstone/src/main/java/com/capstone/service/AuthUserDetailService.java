package com.capstone.service;

import org.springframework.transaction.annotation.Transactional;

import com.capstone.models.User;
import com.capstone.request.SignupRequest;


public interface AuthUserDetailService {

	 User login(String userName, String userPassword) throws Exception;
	 
	 @Transactional(rollbackFor = Exception.class)
	 User signup(SignupRequest signupRequest) throws Exception;
	 
}
