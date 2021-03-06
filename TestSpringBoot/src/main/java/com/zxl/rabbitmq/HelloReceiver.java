package com.zxl.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
	@RabbitHandler
    public void process(String msg) {
        System.out.println("Receiver  : " + msg);
    }
}
