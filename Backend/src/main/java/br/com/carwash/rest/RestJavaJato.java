package br.com.carwash.rest;

import java.util.List;
import java.util.Objects;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.carwash.dto.LavaJatoDTO;
import br.com.carwash.exception.NotValidData;
import br.com.carwash.service.LavaJatoService;

@Path("lavajato")
public class RestJavaJato extends SuperRest{

	static final LavaJatoService service = new LavaJatoService(); 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarLojas(@QueryParam("cnpj") String cnpj,
			@QueryParam("nome") String nomeLoja, 
			@QueryParam("email") String email,@QueryParam("loja") Long id) {
		List<LavaJatoDTO> lojas = null;
		try {
			lojas = service.econtrarLojas(id,nomeLoja,email,cnpj);
		}catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(Status.OK).entity(lojas).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{idLoja}")
	public Response buscaCleinte(@PathParam("idLoja")Long idLoja) {
		LavaJatoDTO loja = null;
		try {
			loja = service.encontraLoja(idLoja);
		}catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(Status.FOUND).entity(loja).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response criaNovaLoja(LavaJatoDTO loja) {
		if(Objects.isNull(loja))
			return Response.status(Status.BAD_REQUEST).build();
		try {
			service.cadastrarLoja(loja);
		}catch(NotValidData e) {
			return Response.status(e.getStatusCode()).build();
		}
		catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(Status.CREATED).build();
	}
}
