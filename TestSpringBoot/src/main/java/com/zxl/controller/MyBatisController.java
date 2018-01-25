package com.zxl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxl.entity.SysRole;
import com.zxl.entity.UserInfo;
import com.zxl.mapper.RoleMapper;
import com.zxl.mapper.UserMapper;

@RestController
@RequestMapping("/mybatis")
public class MyBatisController {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	
	@RequestMapping("/getUsers")
	public List<UserInfo> getUsers() {
		List<UserInfo> users=userMapper.getAll();
		return users;
	}
	
	@RequestMapping("/getRole")
	public SysRole getRole(Long id) {
		SysRole role=roleMapper.getOne(id);
		return role;
	}
}
