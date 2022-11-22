package com.capstone.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.*;

@Entity
@Table(name="\"WeatherHistory\"")
public class WeatherHistory implements Serializable {

	@Id
	@Column(name="\"weatherId\"")
	private int weatherId; 
	
	@Column(name="\"name\"")
	private String name;
	
	@Column(name="\"description\"")
	private String description;
	
	@Column(name="\"icon\"")
	private String icon; 
	
	@Column(name="\"sunrise\"")
	private Instant sunrise; 
	
	@Column(name="\"sunset\"")
	private Instant sunset;
	
	@Column(name="\"tempMin\"")
	private BigDecimal tempMin;
	
	@Column(name="\"tempMax\"")
	private BigDecimal tempMax;
	
	@Column(name="\"tempDay\"")
	private BigDecimal tempDay;
	
	@Column(name="\"tempNight\"")
	private BigDecimal tempNight;
	
	@Column(name="\"tempMorning\"")
	private BigDecimal tempMorning;
	
	@Column(name="\"tempEvening\"")
	private BigDecimal tempEvening;
	
	@Column(name="\"feelsLikeDay\"")
	private BigDecimal feelsLikeDay;
	
	@Column(name="\"feelsLikeNight\"")
	private BigDecimal feelsLikeNight;
	
	@Column(name="\"feelsLikeMorning\"")
	private BigDecimal feelsLikeMorning;
	
	@Column(name="\"feelsLikeEvening\"")
	private BigDecimal feelsLikeEvening;
	
	@Column(name="\"precipitation\"")
	private BigDecimal precipitation;
	
	@Column(name="\"windSpeed\"")
	private BigDecimal windSpeed;
	
	@Column(name="\"windDirection\"")
	private BigDecimal windDirection;
	
	@Column(name="\"windGust\"")
	private BigDecimal windGust; 
	
	@Column(name="\"pressure\"")
	private BigDecimal pressure;
	
