package com.template.app.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.template.app.entity.CommentEntity;
import com.template.app.exception.AppException;
import com.template.app.service.CommentService;


@Path("/comments")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class CommentRest {
	
	private final static Logger LOGGER = Logger.getLogger(CommentRest.class.getName());
	
	@Inject
	private CommentService commentService;

	@GET
	@Path("/")
	public List<CommentEntity> getAllComments() throws AppException{
		
		LOGGER.info("CommentRest.getAllComments");
		List<CommentEntity> listComments = commentService.retrieveAll();
		LOGGER.info("CommentRest.getAllComments: " + listComments);
		return listComments;
	}
	
	@GET
	@Path("/{id}")
	public CommentEntity get( @PathParam("id") Long entityId) throws AppException {
		LOGGER.info("CommentRest.get: id " + entityId);
		CommentEntity comment =  commentService.get(entityId);
		LOGGER.info("CommentRest.get: " + comment);
		return comment;
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteById( @PathParam("id") Long entityId) throws AppException {
		LOGGER.info("CommentRest.deleteById: id " + entityId);
		commentService.deleteById(entityId);
		LOGGER.info("CommentRest.deleteById return");
	}

}
