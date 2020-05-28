package com.example.demo.dao.container;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SellKey implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "用户",insertable=false,updatable=false)
    private String 用户;
	@Column(name = "创建时间",insertable=false,updatable=false)
    private String 创建时间;
	
	public SellKey() {
	}
	public SellKey(String 用户, String 创建时间) {
		super();
		this.用户 = 用户;
		this.创建时间 = 创建时间;
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

	@Override
	public String toString() {
		return "SellKey [用户=" + 用户 + ", 创建时间=" + 创建时间 + "]";
	}
}
