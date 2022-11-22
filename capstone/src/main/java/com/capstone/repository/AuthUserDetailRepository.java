package com.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.models.AuthUserDetail;
import com.capstone.models.User;

@Repository
public interface AuthUserDetailRepository extends JpaRepository<AuthUserDetail, Integer> {
	
	AuthUserDetail findAuthUserDetailByUserIdAndUserPassword(User user, String userPassword);

}
