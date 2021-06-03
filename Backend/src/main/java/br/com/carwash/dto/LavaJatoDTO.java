package br.com.carwash.dto;

import java.time.LocalDate;
import br.com.carwash.entity.Loja;

public class LavaJatoDTO {
	
	private String nomeLoja;
	private long id;
	private String email;
	private LocalDate dataCadastro;
	private String cnpj;

	public LavaJatoDTO() {
		
	}
	
	public LavaJatoDTO(Loja l) {
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

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
