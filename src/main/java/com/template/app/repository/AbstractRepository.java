package com.template.app.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.template.app.entity.IEntity;

/**
 *  Generic repository class to define entity manager configuration
 * 
 * @author rogerio.baldini
 *
 * @param <PK> Primary Key
 * @param <E> Entity
 */
public abstract class AbstractRepository<PK extends Serializable, E extends IEntity<PK>> {

	@PersistenceContext(unitName = "blog-persistence-unit")
	private EntityManager entityManager;

	protected EntityManager getEntityManager()
	{
		return entityManager;
	}
}
