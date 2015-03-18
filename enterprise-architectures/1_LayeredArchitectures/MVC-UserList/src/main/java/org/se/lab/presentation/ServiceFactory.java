package org.se.lab.presentation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

	/*
	 * Create database connection based on the jdbc.properties file.
	 * 
	 * Note that in a real application we would use the server's DataSource
	 * concept (including a connection pool).
	 */
	private Connection createConnection()
	{
		logger.debug("getConnection()");
		try
		{
//			 Properties properties = new Properties();
//			 InputStream propertiesStream = ServiceFactory.class.getResourceAsStream("jdbc.properties");
//			 properties.load(propertiesStream);
//			 String driver = properties.getProperty("jdbc.driver");
//			 String url = properties.getProperty("jdbc.url");
//			 String username = properties.getProperty("jdbc.username");
//			 String password = properties.getProperty("jdbc.password");

			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/testdb";
			String username = "student";
			String password = "student";

			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username,	password);
			return con;
		}
		catch (ClassNotFoundException | SQLException e)
		{
			throw new IllegalStateException("Can't create connection!", e);
		}
	}
}
