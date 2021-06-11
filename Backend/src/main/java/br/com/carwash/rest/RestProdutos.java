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

import br.com.carwash.dto.ProdutoCadastroDTO;
import br.com.carwash.dto.ProdutoDTO;
import br.com.carwash.dto.ProdutoLojaDTO;
import br.com.carwash.exception.NotValidDataException;
import br.com.carwash.service.ProdutoService;

@Path("produto")
public class RestProdutos extends SuperRest{
	
	final static ProdutoService service= new ProdutoService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarTodosProdutos(@QueryParam("idLoja") Long idLoja,@QueryParam("idProduto") Long idProduto,@QueryParam("nomeProduto") String nomeProduto) {
		try {
			List<ProdutoLojaDTO> produtos= service.encontrarProdutoPorLojaId(idLoja,idProduto,nomeProduto);
			return Response.status(Status.FOUND).entity(produtos).build();
		}catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET
	@Path("/{idProduto}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarProdutosPorLoja(@PathParam("idProduto")Long idProduto) {
		try {
			ProdutoDTO produto = service.encontrarProdutoPorId(idProduto);
			return Response.status(Status.FOUND).entity(produto).build();
		}catch(NotValidDataException e) {
			return Response.status(e.getStatusCode()).entity(e.getMessage()).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastarProduto(ProdutoCadastroDTO produto) {
		if(Objects.isNull(produto))
			return Response.status(Status.BAD_REQUEST).build();
		try{
			service.criarProduto(produto);
		}catch(NotValidDataException e) {
			return Response.status(e.getStatusCode()).entity(e.getMessage()).build();
		}
		catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(Status.CREATED).build();
	}
}
