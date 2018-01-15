package com.eva.service.impl;

import com.eva.common.CacheNameSpace;
import com.eva.common.annotation.QueryCache;
import com.eva.common.annotation.QueryCacheKey;
import com.eva.dao.UserDao;
import com.eva.entity.User;
import com.eva.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 01348085 on 2017/7/11.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @QueryCache(nameSpace = CacheNameSpace.SSO_USER)
    @Override
    public User findById(@QueryCacheKey Long id) {
        User user = userDao.findOne(id);
        return user;
    }
}
