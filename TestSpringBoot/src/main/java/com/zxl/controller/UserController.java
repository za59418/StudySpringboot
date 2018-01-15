package com.zxl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/login")
    String login() {
		
		//连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.connect();
        jedis.auth("123");
        
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        
        String name = jedis.get("name");
        System.out.println(name);
        
        return "login";
    }
	
	@RequestMapping("/getUser")
    String getUser() {
        return "getUser";
    }
}