	@Column(name="\"humidity\"")
	private BigDecimal humidity; 
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "\"cityId\"", nullable = false)
	private City cityId; 
	
	@Column(name="\"updatedOn\"")
	private Instant updatedOn; 
	
	@Column(name="\"createdOn\"")
	private Instant createdOn; 
	
	public WeatherHistory() {}

	public WeatherHistory(int weatherId, String name, String description, String icon, Instant sunrise, Instant sunset, BigDecimal tempMin,
			BigDecimal tempMax, BigDecimal tempDay, BigDecimal tempNight, BigDecimal tempMorning, BigDecimal tempEvening, BigDecimal feelsLikeDay,
			BigDecimal feelsLikeNight, BigDecimal feelsLikeMorning, BigDecimal feelsLikeEvening, BigDecimal precipitation, BigDecimal windSpeed,
			BigDecimal windDirection, BigDecimal windGust, BigDecimal pressure, BigDecimal humidity, City cityId, Instant updatedOn, Instant createdOn) {
		this.weatherId = weatherId;
		this.name = name;
		this.description = description;
		this.icon = icon;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.tempDay = tempDay;
		this.tempNight = tempNight;
		this.tempMorning = tempMorning;
		this.tempEvening = tempEvening;
		this.feelsLikeDay = feelsLikeDay;
		this.feelsLikeNight = feelsLikeNight;
		this.feelsLikeMorning = feelsLikeMorning;
		this.feelsLikeEvening = feelsLikeEvening;
		this.precipitation = precipitation;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.windGust = windGust;
		this.pressure = pressure;
		this.humidity = humidity;
		this.cityId = cityId;
		this.updatedOn = updatedOn;
		this.createdOn = createdOn;
	}

	public City getCityId() {
		return this.cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
	}

	public int getWeatherId() {
		return this.weatherId;
	}

	public void setWeatherId(int weatherId) {
		this.weatherId = weatherId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Instant getSunrise() {
		return this.sunrise;
	}

	public void setSunrise(Instant sunrise) {
		this.sunrise = sunrise;
	}

	public Instant getSunset() {
		return this.sunset;
	}

	public void setSunset(Instant sunset) {
		this.sunset = sunset;
	}

	public BigDecimal getTempMin() {
		return this.tempMin;
	}

	public void setTempMin(BigDecimal tempMin) {
		this.tempMin = tempMin;
	}

	public BigDecimal getTempMax() {
		return this.tempMax;
	}

	public void setTempMax(BigDecimal tempMax) {
		this.tempMax = tempMax;
	}

	public BigDecimal getTempDay() {
		return this.tempDay;
	}

	public void setTempDay(BigDecimal tempDay) {
		this.tempDay = tempDay;
	}

	public BigDecimal getTempNight() {
		return this.tempNight;
	}

	public void setTempNight(BigDecimal tempNight) {
		this.tempNight = tempNight;
	}

	public BigDecimal getTempMorning() {
		return this.tempMorning;
	}

	public void setTempMorning(BigDecimal tempMorning) {
		this.tempMorning = tempMorning;
	}

	public BigDecimal getTempEvening() {
		return this.tempEvening;
	}

	public void setTempEvening(BigDecimal tempEvening) {
		this.tempEvening = tempEvening;
	}

	public BigDecimal getFeelsLikeDay() {
		return this.feelsLikeDay;
	}

	public void setFeelsLikeDay(BigDecimal feelsLikeDay) {
		this.feelsLikeDay = feelsLikeDay;
	}

	public BigDecimal getFeelsLikeNight() {
		return this.feelsLikeNight;
	}

	public void setFeelsLikeNight(BigDecimal feelsLikeNight) {
		this.feelsLikeNight = feelsLikeNight;
	}

	public BigDecimal getFeelsLikeMorning() {
		return this.feelsLikeMorning;
	}

	public void setFeelsLikeMorning(BigDecimal feelsLikeMorning) {
		this.feelsLikeMorning = feelsLikeMorning;
	}

	public BigDecimal getFeelsLikeEvening() {
		return this.feelsLikeEvening;
	}

	public void setFeelsLikeEvening(BigDecimal feelsLikeEvening) {
		this.feelsLikeEvening = feelsLikeEvening;
	}

	public BigDecimal getPrecipitation() {
		return this.precipitation;
	}

	public void setPrecipitation(BigDecimal precipitation) {
		this.precipitation = precipitation;
	}

	public BigDecimal getWindSpeed() {
		return this.windSpeed;
	}

	public void setWindSpeed(BigDecimal windSpeed) {
		this.windSpeed = windSpeed;
	}

	public BigDecimal getWindDirection() {
		return this.windDirection;
	}

	public void setWindDirection(BigDecimal windDirection) {
		this.windDirection = windDirection;
	}

	public BigDecimal getWindGust() {
		return this.windGust;
	}

	public void setWindGust(BigDecimal windGust) {
		this.windGust = windGust;
	}

	public BigDecimal getPressure() {
		return this.pressure;
	}

	public void setPressure(BigDecimal pressure) {
		this.pressure = pressure;
	}

	public BigDecimal getHumidity() {
		return this.humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public Instant getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Instant updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Instant getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Weather [weatherId=" + this.weatherId + ", name=" + this.name + ", description=" + this.description + ", icon=" + this.icon
				+ ", sunrise=" + this.sunrise + ", sunset=" + this.sunset + ", tempMin=" + this.tempMin + ", tempMax=" + this.tempMax
				+ ", tempDay=" + this.tempDay + ", tempNight=" + this.tempNight + ", tempMorning=" + this.tempMorning
				+ ", tempEvening=" + this.tempEvening + ", feelsLikeDay=" + this.feelsLikeDay + ", feelsLikeNight="
				+ this.feelsLikeNight + ", feelsLikeMorning=" + this.feelsLikeMorning + ", feelsLikeEvening=" + this.feelsLikeEvening
				+ ", precipitation=" + this.precipitation + ", windSpeed=" + this.windSpeed + ", windDirection=" + this.windDirection
				+ ", windGust=" + this.windGust + ", pressure=" + this.pressure + ", humidity=" + this.humidity + ", cityId=" + this.cityId
				+ ", updatedOn=" + this.updatedOn + ", createdOn=" + this.createdOn + "]";
	}
	
	
	
	
}
