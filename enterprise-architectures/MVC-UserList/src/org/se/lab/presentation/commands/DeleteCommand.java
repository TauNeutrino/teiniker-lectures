package org.se.lab.presentation.commands;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.se.lab.business.UserService;


public class DeleteCommand
	extends WebCommand
{
	private final Logger logger = Logger.getLogger(DeleteCommand.class);
	
	@Override
	public void process() throws ServletException, IOException
	{
		try
		{
			String id = req.getParameter("id");
		
			UserService service = factory.createUserService();
			service.removeUser(id);
			req.setAttribute("message", "User with id = " + id + " successfully deleted.");
		}
		catch(Exception e)
		{
		    req.setAttribute("message","Error: " + e.getMessage());
			logger.error("Can't delete user!", e);
		}
		forward("/index.jsp");			
	}
}
