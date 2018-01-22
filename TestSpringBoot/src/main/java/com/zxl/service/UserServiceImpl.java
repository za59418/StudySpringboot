package com.zxl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxl.domain.User;
import com.zxl.domain.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(name);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public User findUserById(Long id) {
		return userRepository.getOne(id);
	}
	@Override
	public void edit(User user) {
		userRepository.save(user);
	}
	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}
}
