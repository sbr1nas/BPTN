package com.capstone.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.exceptions.InvalidCredentialsException;
import com.capstone.exceptions.NoUserExistException;
import com.capstone.models.User;
import com.capstone.repository.UserRepository;
import com.capstone.service.UserService;
import com.capstone.util.BooleanToInt;

@Service
public class UserServiceImpl implements UserService {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User findUserByUserId(int userId) throws Exception {
		LOGGER.info("Checking if userID {} is a valid userID", userId);
		if(userId < 0) 
		{
			LOGGER.error("UserId: {} less than zero. INVALID", userId);
			throw new InvalidCredentialsException("Invalid UserId");
		}
		else 
		{
			LOGGER.info("UserID input valid. Fetching User from database");
			User user = userRepo.findUserByUserId(userId);
			if(user == null) 
			{
				LOGGER.error("USER WITH USERID: {} COULD NOT BE RETRIEVED FROM DATABASE", userId);
				throw new NoUserExistException("USER COULD NOT BE RETRIEVED FROM DATABASE");
			}
			else return user;
		}
		
	}

	@Override
	public User validateUserById(int userId) throws Exception {
		User user = findUserByUserId(userId); 
		return user;
	}

	@Override
	public void deleteUserById(int userId) throws Exception {
		LOGGER.info("Validating UserID: {} for deletion", userId);
		User user = validateUserById(userId);
		userRepo.delete(user);	
		LOGGER.info("User with UserID: {} has been deleted", userId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public User updateUserById(User user) throws Exception {
		validateUserProperties(user); 
		//no longer need this one; just for myself to see if I could get bit casting to work
		//userRepo.updateUserById(user.getFirstName(), user.getLastName(), user.getEmailId(), user.getUsername(), BooleanToInt.boolToInt(user.isAdmin()), user.getAddress(), user.getPhone(), user.getCityId(), user.getCreatedOn(), user.getUserId());
		userRepo.save(user);
		User updated = findUserByUserId(user.getUserId());
		return updated;
	}

	@Override
	public User createUser(User user) throws Exception {
		validateUserProperties(user);
		userRepo.save(user);
		return user;
	}

	@Override
	public User findUserByUsername(String username) throws Exception {
		LOGGER.info("Validating Username: {}", username);
		if(username == null || username.isEmpty()) 
		{
			LOGGER.error("Username: {} not valid", username);
			throw new InvalidCredentialsException("USERNAME NOT VALID"); 
		}
		else
		{
			LOGGER.info("Username: {} valid. Retrieving User", username);
			User user = userRepo.findUserByUsername(username);
			if(user == null) 
			{
				LOGGER.error("Retrieved User: {} NOT VALID", user);
				throw new NoUserExistException("USER COULD NOT BE RETRIEVED"); 
			}
			else 
			{
				LOGGER.info("Retrieved User: {} SUCCESSFULLY", user);
				return user; 
			}		
		}	
	}

	private User validateUserProperties(User user) throws Exception {
		LOGGER.info("Validating that User: {} is not null", user);
		if(user == null) 
		{
			LOGGER.error("User: {} INVALID PROPERTIES", user);
			throw new InvalidCredentialsException("INVALID USER PROPERTIES");
		}
		else if(user.getUsername() == null || user.getUserId() < 0) 
		{
			LOGGER.error("Username: {} or UserID: {} not valid", user.getUsername(), user.getUserId());
			throw new InvalidCredentialsException("INVALID USERNAME OR USERID");
		}
		else 
		{
			LOGGER.info("User: {} has been validated. Saving", user); 
		}		
		return user;
	}
}
