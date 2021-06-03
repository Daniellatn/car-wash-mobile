package br.com.carwash.rest;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.carwash.dto.AgendamentoDTO;
import br.com.carwash.service.AgendamentoService;

@Path("agendamento")
public class RestAgendamento extends SuperRest{
	
	AgendamentoService service= new AgendamentoService(); 
	
	@GET
	@Path("/{agendamento}")
	public Response encontraAgendamento(@PathParam("agendamento") long agendamento) {
		try {
			AgendamentoDTO agendamentoDto = service
					.buscaAgendamentoPorId(agendamento);
			return Response
					.status(Status.FOUND)
					.entity(agendamentoDto)
					.build();
		}catch(NotFoundException e) {
			return Response.status(Status.NO_CONTENT).build();
		}catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@POST
	public Response agendar(AgendamentoDTO agendamento) {
		try {
			service.cadastarAgendamento(agendamento);
		}catch(Exception e) {
			
		}
		return null;
	}
}
