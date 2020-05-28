package com.example.demo.controller.parameter;

public class PSellerTimeUs {
	String seller,time,us;

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUs() {
		return us;
	}

	public void setUs(String us) {
		this.us = us;
	}

	public PSellerTimeUs(String seller, String time, String us) {
		super();
		this.seller = seller;
		this.time = time;
		this.us = us;
	}

	public PSellerTimeUs() {
		super();
	}
	
}
