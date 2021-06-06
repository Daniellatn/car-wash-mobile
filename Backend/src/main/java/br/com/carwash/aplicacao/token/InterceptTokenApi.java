//package br.com.carwash.aplicacao.token;
//
//import java.io.IOException;
//
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.ext.Provider;
//
//import br.com.carwash.aplicacao.Applicacao;
//
//@Provider
//public class InterceptTokenApi implements ContainerRequestFilter{
//
//	public String apiKeyAcces = Applicacao.getTokenApiProperty();
//	
//	@Override
//	public void filter(ContainerRequestContext requestContext) throws IOException {
//
//		MultivaluedMap<String, String> mapHeaders = (containerRequestContext).getHeaders();
//	}
//
//}
