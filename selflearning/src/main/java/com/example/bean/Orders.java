package com.example.bean;

public class Orders {

	private int orderID; 
	private int bookID; 
	private Long customerID; 
	
	public Orders() {}

	public Orders(int orderID, int bookID, Long customerID) {
		this.orderID = orderID;
		this.bookID = bookID;
		this.customerID = customerID;
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

	public Long getCustomerID() {
		return this.customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	@Override
	public String toString() {
		return "Orders [orderID=" + this.orderID + ", bookID=" + this.bookID + ", customerID=" + this.customerID + "]";
	}
	
	
}
