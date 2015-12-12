package org.se.lab.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import org.apache.log4j.Logger;

@Path("/v1/users")
@Stateless
public class UserResourceEJB
{
	private final Logger LOG = Logger.getLogger(UserResourceEJB.class);
	
	public UserResourceEJB()
	{
		LOG.info(UserResourceEJB.class.getName() + " created");
	}
	
	
	@POST
	@Consumes({"application/xml", "application/json"})
	public void insert(@Valid UserDTO user)
	{
		LOG.info("insert: " + user);
	}
	
	
	@PUT
	@Path("{id}")
	@Consumes("application/xml")
	public void update(@PathParam("id") int id, UserDTO user)
	{
		LOG.info("update to " + user);

		// TODO
	}

	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") int id)
	{
		LOG.info("delete: " + id);
		
		// TODO
	}
	
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<UserDTO> findAll()
	{
		LOG.info("find all Users");
		
		List<UserDTO> list = new ArrayList<>();
		list.add(new UserDTO(1,"homer", "ijD8qepbRnIsva0kx0cKRCcYysg="));
		list.add(new UserDTO(2,"marge", "xCSuPDv2U6I5jEO1wqvEQ/jPYhY="));
		list.add(new UserDTO(3,"bart", "Ls4jKY8G2ftFdy/bHTgIaRjID0Q="));
		list.add(new UserDTO(4,"lisa", "xO0U4gIN1F7bV7X7ovQN2TlSUF4="));
		return list;
	}
	
	
	@GET
	@Path("{id}")
	@Produces({"application/xml", "application/json"})
	public UserDTO findById(@PathParam("id") @Min(1) int id) 
		throws WebApplicationException
	{
		LOG.info("find User with id=" + id);

		UserDTO user = new UserDTO(7,"bart", "Ls4jKY8G2ftFdy/bHTgIaRjID0Q=");
		return user;
	}
}
