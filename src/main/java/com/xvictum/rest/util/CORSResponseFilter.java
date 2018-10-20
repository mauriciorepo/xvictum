package com.xvictum.rest.util;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		//ResponseBuilder crunchifyResponseBuilder = Response.fromResponse(responseContext.getResponse());
		MultivaluedMap<String, Object> headers = responseContext.getHeaders();

		headers.add("Access-Control-Allow-Origin", "*");
		
		//headers.add("Access-Control-Allow-Origin", "http://localhost:4200"); //allows CORS requests only coming from podcastpedia.org		
		headers.add("Access-Control-Allow-Methods", "API, CRUNCHIFYGET, GET, POST, PUT, UPDATE, OPTIONS");			
		headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type,responseType, X-Codingpedia, X-Mashape-Key,Accept ");
		headers.add("Access-Control-Max-Age", "151200");
	}

	/*String crunchifyRequestHeader = req.getHeaderValue("Access-Control-Request-Headers");
	 
    if (null != crunchifyRequestHeader && !crunchifyRequestHeader.equals(null)) {
        crunchifyResponseBuilder.header("Access-Control-Allow-Headers", crunchifyRequestHeader);
    }*/
	
}
