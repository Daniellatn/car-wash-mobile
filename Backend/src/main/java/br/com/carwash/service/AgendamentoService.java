package br.com.carwash.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.ws.rs.NotFoundException;

import br.com.carwash.dao.AgendamentoDAO;
import br.com.carwash.dao.ClienteDAO;
import br.com.carwash.dao.LavaJatoDAO;
import br.com.carwash.dto.AgendamentoDTO;
import br.com.carwash.entity.Agendamento;
import br.com.carwash.entity.Cliente;
import br.com.carwash.entity.Loja;

public class AgendamentoService {
	
	AgendamentoDAO dao = new AgendamentoDAO();
	ClienteDAO clienteDao = new ClienteDAO();
	LavaJatoDAO lavaJatoDao = new LavaJatoDAO(); 

	public AgendamentoDTO buscaAgendamentoPorId(Long agendamento) throws Exception {
		Agendamento a =null;
		a = dao.find(agendamento);
		if(Objects.isNull(a))
			throw new NotFoundException();
		return new AgendamentoDTO(a);
	}

	public void cadastarAgendamento(AgendamentoDTO agendamentoDto) throws Exception {
		Cliente c = clienteDao.find(agendamentoDto.getIdCliente());
		Loja lj = lavaJatoDao.find(agendamentoDto.getIdLavaJato());
		Agendamento agendamento = new Agendamento();
		agendamento.setCliente(c);
		agendamento.setJavaJato(lj);
		agendamento.setDataAgendamento(agendamentoDto.getAgendamento());
		dao.save(agendamento);
	}

	public List<AgendamentoDTO> buscaListaAgendamentos(Long agendamento, Long cliente, Long inicio, Long fim) throws Exception {
		List<AgendamentoDTO> listaDto = new ArrayList<AgendamentoDTO>();
		List<Agendamento> listaEntity= dao.pegarListaDeAgendamentos(agendamento, cliente,inicio, fim);
		for(Agendamento a: listaEntity)
			listaDto.add(new AgendamentoDTO(a));
		return listaDto;
	}

}
