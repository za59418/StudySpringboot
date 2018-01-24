package com.zxl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxl.entity.UserInfo;
import com.zxl.mapper.UserMapper;

@RestController
@RequestMapping("/mybatis")
public class MyBatisController {
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/getUsers")
	public List<UserInfo> getUsers() {
		List<UserInfo> users=userMapper.getAll();
		return users;
	}
}
