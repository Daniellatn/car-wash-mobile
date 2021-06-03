package br.com.carwash.dto;

import java.util.Date;

import br.com.carwash.entity.LavaJato;

public class LavaJatoDTO {
	
	private String nomeLoja;
	private long id;
	private String email;
	private Date dataCadastro;
	private String cnpj;

	public LavaJatoDTO() {
		
	}
	
	public LavaJatoDTO(LavaJato l) {
		cnpj = l.getCnpj();
		dataCadastro = l.getDataCadastro();
		email = l.getEmail();
		id = l.getId();
		nomeLoja = l.getNome();
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String loja) {
		this.nomeLoja = loja;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
