package com.template.app.repository;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.template.app.entity.PostEntity;
import com.template.app.exception.AppException;
import com.template.app.messages.AppBeanMessages;


@Stateless
public class PostRepository extends AbstractRepository<Long, PostEntity> {
	
	private final static Logger LOGGER = Logger.getLogger(PostRepository.class.getName());
	
	public List<PostEntity> retrieveAll() {
		try {
			LOGGER.info("PostRepository.retrieveAll");
			
			Query query = getEntityManager().createNamedQuery("PostEntity.retrieveAll");

			List<PostEntity> list = (List<PostEntity>)query.getResultList( );
			LOGGER.info("PostRepository.retrieveAll: return "+list);
			return list;

		} catch (AppException e) {
			LOGGER.severe("PostRepository.retrieveAll AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("PostRepository.retrieveAll Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}

}
