package com.xvictum.rest.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import com.xvictum.model.*;




//import org.jboss.security.authorization.resources.WebResource;

public class jaxrsClient {
	
	private final Client client;
	private final WebTarget target;
	
	public jaxrsClient() {
		client=ClientBuilder.newClient();
		Client client = ClientBuilder.newClient();
         target = client.
                  target("http://localhost:8080/xvictum/rest/");

	
	}
	public static void main(String[] args) {
		/*ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		System.out.println(service.path("rest").path("helloworld").accept
		(MediaType.TEXT_PLAIN).get(String.class));
		System.out.println(service.path("jaxrs").path("helloworld").accept
		(MediaType.TEXT_XML).get(String.class));

		System.out.println(service.path("jaxrs").path("helloworld").accept
				(MediaType.TEXT_HTML).get(String.class));
				}
				private static URI getBaseURI() {
				return UriBuilder.fromUri("http://localhost:8080/jbossjaxrs").
				build();
			*/	
		jaxrsClient rest= new jaxrsClient();
		marca mac=rest.createMarca();
		Response s= rest.createJsonMarca(mac);
		System.out.println( "response" + s);
		
		
	
	}
	public Response createJsonMarca(marca marc) {
        return client.target("http://localhost:8080/xvictum/rest/modelos").request(MediaType.APPLICATION_JSON).post(Entity.entity(marc, MediaType.APPLICATION_JSON));
    }
	
	private static void getAllCustomers(WebTarget target) {
        String s = target.request().get(String.class);
        System.out.println("All customers : "+s);
    }

    /*private static void postUsingRawJSON(WebTarget target) {
        String customer = ClientUtil.createCustomerInJSON("Alyssa William"
                  , "1021 Hweitt Street"
                  , "343-343-3433");
        String response = target.request()
                  .post(Entity.entity(customer, MediaType.APPLICATION_JSON)
                            , String.class);
        System.out.println("customer created with id: "+response);

      //get the new customer
        getCustomerById(target, response);

    }*/

    private static void getCustomerById(WebTarget target, String response) {

        //the complete resource URI would be
        //http://localhost:8080/jaxrs-post-example/api/customers/{newId}"
        String s = target.path(response)
                  .request()
                  .get(String.class);
        System.out.println("new customer :"+s);
    }

    /*private static void postByObjectToJasonTransformation(WebTarget target) {
        Customer newCustomer = ClientUtil.createNewCustomer("Jake Mae", "342, " +
                  "Snake Dr, GreenLake", "444-333-4564");

        String response = target.request(MediaType.APPLICATION_JSON)
                  .accept(MediaType.TEXT_PLAIN_TYPE)
                  .post(Entity.json(newCustomer), String.class);

        System.out.println("customer created with id: "+response);

        //get the new customer
        getCustomerById(target, response);

    }*/
    
    public marca createMarca() {
    	
      marca marc= new marca();
      marc.setCodigo(7);
      
      marc.setId(1L);
      marc.setNome("BMW");
    	Modelo modelo=new Modelo();
    	modelo.setCodigo(14);
    	modelo.setModelo("X7");
    	marc.criaModelo(modelo);
      
      return marc;
    } 
	
	/*
	// Set up our client and target our JAX-RS service
     client = ClientBuilder.newClient();
     target = client.target("http://localhost:9081/example.jaxrs/test/SimpleService");

    // Build our request JSON into an 'Entity'. Replace 'myData' with your JSON
    Entity<String> data = Entity.entity("MyData", MediaType.APPLICATION_JSON_TYPE);

    // Then send a post request to the target service
    String result = target.request(MediaType.APPLICATION_JSON_TYPE).post(data, String.class);
		*/		
}
