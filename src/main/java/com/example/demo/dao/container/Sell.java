package com.example.demo.dao.container;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "selling")
@IdClass(SellKey.class)
public class Sell {
	@EmbeddedId
	private SellKey sellkey;
	@Id
	@Column(name = "用户")
	private String 用户;
	@Id
	@Column(name = "创建时间")
	private String 创建时间;
	@Column(name = "交易标题")
	private String 交易标题;
	@Column(name = "交易状态")
	private String 交易状态;
	public void setSellkey(SellKey sellkey) {
		this.sellkey = sellkey;
	}
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
	public String get交易标题() {
		return 交易标题;
	}
	public void set交易标题(String 交易标题) {
		this.交易标题 = 交易标题;
	}
	public String get交易状态() {
		return 交易状态;
	}
	public void set交易状态(String 交易状态) {
		this.交易状态 = 交易状态;
	}
	
}
