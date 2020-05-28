package com.example.demo.controller.parameter;

public class AdminGet {
	String us;
	String 权限;
	String 状态;
	
	public AdminGet() {
		super();
	}

	public AdminGet(String us, String 状态) {
		super();
		this.us = us;
		this.状态 = 状态;
	}

	public String getUs() {
		return us;
	}

	public void setUs(String us) {
		this.us = us;
	}

	public String get权限() {
		return 权限;
	}

	public void set权限(String 权限) {
		this.权限 = 权限;
	}

	public String get状态() {
		return 状态;
	}

	public void set状态(String 状态) {
		this.状态 = 状态;
	}
	
}
