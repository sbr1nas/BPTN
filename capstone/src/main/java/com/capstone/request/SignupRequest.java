package com.capstone.request;

public class SignupRequest {

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String emailId;
	private boolean isAdmin;
	private String address;
	private String cityName;
	private String country;
	private long phone;
	private String securityQuestion1;
	private String securityQuestion2;
	private String securityQuestion3;
	private String securityAnswer1;
	private String securityAnswer2;
	private String securityAnswer3;
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getCityName() {
		return this.cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountry() {
		return this.country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPhone() {
		return this.phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
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
		return "SignupRequest [username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId + ", isAdmin=" + isAdmin + ", address=" + address
				+ ", cityName=" + cityName + ", country=" + country + ", phone=" + phone + ", securityQuestion1="
				+ securityQuestion1 + ", securityQuestion2=" + securityQuestion2 + ", securityQuestion3="
				+ securityQuestion3 + ", securityAnswer1=" + securityAnswer1 + ", securityAnswer2=" + securityAnswer2
				+ ", securityAnswer3=" + securityAnswer3 + "]";
	}
	
	
}
