package com.zxl.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/redis")
public class RedisController {
	
	@RequestMapping("/testJedis")
    String testJedis() {
		
		//连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.connect();
        jedis.auth("123");
        
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        
        String name = jedis.get("name");
        System.out.println("来自jedis:" + name);
        
        return "testjedis";
    }
	
	
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
	    
    @Autowired
    private RedisTemplate redisTemplate;
	    
	@RequestMapping("/testRedis")
    String testRedis() {
		stringRedisTemplate.opsForValue().set("age", "21");
        String age = stringRedisTemplate.opsForValue().get("age");
        System.out.println("来自redis:" + age);
        return "testredis";
    }
	
	@RequestMapping("/testSession")
	UUID testSession(HttpSession session) {
		UUID uid = (UUID)session.getAttribute("uid");
		if(null==uid)
		{
			uid = UUID.randomUUID();
			session.setAttribute("uid", uid);
		}
		return uid;
	}
}
