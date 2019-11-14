package com.template.app.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.template.app.entity.AuthorEntity;
import com.template.app.entity.PostEntity;
import com.template.app.exception.AppException;
import com.template.app.service.AuthorService;


@Path("/authors")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class AuthorRest {
	
	private final static Logger LOGGER = Logger.getLogger(AuthorRest.class.getName());
	
	@Inject
	private AuthorService authorService;

	@GET
	@Path("/")
	public List<AuthorEntity> getAllAuthors() throws AppException{
		LOGGER.info("AuthorRest.getAllAuthors");
		List<AuthorEntity> listAuthors = authorService.retrieveAll();
		LOGGER.info("AuthorRest.getAllAuthors: " + listAuthors);
		return listAuthors;
	}

	@GET
	@Path("/{id}")
	public AuthorEntity get( @PathParam("id") Long entityId) throws AppException {
		LOGGER.info("AuthorRest.getAuthor: id " + entityId);
		AuthorEntity author =  authorService.get(entityId);
		LOGGER.info("AuthorRest.getAuthor: " + author);
		return author;
	}
	
	@GET
	@Path("/{id}/posts")
	public List<PostEntity> getAuthorPosts( @PathParam("id") Long entityId) throws AppException {
		LOGGER.info("AuthorRest.getAuthorPosts: id " + entityId);
		List<PostEntity> lstPosts =  authorService.getAuthorPosts(entityId);
		LOGGER.info("AuthorRest.getAuthorPosts: " + lstPosts);
		return lstPosts;
	}
	
	@POST
	@Path("/")
	public AuthorEntity create(AuthorEntity author) throws AppException {
		/*
		JSON DE EXEMPLO:
		{
			"name": "Ritchie Blackmore"
		}
		*/
		LOGGER.info("AuthorRest.create");
		AuthorEntity newAuthor = authorService.create(author);
		LOGGER.info("AuthorRest.create: " + newAuthor);
		return newAuthor;
	}
	
	@POST
	@Path("/{id}/posts")
	public PostEntity createPostByAuthor( @PathParam("id") Long entityAuthorId, PostEntity post) throws AppException {
		/*
		JSON DE EXEMPLO:
		{
		    "text": "novo texto",
		    "title": "novo titulo"
		}
		*/
		LOGGER.info("AuthorRest.createPostByAuthor: id " + entityAuthorId);
		PostEntity newPost =  authorService.createPostByAuthor(entityAuthorId, post);
		LOGGER.info("AuthorRest.createPostByAuthor: " + newPost);
		return newPost;
	}
	
	@PUT
	@Path("/")
	public void update(AuthorEntity author) throws AppException {
		/*
		JSON DE EXEMPLO para atualizar:
		{
			"id": 1,
			"name": "NOVO NOME"
		}
		
		JSON DE EXEMPLO que cria como o POST:
		{
			"name": "TESTE"
		}
		*/
		LOGGER.info("AuthorRest.update");
		authorService.update(author);
		LOGGER.info("AuthorRest.update return");
	}
	
	@PUT
	@Path("/{id}/posts")
	public void updatePostByAuthor( @PathParam("id") Long entityAuthorId, PostEntity post) throws AppException {
		/*
		JSON DE EXEMPLO para atualizar:
		{
			"id": 1,
			"text": "novo texto",
		    "title": "novo titulo"
		}
		
		JSON DE EXEMPLO que cria como o POST:
		{
			"text": "novo texto",
		    "title": "novo titulo"
		}
		*/
		LOGGER.info("AuthorRest.updatePostByAuthor");
		authorService.updatePostByAuthor(entityAuthorId, post);
		LOGGER.info("AuthorRest.updatePostByAuthor return");
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteById( @PathParam("id") Long entityId) throws AppException {
		LOGGER.info("AuthorRest.deleteById: id " + entityId);
		authorService.deleteById(entityId);
		LOGGER.info("AuthorRest.deleteById return");
	}
	
	@DELETE
	@Path("/{id}/posts/{idPost}")
	public void deletePostById( @PathParam("id") Long authorId, @PathParam("idPost") Long postId) throws AppException {
		LOGGER.info("AuthorRest.deletePostById: id " + postId);
		authorService.deletePostById(authorId, postId);
		LOGGER.info("AuthorRest.deletePostById return");
	}
}
