package com.example.demo.controller.parameter;

public class PShowPageUs {
	int show,page;
	String us;
	public int getShow() {
		return show;
	}
	public void setShow(int show) {
		this.show = show;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getUs() {
		return us;
	}
	public void setUs(String us) {
		this.us = us;
	}
	public PShowPageUs(int show, int page, String us) {
		super();
		this.show = show;
		this.page = page;
		this.us = us;
	}
	public PShowPageUs() {
		super();
	}
	
}
