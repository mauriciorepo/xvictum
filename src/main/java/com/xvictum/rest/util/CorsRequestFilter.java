package com.xvictum.rest.util;

import java.io.IOException;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;


//@Provider
public class CorsRequestFilter /*implements ContainerRequestFilter*/ {

	
	/*@Override
	   public void filter(final ContainerRequestContext requestContext)
	         throws IOException {
	      if (requestContext.getRequest().getMethod().equals(HttpMethod.OPTIONS)) {
	         requestContext.abortWith(Response.status(Response.Status.OK).build());
	      }
	   }*/
}
