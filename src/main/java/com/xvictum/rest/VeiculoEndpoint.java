package com.xvictum.rest;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateful;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import com.xvictum.model.AnoModelo;
import com.xvictum.model.Cliente;
import com.xvictum.model.Modelo;
import com.xvictum.model.Veiculo;
import com.xvictum.model.marca;

/**
 * 
 */
@Stateful
@Path("/veiculos")
public class VeiculoEndpoint {
	@PersistenceContext(unitName = "persistence-xvictum", type=PersistenceContextType.EXTENDED)
	private EntityManager em;

	@POST
	@Consumes("application/json")
	public Response create(Veiculo entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(VeiculoEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}
	
	@POST
	@Consumes("application/json")
	@Path("/criar")
	public Response lancaVeiculo(Cliente cliente){

		Cliente entityCliente= em.find(Cliente.class,cliente.getId());
		
		if(entityCliente == null){
			return null;
		}else{
			//cliente.setVeiculo(cliente.getVeiculo());
			for (Veiculo vec : cliente.getVeiculo()) {
                 marca Marca= vec.getMarca();
                 Modelo mod=vec.getModelo();
                 AnoModelo anomodelo=vec.getAnomodelo();
				
                 vec.setMarca(Marca);
                 vec.setModelo(mod);
                 vec.setAnomodelo(anomodelo);
				entityCliente.criaVeiculo(vec);
			}
			
			return Response.status(200).build();
			
			//marca entityMarca= em.find(marca.class, cliente.getVeiculo().)
		}
		
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") Long id) {
		Veiculo entity = em.find(Veiculo.class, id);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		em.remove(entity);
		return Response.noContent().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response findById(@PathParam("id") Long id) {
		TypedQuery<Veiculo> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT v FROM Veiculo v LEFT JOIN FETCH v.marca LEFT JOIN FETCH v.modelo LEFT JOIN FETCH v.anomodelo WHERE v.id = :entityId ORDER BY v.id",
						Veiculo.class);
		findByIdQuery.setParameter("entityId", id);
		Veiculo entity;
		try {
			entity = findByIdQuery.getSingleResult();
		} catch (NoResultException nre) {
			entity = null;
		}
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(entity).build();
	}

	@GET
	@Produces("application/json")
	public List<Veiculo> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<Veiculo> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT v FROM Veiculo v LEFT JOIN FETCH v.marca LEFT JOIN FETCH v.modelo LEFT JOIN FETCH v.anomodelo ORDER BY v.id",
						Veiculo.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Veiculo> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, Veiculo entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		/*if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}*/
		if (em.find(Veiculo.class, entity.getId()) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			//System.out.println(em.find(Veiculo.class, id));
		 //String consulta ="SELECT  c.id FROM Cliente c , Veiculo v where v.id=:idveiculo and c.id=v.cliente_id";
			//Query query = em.createNativeQuery(consulta, Cliente.class);
			//query.setParameter("idveiculo", id);
			TypedQuery<Cliente> findClienteOfVeiculo = em.createQuery("SELECT DISTINCT c FROM Cliente c join c.veiculo as vec WHERE vec.id = :id ",Cliente.class);
			findClienteOfVeiculo.setParameter("id", id);
			
					
			//Integer ID_Cliente = (Integer) query.getSingleResult();
			Cliente cliente= findClienteOfVeiculo.getSingleResult();
			cliente=em.find(Cliente.class, cliente.getId());
			System.out.println(cliente.getVeiculo());
			// cliente.getVeiculo().forEach(cliente.criaVeiculo(vec););
			/*for (Veiculo vec : cliente.getVeiculo()) {
				
				if(vec.getId()==id){
					System.out.println("entrou!!");
					vec.setVersion(entity.getVersion());
					vec.setAltura(entity.getAltura());
					vec.setChassi(entity.getChassi());
					vec.setPortas(entity.getPortas());
				}
			}*/
			
			/*if(cliente.getVeiculo().remove(entity)){
				System.out.println(cliente.getVeiculo());
				cliente.getVeiculo().add(entity);
			}*/
			//cliente.getVeiculo().add(entity);
			//cliente.updateVeiculo(entity);
			
			//cliente.criaVeiculo(entity);
			//cliente = em.merge(cliente);
			System.out.println(cliente.getVeiculo());
			entity = em.merge(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT)
					.entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}
}
