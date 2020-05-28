package com.example.demo.controller.container;

public class Login {
	private String 用户;
	private String 权限;
	private boolean 错误;
	private String 警告;
	public boolean is错误() {
		return 错误;
	}
	public void set错误(boolean 错误) {
		this.错误 = 错误;
	}
	public String get警告() {
		return 警告;
	}
	public void set警告(String 警告) {
		this.警告 = 警告;
	}
	public String get用户() {
		return 用户;
	}
	public void set用户(String 用户) {
		this.用户 = 用户;
	}
	public String get权限() {
		return 权限;
	}
	public void set权限(String 权限) {
		this.权限 = 权限;
	}
}
