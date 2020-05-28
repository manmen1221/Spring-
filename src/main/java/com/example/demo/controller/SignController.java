package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.container.Sign;
import com.example.demo.controller.container.Time;
import com.example.demo.controller.parameter.PUsPs;
import com.example.demo.controller.parameter.PUsPsPs2;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.container.User;

@RestController
@CrossOrigin("http://localhost:8081")
public class SignController {
	@Autowired
	private UserRepository userRepository;
	@RequestMapping("/Sign")
	public Sign sign(@RequestBody PUsPs p) {
		String us=p.getUs();
		String ps=p.getPs();
		Sign sg=new Sign();
		try {
			userRepository.findById(us).get();
			sg.set成功(false);
			sg.set信息("该用户名已存在！");
			return sg;
		}catch(Exception e) {
			User save=new User();
			save.set用户(us);
			save.set密码(ps);
			save.set权限("普通");
			save.set状态("审核");
			save.set创建时间(Time.getTime());
			userRepository.save(save);
			sg.set成功(true);
			sg.set信息("已成功注册，正在审核，请等待");
			return sg;
		}
	}
	
	
	
	@RequestMapping("/resetpw")
	public boolean resetpw(@RequestBody PUsPsPs2 p) {
		String us=p.getUs();
		String ps=p.getPs();
		String ps2=p.getPs2();
		try {
			User temp = userRepository.findById(us).get();
			if(temp.密码().equals(ps)) {
				temp.set密码(ps2);
				userRepository.save(temp);
				return true;
			}else
				return false;
		}catch(Exception e) {
			return false;
		}
	}
}