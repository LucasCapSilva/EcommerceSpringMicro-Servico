package com.capelotto.sendMail.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.capelotto.sendMail.data.vo.ProdutoVO;
import com.capelotto.sendMail.data.vo.UserVO;
import com.capelotto.sendMail.entity.Produto;
import com.capelotto.sendMail.entity.User;
import com.capelotto.sendMail.repository.ProdutoRepository;
import com.capelotto.sendMail.repository.UserRepository;


@Component
public class ProdutoReceiveMessage {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@RabbitListener(queues = {"${crud.rabbitmq.queue}"})
	public void receive (@Payload ProdutoVO produtoVO){
		produtoRepository.save(Produto.create(produtoVO));
	}
	
	@RabbitListener(queues = {"${crud.rabbitmq.queue}"})
	public void receive2 (@Payload UserVO userVO){
		userRepository.save(User.create(userVO));
	}
	
}
