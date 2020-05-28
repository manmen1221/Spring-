package com.example.demo.controller.parameter;

public class AdminSet {
	String 用户;
	String 创建时间;
	String 权限;
	String 状态;
	public String get用户() {
		return 用户;
	}
	public void set用户(String 用户) {
		this.用户 = 用户;
	}
	public String get创建时间() {
		return 创建时间;
	}
	public void set创建时间(String 创建时间) {
		this.创建时间 = 创建时间;
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
	
	
	
	private String key;
	public void setKey(String key) {
		this.key=key;
	}
	public String UserKey() {
		return key;
	}
}
