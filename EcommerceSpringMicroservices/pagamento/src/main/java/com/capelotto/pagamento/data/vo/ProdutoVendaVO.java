package com.capelotto.pagamento.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.capelotto.pagamento.entity.ProdutoVenda;

@JsonPropertyOrder({ "id", "idProduto", "quantidade" })
public class ProdutoVendaVO extends RepresentationModel<ProdutoVendaVO> implements Serializable {

	private static final long serialVersionUID = 3277044024726131411L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("idProduto")
	private Long idProduto;

	@JsonProperty("quantidade")
	private Integer quantidade;
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getIdProduto() {
		return idProduto;
	}



	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}



	public Integer getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public static ProdutoVendaVO create(ProdutoVenda produtoVenda) {
		return new ModelMapper().map(produtoVenda, ProdutoVendaVO.class);
	}

}
