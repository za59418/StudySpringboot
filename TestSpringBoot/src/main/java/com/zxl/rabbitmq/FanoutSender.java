package com.zxl.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String msg = "hi, fanout msg ";
		System.out.println("Sender : " + msg);
		this.rabbitTemplate.convertAndSend("fanoutExchange","", msg);
	}

}
