package com.template.app.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.template.app.entity.CommentEntity;
import com.template.app.repository.CommentRepository;


@Stateless
public class CommentService {
	
	@Inject
	private CommentRepository commentRepository;
	
	private final static Logger LOGGER = Logger.getLogger(CommentService.class.getName());
	
	public List<CommentEntity> retrieveAll() {	
		LOGGER.info("CommentService.retrieveAll");
		
		List<CommentEntity> listComments = commentRepository.retrieveAll();
		
		LOGGER.info("CommentService.retrieveAll: " + listComments);
		return listComments;
	}

	public CommentEntity get(Long entityId) {
		LOGGER.info("CommentService.get: id " + entityId);
		
		CommentEntity comment = commentRepository.get(entityId);
		
		LOGGER.info("CommentService.get: " + comment);
		
		return comment;
	}

	public void deleteById(Long entityId) {
		LOGGER.info("CommentService.deleteById: id " + entityId);
		
		commentRepository.deleteById(entityId);
		
		LOGGER.info("CommentService.deleteById return");
	}
}
