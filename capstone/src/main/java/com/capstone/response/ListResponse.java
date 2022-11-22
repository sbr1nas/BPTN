package com.capstone.response;

import java.util.ArrayList;

public class ListResponse {

	private Double dt; 
	private Double sunrise; 
	private Double sunset; 
	private TempResponse temp; 
	private FeelsLikeResponse feels_like;
	private Double pressure; 
	private Double humidity; 
	private ArrayList<Object> weather = new ArrayList<>(); 
	private Double speed;
	private Double deg; 
	private Double gust; 
	private Double clouds;
	private Double pop; 
	private Double rain;
	
	public Double getDt() {
		return this.dt;
	}
	public void setDt(Double dt) {
		this.dt = dt;
	}
	public Double getSunrise() {
		return this.sunrise;
	}
	public void setSunrise(Double sunrise) {
		this.sunrise = sunrise;
	}
	public Double getSunset() {
		return this.sunset;
	}
	public void setSunset(Double sunset) {
		this.sunset = sunset;
	}
	public TempResponse getTemp() {
		return this.temp;
	}
	public void setTemp(TempResponse temp) {
		this.temp = temp;
	}
	public FeelsLikeResponse getFeels_like() {
		return this.feels_like;
	}
	public void setFeels_like(FeelsLikeResponse feels_like) {
		this.feels_like = feels_like;
	}
	public Double getPressure() {
		return this.pressure;
	}
	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}
	public Double getHumidity() {
		return this.humidity;
	}
	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public ArrayList<Object> getWeather() { 
		return this.weather; 
	} 
	public void setWeather(ArrayList<Object> weather) { 
		this.weather = weather; 
	}

	public Double getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public Double getDeg() {
		return this.deg;
	}
	public void setDeg(Double deg) {
		this.deg = deg;
	}
	public Double getGust() {
		return this.gust;
	}
	public void setGust(Double gust) {
		this.gust = gust;
	}
	public Double getClouds() {
		return this.clouds;
	}
	public void setClouds(Double clouds) {
		this.clouds = clouds;
	}
	public Double getPop() {
		return this.pop;
	}
	public void setPop(Double pop) {
		this.pop = pop;
	}
	public Double getRain() {
		return this.rain;
	}
	public void setRain(Double rain) {
		this.rain = rain;
	}
	@Override
	public String toString() {
		return "ListResponse [dt=" + dt + ", sunrise=" + sunrise + ", sunset=" + sunset + ", temp=" + temp
				+ ", feels_like=" + feels_like + ", pressure=" + pressure + ", humidity=" + humidity + ", weather="
				+ weather + ", speed=" + speed + ", deg=" + deg + ", gust=" + gust + ", clouds=" + clouds + ", pop="
				+ pop + ", rain=" + rain + "]";
	}
}
