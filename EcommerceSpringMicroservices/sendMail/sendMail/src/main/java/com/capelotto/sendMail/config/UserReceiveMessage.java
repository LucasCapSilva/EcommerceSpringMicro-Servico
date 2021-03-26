package com.capelotto.sendMail.config;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.capelotto.sendMail.data.vo.ProdutoVO;
import com.capelotto.sendMail.data.vo.UserVO;
import com.capelotto.sendMail.entity.Produto;
import com.capelotto.sendMail.entity.User;
import com.capelotto.sendMail.envio.Mailer;
import com.capelotto.sendMail.envio.Mensagem;
import com.capelotto.sendMail.repository.ProdutoRepository;
import com.capelotto.sendMail.repository.UserRepository;
import com.capelotto.sendMail.service.MailService;
@Component
public class UserReceiveMessage {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MailService service;
	
	@Autowired
	public Mailer mailer;
	
	@Autowired
	private Environment env;
	
	
	@RabbitListener(queues = {"${auth.rabbitmq.queue}"})
	public void receive2 (@Payload UserVO userVO){
		userRepository.save(User.create(userVO));
		User userResult = service.getLastUser();
		mailer.enviar(new Mensagem("Email de cadastro <"+env.getProperty("mail.smtp.username")+">", 
				Arrays.asList("<"+userResult.getUserName()+">")
				, "Conta criada Com sucesso ","Muito obrigado "+userResult.getName()+" por se cadastrar no nosso site "));
		System.out.println(userResult.toString());
	}
}
