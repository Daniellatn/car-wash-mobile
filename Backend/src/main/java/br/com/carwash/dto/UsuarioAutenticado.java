package br.com.carwash.dto;

public class UsuarioAutenticado {

	private String email;
	private String senha;
	private Long id;


	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setId(long id) {
		this.id=id;
	}

	public Long getUserId() {
		return id;
	}
}
