package br.com.carwash.dto;

import java.math.BigDecimal;

import br.com.carwash.entity.Loja;
import br.com.carwash.entity.Produto;

public class ProdutoLojaDTO {

	private Long produtoId;
	private Loja loja;
	private String nome;
	private BigDecimal preco;

	public ProdutoLojaDTO() {
		
	}

	public ProdutoLojaDTO(Produto p) {
		produtoId= p.getId();
		loja=p.getLoja();
		nome = p.getNome();
		preco = p.getPreco();
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
