package br.com.carwash.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.carwash.dto.ClienteDTO;
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
	
}
