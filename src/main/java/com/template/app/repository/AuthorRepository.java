package com.template.app.repository;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.template.app.entity.AuthorEntity;
import com.template.app.entity.PostEntity;
import com.template.app.exception.AppException;
import com.template.app.messages.AppBeanMessages;


@Stateless
public class AuthorRepository extends AbstractRepository<Long, AuthorEntity> {
	
	private final static Logger LOGGER = Logger.getLogger(AuthorRepository.class.getName());
	
	public List<AuthorEntity> retrieveAll() {
		try {
			LOGGER.info("AuthorRepository.retrieveAll");
			
			Query query = getEntityManager().createNamedQuery("AutorEntity.retrieveAll");

			List<AuthorEntity> list = (List<AuthorEntity>)query.getResultList( );
			LOGGER.info("ProductRepository.retrieveAll: return "+list);
			return list;

		} catch (AppException e) {
			LOGGER.severe("ProductRepository.retrieveAll AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("ProductRepository.retrieveAll Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	
	public AuthorEntity get(Long id) {
		try {
			LOGGER.info("AuthorRepository.get: id " + id);
			
			AuthorEntity author = GetAuthorById(id);
	
			LOGGER.info("AuthorRepository.get: return " + author);
			return author;

		} catch (AppException e) {
			LOGGER.severe("AuthorRepository.get AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("AuthorRepository.get Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	
	public List<PostEntity> getAuthorPosts(Long entityId) {
		try {
			LOGGER.info("AuthorRepository.getAuthorPosts: id " + entityId);
			
			AuthorEntity author = GetAuthorById(entityId);
			
			List<PostEntity> lstPosts = null;
			if(author != null)
				lstPosts = author.getPosts();
	
			LOGGER.info("AuthorRepository.getAuthorPosts: return " + lstPosts);
			return lstPosts;

		} catch (AppException e) {
			LOGGER.severe("AuthorRepository.getAuthorPosts AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("AuthorRepository.getAuthorPosts Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}

	public AuthorEntity create(AuthorEntity author) {
		try {
			LOGGER.info("AuthorRepository.create");
			getEntityManager().persist(author);	
			LOGGER.info("AuthorRepository.create: return " + author);
			return author;

		} catch (AppException e) {
			LOGGER.severe("AuthorRepository.create AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("AuthorRepository.create Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	
	public PostEntity createPostByAuthor(Long entityAuthorId, PostEntity post) {
		try {
			LOGGER.info("AuthorRepository.createPostByAuthor");
			AuthorEntity author = GetAuthorById(entityAuthorId);
			List<PostEntity> lstPosts = author.getPosts();
			lstPosts.add(post);
			 
			getEntityManager().persist(author);	
			
			LOGGER.info("AuthorRepository.createPostByAuthor: return " + post);
			return post;

		} catch (AppException e) {
			LOGGER.severe("AuthorRepository.createPostByAuthor AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("AuthorRepository.createPostByAuthor Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	
	public void update(AuthorEntity author) {
		try {
			LOGGER.info("AuthorRepository.update");
			getEntityManager().merge(author);	
			LOGGER.info("AuthorRepository.update: return " + author);

		} catch (AppException e) {
			LOGGER.severe("AuthorRepository.update AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("AuthorRepository.update Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	
	public void updatePostByAuthor(Long entityAuthorId, PostEntity post) {
		try {
			LOGGER.info("AuthorRepository.updatePostByAuthor");
			AuthorEntity author = GetAuthorById(entityAuthorId);
			List<PostEntity> lstPosts = author.getPosts();
			
			if(post.getId() == null)
				lstPosts.add(post);
			else {
				for(int i = 0; i < lstPosts.size(); i++)
				{
					if(lstPosts.get(i).getId() == post.getId())
					{
						lstPosts.get(i).setAttributes(post);
						break;
					}
				}
			}
			
			getEntityManager().persist(author);	
			
			LOGGER.info("AuthorRepository.updatePostByAuthor: return " + post);

		} catch (AppException e) {
			LOGGER.severe("AuthorRepository.updatePostByAuthor AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("AuthorRepository.updatePostByAuthor Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}

	public void deleteById(Long entityId) {
		try {
			LOGGER.info("AuthorRepository.deleteById: id " + entityId);
			
			AuthorEntity author = GetAuthorById(entityId);
			getEntityManager().remove(author);
			
			LOGGER.info("AuthorRepository.deleteById:");

		} catch (AppException e) {
			LOGGER.severe("AuthorRepository.deleteById AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("AuthorRepository.deleteById Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}

	public void deletePostById(Long authorId, Long postId) {
		try {
			LOGGER.info("AuthorRepository.deletePostById");
			AuthorEntity author = GetAuthorById(authorId);
			
			List<PostEntity> lstPosts = author.getPosts();
			for(int i = 0; i < lstPosts.size(); i++)
			{
				if(lstPosts.get(i).getId().longValue() == postId)
				{
					lstPosts.remove(i);
					break;
				}
			}
			
			getEntityManager().persist(author);	
			
			LOGGER.info("AuthorRepository.deletePostById");

		} catch (AppException e) {
			LOGGER.severe("AuthorRepository.deletePostById AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("AuthorRepository.deletePostById Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}

	private AuthorEntity GetAuthorById(Long entityId) {
		
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery q = cb.createQuery(AuthorEntity.class);
		Root o = q.from(AuthorEntity.class);

		q.where(cb.equal(o.get("id"), entityId));

		AuthorEntity author = (AuthorEntity)getEntityManager().createQuery(q).getSingleResult();
		return author;
	}
}
