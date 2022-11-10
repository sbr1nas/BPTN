package com.example.bean;

import org.springframework.data.annotation.Id;

public class Books {
	@Id
	private int BookID;
	private String Title;
	private String Author;
	private double MSRP;
	
	public Books() {}
	
	public Books(int bookID, String title, String author, double mSRP) {
		this.BookID = bookID;
		this.Title = title;
		this.Author = author;
		this.MSRP = mSRP;
	}

	public int getBookID() {
		return this.BookID;
	}

	public void setBookID(int bookID) {
		this.BookID = bookID;
	}

	public String getTitle() {
		return this.Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public String getAuthor() {
		return this.Author;
	}

	public void setAuthor(String author) {
		this.Author = author;
	}

	public double getMSRP() {
		return this.MSRP;
	}

	public void setMSRP(double mSRP) {
		this.MSRP = mSRP;
	}

	@Override
	public String toString() {
		return "Books [BookID=" + this.BookID + ", Title=" + this.Title + ", Author=" + this.Author + ", MSRP=" + this.MSRP + "]";
	}
	

}
