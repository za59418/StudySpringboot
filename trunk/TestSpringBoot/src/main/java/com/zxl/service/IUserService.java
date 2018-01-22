package com.zxl.service;

import java.util.List;

import com.zxl.domain.User;

public interface IUserService {
	User getUser(String name);
	List<User> getAllUsers();
	void save(User user);
	User findUserById(Long id);
	void edit(User user);
	void delete(Long id);
}
