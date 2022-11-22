package com.capstone.response;

public class CityResponse {

	private int id; 
	private String name; 
	private CoordResponse coord; 
	private String country;
	private Double population; 
	private Double timezone;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CoordResponse getCoord() {
		return this.coord;
	}
	public void setCoord(CoordResponse coord) {
		this.coord = coord;
	}
	public String getCountry() {
		return this.country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Double getPopulation() {
		return this.population;
	}
	public void setPopulation(Double population) {
		this.population = population;
	}
	public Double getTimezone() {
		return this.timezone;
	}
	public void setTimezone(Double timezone) {
		this.timezone = timezone;
	} 
	
}
