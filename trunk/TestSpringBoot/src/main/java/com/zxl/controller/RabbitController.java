package com.zxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxl.domain.User;
import com.zxl.rabbitmq.FanoutSender;
import com.zxl.rabbitmq.HelloSender;
import com.zxl.rabbitmq.ObjectSender;
import com.zxl.rabbitmq.TopicSender;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {
	
	@Autowired
	private HelloSender helloSender;
	@Autowired
	private FanoutSender fanoutSender;
	@Autowired
	private TopicSender topicSender;
	@Autowired
	private ObjectSender objectSender;
	
	@RequestMapping("/testHello")
    void testHello() {
		helloSender.send();
    }
	
	@RequestMapping("/testFanout")
    void testFanout() {
		fanoutSender.send();
    }
	
	@RequestMapping("/testTopic")
    void testTopic() {
		topicSender.send1();
    }
	
	@RequestMapping("/testObject")
	public void sendOject() throws Exception {
		User user=new User();
		user.setUserName("zxl");
		user.setEmail("zxl@qq.com");
		objectSender.send(user);
	}
}
