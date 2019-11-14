package com.template.app.repository;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.template.app.entity.CommentEntity;
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

	public PostEntity get(Long id) {
		try {
			LOGGER.info("PostRepository.get: id " + id);
			
			PostEntity post = GetPostById(id);
	
			LOGGER.info("PostRepository.get: return " + post);
			return post;

		} catch (AppException e) {
			LOGGER.severe("PostRepository.get AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("PostRepository.get Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	
	public List<CommentEntity> getPostComments(Long entityId) {
		try {
			LOGGER.info("PostRepository.getPostComments: id " + entityId);
			
			PostEntity post = GetPostById(entityId);
			
			List<CommentEntity> lstComments = null;
			if(post != null)
				lstComments = post.getComments();
	
			LOGGER.info("PostRepository.getPostComments: return " + lstComments);
			return lstComments;

		} catch (AppException e) {
			LOGGER.severe("PostRepository.getPostComments AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("PostRepository.getPostComments Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	
	public CommentEntity createCommentByPost(Long entityPostId, CommentEntity comment) {
		try {
			LOGGER.info("PostRepository.createCommentByPost");
			PostEntity post = GetPostById(entityPostId);
			List<CommentEntity> lstComments = post.getComments();
			lstComments.add(comment);
			 
			getEntityManager().persist(post);	
			
			LOGGER.info("PostRepository.createCommentByPost: return " + comment);
			return comment;

		} catch (AppException e) {
			LOGGER.severe("PostRepository.createCommentByPost AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("PostRepository.createCommentByPost Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	
	public void deleteById(Long entityId) {
		try {
			LOGGER.info("PostRepository.deleteById: id " + entityId);
			
			PostEntity post = GetPostById(entityId);
			getEntityManager().remove(post);
			
			LOGGER.info("PostRepository.deleteById return");

		} catch (AppException e) {
			LOGGER.severe("PostRepository.deleteById AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("PostRepository.deleteById Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	
	private PostEntity GetPostById(Long entityId) {
		
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery q = cb.createQuery(PostEntity.class);
		Root o = q.from(PostEntity.class);

		q.where(cb.equal(o.get("id"), entityId));

		PostEntity post = (PostEntity)getEntityManager().createQuery(q).getSingleResult();
		return post;
	}


	
}
