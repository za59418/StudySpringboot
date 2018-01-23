package com.zxl.dao;

import com.zxl.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao extends CrudRepository<UserInfo,Long> {
	public UserInfo findByUsername(String username);
}
