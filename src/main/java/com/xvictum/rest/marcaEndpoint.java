package com.xvictum.rest;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateful;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
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

import com.xvictum.model.marca;

/**
 * 
 */
@Stateful
@Path("/marcas")
public class marcaEndpoint {
	@PersistenceContext(unitName = "persistence-xvictum", type= PersistenceContextType.EXTENDED)
	private EntityManager em;

	@POST
	@Consumes("application/json")
	public Response create(marca entity) {
		System.out.println("Post: "+entity);
		em.persist(entity);
		
		return Response.created(
				UriBuilder.fromResource(marcaEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") Long id) {
		marca entity = em.find(marca.class, id);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		em.remove(entity);
		return Response.noContent().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces( "application/json")
	public Response findById(@PathParam("id") Long id) {
		TypedQuery<marca> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT m FROM marca m LEFT JOIN m.modelo WHERE m.id = :entityId ORDER BY m.id",
						marca.class);
		findByIdQuery.setParameter("entityId", id);
		marca entity;
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
	@Path("marca/{id:[0-9][0-9]*}")
	@Produces( "application/json")
	public Response findByIdSingle(@PathParam("id") Long id) {
		TypedQuery<marca> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT m FROM marca m LEFT JOIN FETCH m.modelo    WHERE m.id = :entityId ",
						marca.class);
		findByIdQuery.setParameter("entityId", id);
		marca entity;
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
	@Path("/{nome}")
	@Produces( "application/json")
	public List<marca> findByName(@PathParam("nome") String nome) {
		TypedQuery<marca> findByNameLikeQuery = em
				.createQuery(
						"SELECT DISTINCT m FROM marca m   WHERE m.nome like :entityId ",
						marca.class);
		findByNameLikeQuery.setParameter("entityId", nome  + "%") ;
		final List<marca> entity= findByNameLikeQuery.getResultList();
		return entity;
			}

	@GET
	@Path("marcasingle/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public marca findMarcaByModelo(@PathParam("id") Long id) {
		
		TypedQuery<marca> findbymodelo= em.createQuery("SELECT DISTINCT m FROM marca m  JOIN m.modelo mode WHERE mode.id = :modeloid",marca.class);
	    
		//TypedQuery<marca> findbymodelo= em.createQuery("SELECT DISTINCT m FROM marca m WHERE m.id in (SELECT mode.marca_id FROM modelo mode WHERE mode.id= :modeloid)",marca.class);
	    findbymodelo.setParameter("modeloid", id);
	    marca m=findbymodelo.getSingleResult();
	    System.out.println(m.getNome());
	    return m;
	
	}
	
	
	@GET
	//@Path("/all")
	@Produces( "application/json")
	public List<marca> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<marca> findAllQuery = em
				.createQuery(
						"SELECT   m FROM marca m ",
						marca.class);
		//System.out.println("SELECT  m FROM marca m");
		
		findAllQuery.setHint("org.hibernate.cacheable", true);
		//findAllQuery.setHint("org.hibernate.cacheRegion", region);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<marca> results = findAllQuery.getResultList();
		//System.out.println(results);
		
		return results;
	}
	@GET
	@Path("/all")
	@Produces( "application/json")
	public List<marca> listAllCriteria(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<marca> q = cb.createQuery(marca.class);
		Root<marca> o = q.from(marca.class);
		o.fetch("modelo", JoinType.LEFT);
		q.select(o);
		//q.where(cb.equal(o.get("id"), orderId));
		
		final List<marca> results =(List<marca>) this.em.createQuery(q).getResultList();
		return results;
	}
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, marca entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(marca.class, id) == null) {
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
