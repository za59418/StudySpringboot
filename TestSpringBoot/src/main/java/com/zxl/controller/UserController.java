package com.zxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxl.domain.User;
import com.zxl.domain.UserRepository;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/getUserByName")
	User getUserByName() {
		User user = userRepository.findByUserName("aa");
        return user;
    }
	
	@RequestMapping("/addUser")
	User addUser() {
		User user = new User();

		user.setUserName("nice");
		user.setPassWord("nice");
		user.setNickName("nice");
		user.setRegTime("2018-01-16");
		userRepository.save(user);
		return user;
	}
	
}
