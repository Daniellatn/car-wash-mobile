package br.com.carwash.rest;

import java.util.Objects;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.carwash.dto.ClienteDTO;
import br.com.carwash.dto.UsuarioDTO;
import br.com.carwash.exception.NotValidData;
import br.com.carwash.service.ClienteService;


@Path("cliente")
public class RestCliente extends SuperRest{	
	
	static final ClienteService service = new ClienteService(); 
	
	
	@GET
	@Path("/{idCliente}")
	public Response encontraCliente(@PathParam("cliente") long idCliente) {
		try {
			ClienteDTO cliente =  service.encontraCliente(idCliente);
			return Response.status(Status.OK).entity(cliente).build();
		}catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET
	public Response encontraClientes(@QueryParam("cliente") long idCliente, @QueryParam("nome") String nomeCliente,
			@QueryParam("cpf") String cpfClienteS) {
		try {
			service.econtraClientes(idCliente,nomeCliente,cpfClienteS );
		}catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(Status.ACCEPTED).build();
	}
	
	@POST
	public Response cadastarCliente(UsuarioDTO user) {
		try {
			if(Objects.isNull(user))
				return Response.status(Status.NOT_ACCEPTABLE).build();
			service.novoCliente(user);
		}catch(NotValidData e) {
			return Response.status(e.getStatusCode()).build();
		}catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(Status.ACCEPTED).build();
	}
	
}
