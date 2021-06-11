package br.com.carwash.service;

import br.com.carwash.dao.ClienteDAO;
import br.com.carwash.entity.Cliente;

public class UserService {
	ClienteDAO dao = new ClienteDAO();

	
	public Cliente encontrarPorEmailSenha(String email, String senha) {
		return dao.pegaPorEmailSenha(email,senha);
	}
}
