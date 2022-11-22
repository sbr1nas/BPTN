package com.capstone.repository;

import java.time.Instant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.models.City;
import com.capstone.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByUserId(int userId);

	boolean existsById(int userId);
	
	User findUserByUsername(String username);
	
	
	
	
	
	
	
	
	//@Modifying(clearAutomatically=true)
	//@Query(value = "UPDATE public.\"User\" SET"
	//		+ "\"firstName\"=?, \"lastName\"=?, \"emailId\"=?, username=?, \"isAdmin\"=(CAST(? AS BIT)), address=?, phone=?, \"cityId\"=?, \"createdOn\"=? WHERE \"userId\"=?", nativeQuery=true)
	//void updateUserById(String firstName, String lastName, String emailId, String username, int isAdmin, String address, String phone, City cityId, Instant createdOn, int userId);  
	//this was only for me to see if I could get bit casting to work and it did; no longer needed as team changed it to boolean
	
	
	//@Modifying(clearAutomatically=true)
	//@Query(value = "INSERT INTO public.\"User\"(\r\n"
	//		+ "	\"userId\", \"firstName\", \"lastName\", \"emailId\", username, \"isAdmin\", address, phone, \"cityId\", \"createdOn\")\r\n"
	//		+ "	VALUES (?, ?, ?, ?, ?, (CAST(? AS BIT)), ?, ?, ?, ?);", nativeQuery=true)
	//void createUser(int userId, String firstName, String lastName, String emailId, String username, int isAdmin, String address, String phone, City cityId, Instant createdOn); 
	
}
