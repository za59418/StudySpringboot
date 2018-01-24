package com.zxl.mapper;

import java.util.List;

import com.zxl.entity.UserInfo;

public interface UserMapper {
	List<UserInfo> getAll();
	
	UserInfo getOne(Long uid);

	void insert(UserInfo user);

	void update(UserInfo user);

	void delete(Long uid);
}
