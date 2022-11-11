package com.example.bean;

public class Payment {

	private int PaymentID;
	private String PaymentType;
	private Long UserID;
	
	public Payment() {}

	public Payment(int paymentID, String paymentType, Long userID) {
		this.PaymentID = paymentID;
		this.PaymentType = paymentType;
		this.UserID = userID;
	}

	public int getPaymentID() {
		return this.PaymentID;
	}

	public void setPaymentID(int paymentID) {
		this.PaymentID = paymentID;
	}

	public String getPaymentType() {
		return this.PaymentType;
	}

	public void setPaymentType(String paymentType) {
		this.PaymentType = paymentType;
	}

	public Long getUserID() {
		return this.UserID;
	}

	public void setUserID(Long userID) {
		this.UserID = userID;
	}

	@Override
	public String toString() {
		return "Payment [PaymentID=" + this.PaymentID + ", PaymentType=" + this.PaymentType + ", UserID=" + this.UserID + "]";
	}
	
}
