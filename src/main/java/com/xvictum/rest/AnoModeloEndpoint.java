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
import com.xvictum.model.AnoModelo;
import com.xvictum.model.Modelo;

/**
 * 
 */
@Stateful
@Path("/anomodelos")
public class AnoModeloEndpoint {
	@PersistenceContext(unitName = "persistence-xvictum", type=PersistenceContextType.EXTENDED)
	private EntityManager em;

	@POST
	@Consumes("application/json")
	public Response create(AnoModelo entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(AnoModeloEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") Long id) {
		AnoModelo entity = em.find(AnoModelo.class, id);
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
		TypedQuery<AnoModelo> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT a FROM AnoModelo a WHERE a.id = :entityId ORDER BY a.id",
						AnoModelo.class);
		findByIdQuery.setParameter("entityId", id);
		AnoModelo entity;
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
	
	/*@GET
	@Path("/modelo/{modelo_id:[0-9][0-9]*}")
    @Produces("application/json")
	public Set<AnoModelo> findAnoModeloByModelo(@PathParam("modelo_id") Long id) {
		Modelo entity = em.find(Modelo.class,id);
		
		final Set<AnoModelo> results = entity.getAnoModelo();
		
		return results;
	}*/
	@GET
	@Produces("application/json")
	public List<AnoModelo> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<AnoModelo> findAllQuery = em.createQuery(
				"SELECT DISTINCT a FROM AnoModelo a ORDER BY a.id",
				AnoModelo.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<AnoModelo> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, AnoModelo entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(AnoModelo.class, id) == null) {
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
