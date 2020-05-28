package com.example.demo.dao.container;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "用户")
	private String 用户;
	@Column(name = "密码")
	private String 密码;
	@Column(name = "创建时间")
	private String 创建时间;
	@Column(name = "权限")
	private String 权限;
	@Column(name = "状态")
	private String 状态;
	public String get用户() {
		return 用户;
	}
	public void set用户(String 用户) {
		this.用户 = 用户;
	}
	public String 密码() {
		return 密码;
	}
	public void set密码(String 密码) {
		this.密码 = 密码;
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
}
