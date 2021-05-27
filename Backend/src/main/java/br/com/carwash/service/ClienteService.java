package br.com.carwash.service;

import java.util.ArrayList;
import java.util.List;

import br.com.carwash.dao.ClienteDAO;
import br.com.carwash.dto.ClienteDTO;
import br.com.carwash.entity.Cliente;

public class ClienteService {

	final static ClienteDAO dao = new ClienteDAO();

	public List<ClienteDTO> econtraClientes(long idCliente, String nomeCliente, String cpfClienteS) throws Exception {
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		List<Cliente> entidades = new ArrayList<Cliente>();
		cpfClienteS = cpfClienteS.replace(".", "").replace("-", "");
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

}
