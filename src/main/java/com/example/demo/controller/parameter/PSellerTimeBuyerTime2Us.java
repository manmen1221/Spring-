package com.example.demo.controller.parameter;

public class PSellerTimeBuyerTime2Us {
	String seller,time,buyer,time2,us;

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

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getUs() {
		return us;
	}

	public void setUs(String us) {
		this.us = us;
	}

	public PSellerTimeBuyerTime2Us(String seller, String time, String buyer, String time2, String us) {
		super();
		this.seller = seller;
		this.time = time;
		this.buyer = buyer;
		this.time2 = time2;
		this.us = us;
	}

	public PSellerTimeBuyerTime2Us() {
		super();
	}
	
}
