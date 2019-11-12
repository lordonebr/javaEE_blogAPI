package com.template.app.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.template.app.entity.PostEntity;
import com.template.app.exception.AppException;
import com.template.app.service.PostService;


@Path("/post")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class PostRest {
	
	private final static Logger LOGGER = Logger.getLogger(PostRest.class.getName());
	
	@Inject
	private PostService postService;

	@GET
	@Path("/all")
	public List<PostEntity> getAllPost() throws AppException{
		
		LOGGER.info("PostRest.getAllPost");
		List<PostEntity> listPosts = postService.retrieveAll();
		LOGGER.info("PostRest.getAllPost: " + listPosts);
		return listPosts;
	}

}
