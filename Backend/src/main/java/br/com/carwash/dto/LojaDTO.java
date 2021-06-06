package br.com.carwash.dto;

import java.time.LocalDate;

import com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location;

import br.com.carwash.entity.Loja;

public class LojaDTO {
	
	private String nomeLoja;
	private Long id;
	private String email;
	private LocalDate dataCadastro;
	private String cnpj;
//	private Location localizacao = Location.getDefaultInstance();

	public LojaDTO() {
		
	}
	
	public LojaDTO(Loja l) {
		cnpj = l.getCnpj();
		dataCadastro = l.getDataCadastro();
		email = l.getEmail();
		id = l.getId();
		nomeLoja = l.getNome();
//		localizacao = l.getLocalizacao();
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
//
//	public Location getLocalizacao() {
//		return localizacao;
//	}
//
//	public void setLocalizacao(Location localizacao) {
//		this.localizacao = localizacao;
//	}
}
