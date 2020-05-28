package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.container.Login;
import com.example.demo.controller.parameter.PUsPs;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.container.User;

@RestController
@CrossOrigin("http://localhost:8081")
public class LoginController {
	@Autowired
	private UserRepository userRepository;
	@RequestMapping("/Login")
	public Login login(@RequestBody PUsPs p) {
		String us=p.getUs();
		String ps=p.getPs();
		User temp;
		Login lg=new Login();
		try {
			temp=userRepository.findById(us).get();
			if((ps+"").equals(temp.密码())) {
				if("正常".equals(temp.get状态())) {
					lg.set用户(us);
					lg.set权限(temp.get权限());
					lg.set错误(false);
				return lg;
				}else {
					lg.set错误(true);
					lg.set警告("用户正在被审核或被封禁");
					return lg;
				}
			}else {
				lg.set错误(true);
				lg.set警告("用户不存在或密码错误");
				return lg;
			}
		}catch(Exception e) {
			lg.set错误(true);
			lg.set警告("用户不存在或密码错误");
			return lg;
		}
	}
}
