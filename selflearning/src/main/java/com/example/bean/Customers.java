package com.example.bean;

public class Customers {

	private Long id;
	private String name;
	private String email;
	
	public Customers () {}
	
	public Customers(Long id, String name, String email) {
		this.id = id; 
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customers [id=" + this.id + ", name=" + this.name + ", email=" + this.email + "]";
	}
	
}
