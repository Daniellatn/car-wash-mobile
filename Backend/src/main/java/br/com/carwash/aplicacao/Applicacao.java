package br.com.carwash.aplicacao;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class Applicacao  extends ResourceConfig {
	public Applicacao() {
		packages("br.com.carwash.rest");
	}
}
