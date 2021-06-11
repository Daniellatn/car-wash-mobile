package br.com.carwash.dto;

import java.math.BigDecimal;

import br.com.carwash.entity.Loja;
import br.com.carwash.entity.Produto;

public class ProdutoDTO {

	private Long id;
	private String nome;
	private BigDecimal preco;
	private Loja loja;

	public ProdutoDTO() {
		
	}
	public ProdutoDTO(Produto produto) {
		id = produto.getId();
		nome =produto.getNome();
		preco =produto.getPreco();
		loja = produto.getLoja();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
}
