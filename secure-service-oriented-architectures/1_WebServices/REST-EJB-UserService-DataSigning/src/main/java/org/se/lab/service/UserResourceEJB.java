package org.se.lab.service;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.se.lab.data.User;
import org.se.lab.data.UserDAO;

@Path("/v1/users")
@Stateless
public class UserResourceEJB
{
	private final Logger LOG = Logger.getLogger(UserResourceEJB.class);
	
	@Inject
	private UserDAO dao;
		
	public UserResourceEJB()
	{
		LOG.debug(UserResourceEJB.class.getName() + " created");
	}
	
	
	/*
	 * Response codes + error handling
	 * 
	 * For the case we need to explicitly control the response sent back to 
	 * the client, a method can return instances of Response.
	 * Response objects can not be created directly, they are created from 
	 * ResponseBuilder instances.
	 */	
	@POST
	@Consumes({"application/xml", "application/json"})
	public Response insert(UserDTO userDTO)
	{
		LOG.info("insert: " + userDTO);
		try
		{
		    User u = userDTO.toUser();
		    User user = dao.createUser(u.getUsername(), u.getPassword());
		    return Response.created(URI.create("/users/" + user.getId())).build();
		}
		catch(IllegalStateException e)
		{
		    return Response.status(Status.NOT_ACCEPTABLE).build();
		}
	}
	
		
	@GET
	@Produces({"application/xml", "application/json"})
	public List<UserDTO> findAll()
	{
		LOG.debug("find all Users");
		
		List<User> list = dao.findAll();
		List<UserDTO> result = UserDTO.toUserDTOList(list);
		return result;
	}
	
	
	@GET
	@Path("{id}")
	@Produces({"application/xml", "application/json"})
	public UserDTO findById(@PathParam("id") int id) 
		throws WebApplicationException
	{
		LOG.debug("find User with id=" + id);

		User user = dao.findById(id);

		if(user == null)
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		else
			return new UserDTO(user);
	}
}
