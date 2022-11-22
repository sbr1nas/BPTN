package com.capstone.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="\"City\"")
public class City implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"cityId\"", nullable=false)
	private int cityId;
	
	@Column(name="\"cityName\"")
	private String cityName;
	
	@Column(name="\"country\"")
	private String country;
	
	@Column(name="\"population\"")
	private String population;
	
	@Column(name="\"timezone\"")
	private String timezone;
	
	@Column(name="\"longitude\"")
	private double longitude;
	
	@Column(name="\"latitude\"")
	private double latitude;

	public City() {}
	
	public City(int cityId, String cityName, String country, String population, String timezone, double longitude,
			double latitude) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.country = country;
		this.population = population;
		this.timezone = timezone;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
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

	public String getPopulation() {
		return this.population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "City [cityId=" + this.cityId + ", cityName=" + this.cityName + ", country=" + this.country + ", population="
				+ this.population + ", timezone=" + this.timezone + ", longitude=" + this.longitude + ", latitude=" + this.latitude + "]";
	}
	
	
	
	

}
