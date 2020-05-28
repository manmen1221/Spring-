package com.example.demo.dao.container;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "buying")
@IdClass(BuyKey.class)
public class BuyX {
	@EmbeddedId
	private BuyKey buykey;
	@Id
	@Column(name = "卖家")
	private String 卖家;
	@Id
	@Column(name = "创建时间")
	private String 创建时间;
	@Id
	@Column(name = "买家")
	private String 买家;
	@Id
	@Column(name = "申请时间")
	private String 申请时间;
	@Column(name = "申请状态")
	private String 申请状态;
	@Column(name = "申请备注")
	private String 申请备注;
	@Column(name = "购买评价")
	private String 购买评价;
	public void set卖家(String 卖家) {
		this.卖家 = 卖家;
	}
	public void set创建时间(String 创建时间) {
		this.创建时间 = 创建时间;
	}
	public String get买家() {
		return 买家;
	}
	public void set买家(String 买家) {
		this.买家 = 买家;
	}
	public String get申请时间() {
		return 申请时间;
	}
	public void set申请时间(String 申请时间) {
		this.申请时间 = 申请时间;
	}
	public String get申请状态() {
		return 申请状态;
	}
	public void set申请状态(String 申请状态) {
		this.申请状态 = 申请状态;
	}
	public void setBuykey(BuyKey buykey) {
		this.buykey = buykey;
	}
	public String get申请备注() {
		return 申请备注;
	}
	public void set申请备注(String 申请备注) {
		this.申请备注 = 申请备注;
	}
	public String get购买评价() {
		return 购买评价;
	}
	public void set购买评价(String 购买评价) {
		this.购买评价 = 购买评价;
	}
	public String get卖家() {
		return 卖家;
	}
	public String get创建时间() {
		return 创建时间;
	}


	@Transient
	private String key;
	public void setKey(String key) {
		this.key=key;
	}
	public String UserKey() {
		return key;
	}
}
