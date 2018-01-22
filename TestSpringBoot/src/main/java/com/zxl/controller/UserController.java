package com.zxl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxl.domain.User;
import com.zxl.domain.UserRepository;
import com.zxl.service.IUserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/getUserByName")
	User getUserByName() {
		User user = userRepository.findByUserName("aa");
        return user;
    }
	
	@RequestMapping("/getAllUsersByService")
	List<User> getAllUsersByService() {
		List<User> users = userService.getAllUsers();
        return users;
    }
	
	@RequestMapping("/getAllUsers")
	List<User> getAllUsers(){
		return userRepository.findAll();
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
