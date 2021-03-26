package com.capelotto.sendMail.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.capelotto.sendMail.entity.Produto;
import com.capelotto.sendMail.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id","userName"})
public class UserVO extends RepresentationModel<ProdutoVO> implements Serializable{
	
	private static final long serialVersionUID = -8120067046560354211L;

	@JsonProperty("id")	
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("userName")
	private String userName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public static UserVO create(User user) {
		return new ModelMapper().map(user, UserVO.class);
	}

}
