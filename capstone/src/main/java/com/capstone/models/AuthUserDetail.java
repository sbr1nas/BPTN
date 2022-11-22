package com.capstone.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="\"AuthUserDetail\"")
public class AuthUserDetail implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"authId\"", nullable=false)
	private int authId; 
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "\"userId\"", nullable = false)
	private User userId; 
	
	@Column(name="\"userName\"")
	private String username; 
	
	@Column(name="\"userPassword\"")
	private String userPassword; 
	
	@Column(name="\"securityQuestion1\"")
	private String securityQuestion1; 
	
	@Column(name="\"securityQuestion2\"")
	private String securityQuestion2; 
	
	@Column(name="\"securityQuestion3\"")
	private String securityQuestion3; 
	
	@Column(name="\"securityAnswer1\"")
	private String securityAnswer1; 
	
	@Column(name="\"securityAnswer2\"")
	private String securityAnswer2; 
	
	@Column(name="\"securityAnswer3\"")
	private String securityAnswer3; 
	
	public AuthUserDetail() {}

	public AuthUserDetail(int authId, User userId, String username, String userPassword, String securityQuestion1,
			String securityQuestion2, String securityQuestion3, String securityAnswer1, String securityAnswer2,
			String securityAnswer3) {
		this.authId = authId;
		this.userId = userId;
		this.username = username;
		this.userPassword = userPassword;
		this.securityQuestion1 = securityQuestion1;
		this.securityQuestion2 = securityQuestion2;
		this.securityQuestion3 = securityQuestion3;
		this.securityAnswer1 = securityAnswer1;
		this.securityAnswer2 = securityAnswer2;
		this.securityAnswer3 = securityAnswer3;
	}

	public int getAuthId() {
		return this.authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public User getUserId() {
		return this.userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.userPassword;
	}

	public void setPassword(String password) {
		this.userPassword = password;
	}

	public String getSecurityQuestion1() {
		return this.securityQuestion1;
	}

	public void setSecurityQuestion1(String securityQuestion1) {
		this.securityQuestion1 = securityQuestion1;
	}

	public String getSecurityQuestion2() {
		return this.securityQuestion2;
	}

	public void setSecurityQuestion2(String securityQuestion2) {
		this.securityQuestion2 = securityQuestion2;
	}

	public String getSecurityQuestion3() {
		return this.securityQuestion3;
	}

	public void setSecurityQuestion3(String securityQuestion3) {
		this.securityQuestion3 = securityQuestion3;
	}

	public String getSecurityAnswer1() {
		return this.securityAnswer1;
	}

	public void setSecurityAnswer1(String securityAnswer1) {
		this.securityAnswer1 = securityAnswer1;
	}

	public String getSecurityAnswer2() {
		return this.securityAnswer2;
	}

	public void setSecurityAnswer2(String securityAnswer2) {
		this.securityAnswer2 = securityAnswer2;
	}

	public String getSecurityAnswer3() {
		return this.securityAnswer3;
	}

	public void setSecurityAnswer3(String securityAnswer3) {
		this.securityAnswer3 = securityAnswer3;
	}

	@Override
	public String toString() {
		return "AuthUserDetail [authId=" + this.authId + ", userId=" + this.userId + ", username=" + this.username + ", password="
				+ this.userPassword + ", securityQuestion1=" + this.securityQuestion1 + ", securityQuestion2=" + this.securityQuestion2
				+ ", securityQuestion3=" + this.securityQuestion3 + ", securityAnswer1=" + this.securityAnswer1
				+ ", securityAnswer2=" + this.securityAnswer2 + ", securityAnswer3=" + this.securityAnswer3 + "]";
	}
	
	
	
}
