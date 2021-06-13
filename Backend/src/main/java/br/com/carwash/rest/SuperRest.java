package br.com.carwash.rest;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import br.com.carwash.aplicacao.token.JwtToken;
import br.com.carwash.exception.NotLogedException;

public class SuperRest {


	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public boolean isAtorizade() throws NotLogedException {
		String jwts = request.getHeader("Authorization");
		if(Objects.isNull(jwts))
			throw new NotLogedException();
		JwtToken.getClaim(jwts.replace("Bearer ",""));
		return !jwts.isEmpty();
	}
}
