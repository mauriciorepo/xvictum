package com.xvictum.rest;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
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
import com.xvictum.model.Modelo;
import com.xvictum.model.marca;

/**
 * 
 */
@Stateful
@Path("/modelos")
public class ModeloEndpoint {
	@PersistenceContext(unitName = "persistence-xvictum" ,type=PersistenceContextType.EXTENDED )
	private EntityManager em;

	@POST
	@Consumes("application/json")
	public Response create(Modelo entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(ModeloEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") Long id) {
		Modelo entity = em.find(Modelo.class, id);
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
		TypedQuery<Modelo> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT m FROM Modelo m LEFT JOIN FETCH m.AnoModelo WHERE m.id = :entityId ORDER BY m.id",
						Modelo.class);
		findByIdQuery.setParameter("entityId", id);
		Modelo entity;
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
	public List<Modelo> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<Modelo> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT m FROM Modelo m LEFT JOIN m.AnoModelo ORDER BY m.id",
						Modelo.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Modelo> results = findAllQuery.getResultList();
		return results;
	}

	@GET
	@Path("/marca/{marca_id:[0-9][0-9]*}")
	@Produces("application/json")
	public Set<Modelo> findByMarca_Id(@PathParam("marca_id") Long id) {
		marca entity = em.find(marca.class, id);
		  Set<Modelo> results= entity.getModelo();
		System.out.println(results);
		  /*TypedQuery<Modelo> findByIdQuery = em
				.createQuery(
						"SELECT  m FROM Modelo m  WHERE m.marca_id = :entityId ORDER BY m.id",
						Modelo.class);
		findByIdQuery.setParameter("entityId", id);
		 
		
		final List<Modelo>	  results = findByIdQuery.getResultList();
		*/
		return results;
	}
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, Modelo entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(Modelo.class, id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			entity = em.merge(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT)
					.entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}
}
