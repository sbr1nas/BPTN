package com.capstone.response;

import java.util.ArrayList;

public class WeatherApiResponse {
	
	private CityResponse city; 
	private String cod; 
	private Double message; 
	private Double cnt; 
	private ListResponse listResponse; 
	private ArrayList<Object> list = new ArrayList<>();
	
	public ListResponse getListResponse() {
		return this.listResponse;
	}
	public void setListResponse(ListResponse listResponse) {
		this.listResponse = listResponse;
	}
	
	public CityResponse getCity() {
		return this.city;
	}
	public void setCity(CityResponse city) {
		this.city = city;
	}
	public String getCod() {
		return this.cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public Double getMessage() {
		return this.message;
	}
	public void setMessage(Double message) {
		this.message = message;
	}
	public Double getCnt() {
		return this.cnt;
	}
	public void setCnt(Double cnt) {
		this.cnt = cnt;
	}
	
	 public ArrayList<Object> getList() { 
		  return this.list; 
	 } 
	 public void setList(ArrayList<Object> list){ 
		  this.list = list; 
	  }
	 
	
	@Override
	public String toString() {
		return "WeatherApiResponse [city=" + city + ", cod=" + cod + ", message=" + message + ", cnt=" + cnt
				+ ", listResponse=" + listResponse + "]";
	}
	
	
	//just to view logs
	
	

}
