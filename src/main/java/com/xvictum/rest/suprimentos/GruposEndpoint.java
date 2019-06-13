package com.xvictum.rest.suprimentos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
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

import org.hibernate.Query;

import com.xvictum.model.suprimentos.Grupos;

/**
 * 
 */
@Stateless
@Path("/grupos")
public class GruposEndpoint {
	@PersistenceContext(unitName = "persistence-xvictum")
	private EntityManager em;

	@POST
	@Consumes("application/json")
	public Response create(Grupos entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(GruposEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") Long id) {
		Grupos entity = em.find(Grupos.class, id);
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
		TypedQuery<Grupos> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT g FROM Grupos g WHERE g.id = :entityId ORDER BY g.id",
						Grupos.class);
		findByIdQuery.setParameter("entityId", id);
		Grupos entity;
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
	@Path("/nivel/{nivel:[0-9][0-9]*}")
	@Produces("application/json")
	public List<Grupos> findByNivel(@PathParam("nivel") int nivel){
		List<Grupos> list;
		TypedQuery<Grupos> findByNivel= em.createQuery("SELECT DISTINCT g FROM Grupos g where g.nivel= :nivel " , Grupos.class);
	     findByNivel.setParameter("nivel", nivel);
	    try {
	    	 list= findByNivel.getResultList();
		     	
		} catch (NoResultException nre) {
			list = null;
		}
	     
	    
	      return list;	     
	}
	@GET
	@Path("/origem/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public List<Grupos> findByOrigem(@PathParam("id") int id){
		
		List<Grupos> list;
		TypedQuery<Grupos> findGrupoByOrigem= em.createQuery("SELECT DISTINCT g FROM Grupos g where g.origem= :origem",Grupos.class);
		findGrupoByOrigem.setParameter("origem",id);
		
		try {
			list=findGrupoByOrigem.getResultList();
			
			
		} catch (NoResultException nre) {
			list=null;
		}
		return list;
	}

	@GET
	@Produces("application/json")
	public List<Grupos> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<Grupos> findAllQuery = em.createQuery(
				"SELECT DISTINCT g FROM Grupos g ORDER BY g.id", Grupos.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Grupos> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, Grupos entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(Grupos.class, id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			entity = em.merge(entity);
			

			Query q=(Query) em.createNativeQuery("update Grupos set nivel= :nivel WHERE origem= :id");
		       q.setParameter("nivel", entity.getNivel()+1);
		       q.setParameter("id", entity.getId());
			q.executeUpdate();
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT)
					.entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}
}
