package com.capelotto.sendMail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capelotto.sendMail.entity.User;
import com.capelotto.sendMail.repository.UserRepository;

@Service
public class MailService {

	@Autowired
	private UserRepository repository;
	
public User getLastUser() {
		
		List<User> users = repository.findAll();
		
		int last = users.size()-1;
	
			
		User user = users.get(last);
			
			
		return user;
	}
	
}
