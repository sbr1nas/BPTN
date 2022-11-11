package com.example.dto;

public class Cart {
//not in table - just a place to populate Cart object to place in ResponseBody 
	private int orderID;
	private int bookID;
	private String Title;
	private double MSRP;
	
	
	public Cart() {}

	public Cart(int orderID, int bookID, String title, double MSRP, double total) {
		this.orderID = orderID;
		this.bookID = bookID;
		this.Title = title;
		this.MSRP = MSRP;

	}

	
	public int getOrderID() {
		return this.orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getBookID() {
		return this.bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getTitle() {
		return this.Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public double getMSRP() {
		return this.MSRP;
	}

	public void setMSRP(double MSRP) {
		this.MSRP = MSRP;
	}

	@Override
	public String toString() {
		return "Cart [orderID=" + orderID + ", bookID=" + bookID + ", Title=" + Title + ", MSRP=" + MSRP + "]";
	}

	
}
