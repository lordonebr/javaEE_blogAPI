package com.template.app.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.template.app.entity.AuthorEntity;
import com.template.app.repository.AuthorRepository;


@Stateless
public class AuthorService {
	
	@Inject
	private AuthorRepository authorRepository;
	
	private final static Logger LOGGER = Logger.getLogger(AuthorService.class.getName());
	
	public List<AuthorEntity> retrieveAll() {	
		LOGGER.info("AuthorService.retrieveAll");
		
		List<AuthorEntity> listAuthors = authorRepository.retrieveAll();
		
		LOGGER.info("AuthorService.retrieveAll: " + listAuthors);
		return listAuthors;
	}

	public AuthorEntity get(Long entityId) {
		LOGGER.info("AuthorService.get: id " + entityId);
		
		AuthorEntity author =  authorRepository.get(entityId);
		
		LOGGER.info("AuthorService.get: " + author);
		
		return author;
	}

	public AuthorEntity create(AuthorEntity author) {
		LOGGER.info("AuthorService.create");
		
		AuthorEntity newAuthor =  authorRepository.create(author);
		
		LOGGER.info("AuthorService.create: " + newAuthor);
		
		return newAuthor;
	}
	
	public void update(AuthorEntity author) {
		LOGGER.info("AuthorService.update");
		
		authorRepository.update(author);
		
		LOGGER.info("AuthorService.update return");
	}

	public void deleteById(Long entityId) {
		LOGGER.info("AuthorService.deleteById: id " + entityId);
		
		authorRepository.deleteById(entityId);
		
		LOGGER.info("AuthorService.deleteById return");
	}
}
