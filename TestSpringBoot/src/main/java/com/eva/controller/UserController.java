package com.eva.controller;

import com.eva.dao.UserDao;
import com.eva.entity.User;
import com.eva.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 01348085 on 2017/7/7.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(User user) {
        userDao.save(user);
        return "ok";
    }

    @RequestMapping("find")
//    @Cacheable(value = "user-key")
    public List<User> findall() {
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return (List<User>) userDao.findAll();
    }

    @RequestMapping("find/{id}")
//    @Cacheable(value = "key-Users", key = "#id")
    public User findById(@PathVariable Long id) {
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return userDao.findOne(id);
    }


    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @CachePut(value = "key-Users", key = "#user.name")
    public User updateUser(User user) {
        return userDao.save(user);
    }

    @RequestMapping("findByName")
    @Cacheable(value = "key-Users", key = "#name")
    public User findByName(String name) {
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return userDao.findByUserName(name);
    }

    @RequestMapping("delete")
    @CacheEvict(value = "key-Users", key ="#user.name")
    public String deleteById(User user) {
        userDao.delete(user.getId());
        return "delete success";
    }
}
