package com.capelotto.sendMail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.capelotto.sendMail.data.vo.ProdutoVO;
import com.capelotto.sendMail.data.vo.UserVO;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Column(name = "user_name", unique = true)
	private String userName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public static User create(UserVO userVo) {
		return new ModelMapper().map(userVo, User.class);
	}
	

}
