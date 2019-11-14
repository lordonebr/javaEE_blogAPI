package com.template.app.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.template.app.entity.CommentEntity;
import com.template.app.entity.PostEntity;
import com.template.app.repository.PostRepository;


@Stateless
public class PostService {
	
	@Inject
	private PostRepository postRepository;
	
	private final static Logger LOGGER = Logger.getLogger(PostService.class.getName());
	
	public List<PostEntity> retrieveAll() {	
		LOGGER.info("PostService.retrieveAll");
		
		List<PostEntity> listPosts = postRepository.retrieveAll();
		
		LOGGER.info("PostService.retrieveAll: " + listPosts);
		return listPosts;
	}

	public PostEntity get(Long entityId) {
		LOGGER.info("PostService.get: id " + entityId);
		
		PostEntity post = postRepository.get(entityId);
		
		LOGGER.info("PostService.get: " + post);
		
		return post;
	}
	
	public List<CommentEntity> getPostComments(Long entityId) {
		LOGGER.info("PostService.getPostComments: id " + entityId);
		
		List<CommentEntity> lstComments =  postRepository.getPostComments(entityId);
		
		LOGGER.info("PostService.getPostComments: " + lstComments);
		
		return lstComments;
	}
	
	public CommentEntity createCommentByPost(Long entityPostId, CommentEntity comment) {
		LOGGER.info("PostService.createCommentByPost");
		
		CommentEntity newComment =  postRepository.createCommentByPost(entityPostId, comment);
		
		LOGGER.info("PostService.createCommentByPost: " + newComment);
		
		return newComment;
	}

	public void deleteById(Long entityId) {
		LOGGER.info("PostService.deleteById: id " + entityId);
		
		postRepository.deleteById(entityId);
		
		LOGGER.info("PostService.deleteById return");
	}

}
