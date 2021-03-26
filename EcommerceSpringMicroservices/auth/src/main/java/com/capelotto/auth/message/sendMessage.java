package com.capelotto.auth.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.capelotto.auth.entity.User;



@Component
public class sendMessage {

	@Value("${auth.rabbitmq.exchange}")
	String exchange;
	
	@Value("${auth.rabbitmq.routingkey}")
	String routingkey;
	
	public final RabbitTemplate rabbitTemplate;

	@Autowired
	public sendMessage(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendMessage(User user) {
		rabbitTemplate.convertAndSend(exchange,routingkey,user);
	}
	
}
