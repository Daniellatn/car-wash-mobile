package br.com.carwash.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import br.com.carwash.aplicacao.token.JWTtoken;



public class SuperRest {

	static String herder_token = "Authorization";

	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	String getToken(){
		return request.getHeader(herder_token);
	}
	
	Long getUserId() {
		String token = request.getHeader("Authorization");
		return JWTtoken.getClaim(token).getBody().get("token-id",Long.class);
	}
}
