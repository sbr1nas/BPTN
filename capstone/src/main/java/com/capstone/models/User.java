package com.capstone.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name= "\"User\"")
public class User implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"userId\"", nullable=false)
	private int userId; 
	
	@Column(name="\"firstName\"")
	private String firstName;
	
	@Column(name="\"lastName\"")
	private String lastName; 
	
	@Column(name="\"emailId\"")
	private String emailId; 
	
	@Column(name="\"username\"")
	private String username;
	
	@Column(name="\"isAdmin\"")
	private boolean isAdmin;
	
	@Column(name="\"address\"")
	private String address;
	
	@Column(name="\"phone\"")
	private String phone;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "\"cityId\"", nullable = false)
	private City cityId; 
	
	@Column(name="\"createdOn\"")
	private Instant createdOn;

	public User() {}; 
	
	public User(int userId, String firstName, String lastName, String emailId, String username, boolean isAdmin,
			String address, String phone, City cityId, Instant createdOn) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.username = username;
		this.isAdmin = isAdmin;
		this.address = address;
		this.phone = phone;
		this.cityId = cityId;
		this.createdOn = createdOn;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAdmin() {
		return this.isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public City getCityId() {
		return this.cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
	}

	public Instant getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "User [userId=" + this.userId + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", emailId=" + this.emailId
				+ ", username=" + this.username + ", isAdmin=" + this.isAdmin + ", address=" + this.address + ", phone=" + this.phone
				+ ", cityId=" + this.cityId + ", createdOn=" + this.createdOn + "]";
	}
	
	

}
