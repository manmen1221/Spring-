package com.example.demo.dao.container;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BuyKey implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "卖家",insertable=false,updatable=false)
    private String 卖家;
	@Column(name = "创建时间",insertable=false,updatable=false)
    private String 创建时间;
	@Column(name = "买家",insertable=false,updatable=false)
    private String 买家;
	@Column(name = "申请时间",insertable=false,updatable=false)
    private String 申请时间;
	
	public BuyKey() {
	}
	public BuyKey(String 卖家, String 创建时间, String 买家, String 申请时间) {
		super();
		this.卖家 = 卖家;
		this.创建时间 = 创建时间;
		this.买家 = 买家;
		this.申请时间 = 申请时间;
	}
	public String get卖家() {
		return 卖家;
	}
	public void set卖家(String 卖家) {
		this.卖家 = 卖家;
	}
	public String get创建时间() {
		return 创建时间;
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
	
}
