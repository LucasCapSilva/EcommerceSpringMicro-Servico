package com.capelotto.sendMail.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.capelotto.sendMail.entity.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id","estoque"})
public class ProdutoVO extends RepresentationModel<ProdutoVO> implements Serializable {

	private static final long serialVersionUID = 2381588818700865098L;

	@JsonProperty("id")	
	private Long id;
	
	@JsonProperty("estoque")
	private Integer estoque;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Integer getEstoque() {
		return estoque;
	}



	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public static ProdutoVO create(Produto produto) {
		return new ModelMapper().map(produto, ProdutoVO.class);
	}
}

