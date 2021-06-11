package br.com.carwash.dto;

import java.math.BigDecimal;

import br.com.carwash.entity.Produto;

public class ProdutoCadastroDTO {
	
	private Long id;
	private Long lojaId;
	private BigDecimal preco;
	private String nome;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLojaId() {
		return lojaId;
	}
	public void setLoja(Long loja) {
		this.lojaId = loja;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isValidToCreate() {
		return nome != null && preco != null && lojaId != null;
	}
	public Produto toEntity() {
		Produto p = new Produto();
		p.setNome(nome);
		p.setPreco(preco);
		return p;
	}
}
