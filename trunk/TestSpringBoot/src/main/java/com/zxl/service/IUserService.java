package com.zxl.service;

import java.util.List;

import com.zxl.domain.User;

public interface IUserService {
	User getUser(String name);
	List<User> getAllUsers();
}
