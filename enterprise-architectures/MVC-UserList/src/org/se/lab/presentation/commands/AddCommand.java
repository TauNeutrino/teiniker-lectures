package org.se.lab.presentation.commands;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.se.lab.business.UserService;


public class AddCommand
	extends WebCommand
{
	private final Logger logger = Logger.getLogger(AddCommand.class);
	
	@Override
	public void process() throws ServletException, IOException
	{
		try
		{
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
 		
			UserService service = factory.createUserService();
			service.addUser(firstName, lastName, username, password);
			req.setAttribute("message", "User '" + username + "' successfully added.");
		}
		catch(Exception e)
		{
		    req.setAttribute("message", "Error: " + e.getMessage());
			logger.error("Can't add user!", e);
		}
		forward("/index.jsp");			
	}
}
