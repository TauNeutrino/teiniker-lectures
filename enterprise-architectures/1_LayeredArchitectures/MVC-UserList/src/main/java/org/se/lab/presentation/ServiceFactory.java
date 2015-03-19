package org.se.lab.presentation;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.se.lab.business.UserService;
import org.se.lab.business.UserServiceImpl;
import org.se.lab.data.UserDAOImpl;

public class ServiceFactory
{
	private final Logger logger = Logger.getLogger(ServiceFactory.class);

	public UserService createUserService()
	{
		logger.debug("createUserService()");

		Connection c = createConnection();
		UserDAOImpl userDAO = new UserDAOImpl(c);

		UserServiceImpl service = new UserServiceImpl(c);
		service.setUserDAO(userDAO);

		logger.debug("    service: " + service);
		return service;
	}

	
	/*
	 * Utility methods
	 */

	private Connection createConnection()
	{
		logger.debug("createConnection()");
		
		Connection c = null;
		try
		{
			Context initialContext = new InitialContext();
			DataSource ds = (DataSource)initialContext.lookup("java:jboss/datasources/MySqlDS"); 
			c = ds.getConnection();
			return c;
		}
		catch (NamingException | SQLException e)
		{
			throw new IllegalStateException("Can't create connection!", e);
		}
	}
}
