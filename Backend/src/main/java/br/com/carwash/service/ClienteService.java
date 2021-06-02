package br.com.carwash.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import br.com.carwash.dao.ClienteDAO;
import br.com.carwash.dto.ClienteDTO;
import br.com.carwash.dto.UsuarioDTO;
import br.com.carwash.entity.Cliente;
import br.com.carwash.exception.NotValidData;

public class ClienteService {
	
	ClienteDAO dao = new ClienteDAO();

	public List<ClienteDTO> encontraClientes(long idCliente, String nomeCliente, String cpfClienteS) throws Exception {
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		List<Cliente> entidades = new ArrayList<Cliente>();
		entidades = dao.getClientes(idCliente, nomeCliente, cpfClienteS);
		for (Cliente c : entidades) {
			clientes.add(new ClienteDTO(c));
		}
		return clientes;
	}

	public ClienteDTO encontraCliente(long idCliente) throws Exception {
		Cliente c = null;
		c = dao.find(idCliente);
		return new ClienteDTO(c);
	}

	public void novoCliente(UsuarioDTO user) throws Exception {
		if(user.getEmail() == null ||
				user.getNome() == null ||
				user.getSenha() == null ||
				user.getCpf() == null ||
				user.getDataNacimento() == null)
			throw new NotValidData(Status.NOT_ACCEPTABLE,"faltando parametros");
		
		try {
			Cliente cliente = new Cliente(user);
			dao.save(cliente);
		}catch(Exception e) {
			throw e;
		}
	}

}
