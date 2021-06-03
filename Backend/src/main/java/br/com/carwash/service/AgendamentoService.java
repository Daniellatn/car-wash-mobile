package br.com.carwash.service;

import java.util.Objects;

import javax.ws.rs.NotFoundException;

import br.com.carwash.dao.AgendamentoDAO;
import br.com.carwash.dao.ClienteDAO;
import br.com.carwash.dao.LavaJatoDAO;
import br.com.carwash.dto.AgendamentoDTO;
import br.com.carwash.entity.Agendamento;
import br.com.carwash.entity.Cliente;
import br.com.carwash.entity.LavaJato;

public class AgendamentoService {
	
	AgendamentoDAO dao = new AgendamentoDAO();
	ClienteDAO clienteDao = new ClienteDAO();
	LavaJatoDAO lavaJatoDao = new LavaJatoDAO(); 

	public AgendamentoDTO buscaAgendamentoPorId(long agendamento) throws Exception {
		Agendamento a =null;
		a = dao.find(agendamento);
		if(Objects.isNull(a))
			throw new NotFoundException();
		return new AgendamentoDTO(a);
	}

	public void cadastarAgendamento(AgendamentoDTO agendamentoDto) throws Exception {
		Cliente c = clienteDao.find(agendamentoDto.getIdCliente());
		LavaJato lj = lavaJatoDao.find(agendamentoDto.getIdLavaJato());
		Agendamento agendamento = new Agendamento();
		agendamento.setCliente(c);
		agendamento.setJavaJato(lj);
		agendamento.setDataAgendamento(agendamentoDto.getAgendamento());
		dao.save(agendamento);
	}

}
