package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.parameter.AdminGet;
import com.example.demo.controller.parameter.AdminSet;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.container.User;

@RestController
@CrossOrigin("http://localhost:8081")
public class AdminController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/getUserSize")
	public int getUserSize(@RequestBody AdminGet p) {
		String us=p.getUs();
		String 状态=p.get状态();
		String 权限=p.get权限();
		try {
			if(!userRepository.findById(us).get().get权限().equals("管理员"))
				throw new Exception();
			if(状态.equals("全部")&&权限.equals("全部"))
				return userRepository.findAll().size();
			else if(状态.equals("全部"))
				return userRepository.countBy权限OrderBy创建时间Desc(权限);
			else if(权限.equals("全部"))
				return userRepository.countBy状态OrderBy创建时间Desc(状态);
			return userRepository.countBy状态And权限OrderBy创建时间Desc(状态,权限);
		}catch(Exception e) {
			return 0;
		}
	}
	@RequestMapping("/getUserList")
	public List getUserList(@RequestBody AdminGet p) {
		String us=p.getUs();
		String 状态=p.get状态();
		String 权限=p.get权限();
		try {
			if(!userRepository.findById(us).get().get权限().equals("管理员"))
				throw new Exception();
			if(状态.equals("全部")&&权限.equals("全部"))
				return userRepository.findAll();
			else if(状态.equals("全部"))
				return userRepository.findBy权限OrderBy创建时间Desc(权限);
			else if(权限.equals("全部"))
				return userRepository.findBy状态OrderBy创建时间Desc(状态);
			return userRepository.findBy状态And权限OrderBy创建时间Desc(状态,权限);
		}catch(Exception e) {
			return null;
		}
	}
	@RequestMapping("/saveUser")
	public boolean saveUser(@RequestBody AdminSet p) {
		String us=p.UserKey();
		String 创建时间=p.get创建时间();
		String 用户=p.get用户();
		String 状态=p.get状态();
		String 权限=p.get权限();
		try {
			if(!userRepository.findById(us).get().get权限().equals("管理员"))
				throw new Exception();
			User temp=userRepository.findById(用户).get();
			temp.set权限(权限);
			temp.set状态(状态);
			userRepository.save(temp);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	@RequestMapping("/resetPs")
	public boolean resetPs(@RequestBody AdminSet p) {
		String us=p.UserKey();
		String 创建时间=p.get创建时间();
		String 用户=p.get用户();
		try {
			if(!userRepository.findById(us).get().get权限().equals("管理员"))
				throw new Exception();
			User temp=userRepository.findById(用户).get();
			temp.set密码("f1b708bba17f1ce948dc979f4d7092bc");
			userRepository.save(temp);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
