package org.se.lab.presentation.commands;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.se.lab.business.UserService;


public class LoginCommand
	extends WebCommand
{
	private final Logger LOG = Logger.getLogger(LoginCommand.class);
	
	@Override
	public void process() throws ServletException, IOException
	{
	    Connection c = null;
		try
		{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			c = createConnection();
			
			UserService service = factory.createUserService(c);
			boolean isValid = service.login(username, password);
			if(isValid)
			{
				req.setAttribute("message", "Login successful, welcome " + username + ":-)");
			}
			else
			{
				req.setAttribute("message", "Login failed!");
			}
		}
		catch(Exception e)
		{
		    req.setAttribute("message", "Error: " + e.getMessage());
			LOG.error("Can't login!", e);
		}
		finally
        {
            if(c != null)
            {
                try
                {
                    c.close();
                }
                catch (SQLException e)
                {
                    req.setAttribute("message", "Error: " + e.getMessage());
                    LOG.error("Can't close database connection!", e);
                }
            }
        }
		forward("/login.jsp");			
	}
}
