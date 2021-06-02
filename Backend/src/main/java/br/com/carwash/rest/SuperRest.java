package br.com.carwash.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;



public class SuperRest {


	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
