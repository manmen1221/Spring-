package com.example.demo.controller.container;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	private static SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static String getTime() {
		return s.format(new Date());
	}
}
