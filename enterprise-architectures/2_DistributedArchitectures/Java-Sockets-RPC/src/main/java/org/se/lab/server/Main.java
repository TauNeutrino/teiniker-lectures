package org.se.lab.server;

import java.io.IOException;
import java.util.Properties;

import org.se.lab.server.domain.UserService;
import org.se.lab.server.domain.UserServiceImpl;

/*
 * This Main class is responsible for setting up the server side objects so
 * that client requests can be handled.
 */

public class Main
{
	public static void main(String... args) 
		throws IOException
	{
		// setup
		Properties properties = new Properties();
		properties.load(properties.getClass().getResourceAsStream("/org/se/lab/commons/socket.properties"));
		int port = Integer.parseInt(properties.getProperty("port"));

		
		UserService remoteObject = new UserServiceImpl();
		Invoker invoker = new UserServiceInvoker(remoteObject);
		ServerRequestHandler requestHandler = new ServerRequestHandler(port, invoker);
		
		// run server
		requestHandler.run();
	}
}
