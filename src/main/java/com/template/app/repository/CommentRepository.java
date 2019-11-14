package com.template.app.repository;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.template.app.entity.CommentEntity;
import com.template.app.exception.AppException;
import com.template.app.messages.AppBeanMessages;


@Stateless
public class CommentRepository extends AbstractRepository<Long, CommentEntity> {
	
	private final static Logger LOGGER = Logger.getLogger(CommentRepository.class.getName());
	
	public List<CommentEntity> retrieveAll() {
		try {
			LOGGER.info("CommentRepository.retrieveAll");
			
			Query query = getEntityManager().createNamedQuery("CommentEntity.retrieveAll");

			List<CommentEntity> list = (List<CommentEntity>)query.getResultList( );
			LOGGER.info("CommentRepository.retrieveAll: return "+list);
			return list;

		} catch (AppException e) {
			LOGGER.severe("CommentRepository.retrieveAll AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("CommentRepository.retrieveAll Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}

	public CommentEntity get(Long id) {
		try {
			LOGGER.info("CommentRepository.get: id " + id);
			
			CommentEntity comment = GetCommentById(id);
	
			LOGGER.info("CommentRepository.get: return " + comment);
			return comment;

		} catch (AppException e) {
			LOGGER.severe("CommentRepository.get AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("CommentRepository.get Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	
	public void deleteById(Long entityId) {
		try {
			LOGGER.info("CommentRepository.deleteById: id " + entityId);
			
			CommentEntity comment = GetCommentById(entityId);
			getEntityManager().remove(comment);
			
			LOGGER.info("CommentRepository.deleteById return");

		} catch (AppException e) {
			LOGGER.severe("CommentRepository.deleteById AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("CommentRepository.deleteById Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	
	private CommentEntity GetCommentById(Long entityId) {
		
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery q = cb.createQuery(CommentEntity.class);
		Root o = q.from(CommentEntity.class);

		q.where(cb.equal(o.get("id"), entityId));

		CommentEntity comment = (CommentEntity)getEntityManager().createQuery(q).getSingleResult();
		return comment;
	}
}
