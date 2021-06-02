package br.com.carwash.dto;

import br.com.carwash.entity.Cliente;

public class ClienteDTO {
	
	long id;
	String nome;
	String cpf;
	String email;
	
	public ClienteDTO(Cliente c) {
		nome = c.getNome();
		cpf = c.getCpf();
		id = c.getId();
		email = c.getEmail();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
