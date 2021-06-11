package br.com.carwash.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.carwash.aplicacao.token.JWTtoken;
import br.com.carwash.dto.UsuarioAutenticado;
import br.com.carwash.entity.Cliente;
import br.com.carwash.service.UserService;

@Path("login")
public class RESTAutenticacao extends SuperRest{
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logar(UsuarioAutenticado user) {
		try {
		Cliente cliente = new UserService().encontrarPorEmailSenha(user.getEmail(),user.getSenha());
		if(cliente == null)
			return Response.status(Status.BAD_REQUEST).build();
		user.setId(cliente.getId());
		String autenticacao = JWTtoken.getStringTocken(user);
		return Response.status(Status.CREATED)
				.header("header-tite", herder_token)
				.entity(autenticacao)
				.build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	@DELETE
	public Response sair() {
		try {
			String token = getToken();
			//TODO: deletar JWT;
		}catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(Status.ACCEPTED).build();
	}
	

}
