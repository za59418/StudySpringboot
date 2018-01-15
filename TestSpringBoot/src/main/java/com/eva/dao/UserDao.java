package com.eva.dao;

import com.eva.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 01348085 on 2017/7/7.
 */
public interface UserDao extends CrudRepository<User,Long>{
    User findByUserName(String userName);

    User findByUserNameAndPassword(String userName, String password);
}
