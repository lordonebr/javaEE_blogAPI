package com.template.app.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

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
		
		PostEntity post =  postRepository.get(entityId);
		
		LOGGER.info("PostService.get: " + post);
		
		return post;
	}
}
