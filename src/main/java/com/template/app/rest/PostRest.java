package com.template.app.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.template.app.entity.CommentEntity;
import com.template.app.entity.PostEntity;
import com.template.app.exception.AppException;
import com.template.app.service.PostService;


@Path("/posts")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class PostRest {
	
	private final static Logger LOGGER = Logger.getLogger(PostRest.class.getName());
	
	@Inject
	private PostService postService;

	@GET
	@Path("/")
	public List<PostEntity> getAllPost() throws AppException{
		
		LOGGER.info("PostRest.getAllPost");
		List<PostEntity> listPosts = postService.retrieveAll();
		LOGGER.info("PostRest.getAllPost: " + listPosts);
		return listPosts;
	}
	
	@GET
	@Path("/{id}")
	public PostEntity get( @PathParam("id") Long entityId) throws AppException {
		LOGGER.info("PostRest.get: id " + entityId);
		PostEntity post =  postService.get(entityId);
		LOGGER.info("PostRest.get: " + post);
		return post;
	}
	
	@GET
	@Path("/{id}/comments")
	public List<CommentEntity> getPostComments( @PathParam("id") Long entityId) throws AppException {
		LOGGER.info("PostRest.getPostComments: id " + entityId);
		List<CommentEntity> lstComments =  postService.getPostComments(entityId);
		LOGGER.info("PostRest.getPostComments: " + lstComments);
		return lstComments;
	}
	
	@POST
	@Path("/{id}/comments")
	public CommentEntity createCommentByPost( @PathParam("id") Long entityPostId, CommentEntity comment) throws AppException {
		/*
		JSON DE EXEMPLO:
		{
		    "text": "novo texto comentário",
		    "userName": "Ana Luiza"
		}
		*/
		LOGGER.info("PostRest.createCommentByPost: id " + entityPostId);
		CommentEntity newComment =  postService.createCommentByPost(entityPostId, comment);
		LOGGER.info("PostRest.createCommentByPost: " + newComment);
		return newComment;
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteById( @PathParam("id") Long entityId) throws AppException {
		LOGGER.info("PostRest.deleteById: id " + entityId);
		postService.deleteById(entityId);
		LOGGER.info("PostRest.deleteById return");
	}

}
