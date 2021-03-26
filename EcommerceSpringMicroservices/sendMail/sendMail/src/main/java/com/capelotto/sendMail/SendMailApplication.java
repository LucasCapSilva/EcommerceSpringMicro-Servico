package com.capelotto.sendMail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SendMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendMailApplication.class, args);
	}

}
