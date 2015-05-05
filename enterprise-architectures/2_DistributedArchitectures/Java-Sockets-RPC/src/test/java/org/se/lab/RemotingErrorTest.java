package org.se.lab;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.client.ClientProxy;
import org.se.lab.client.ClientRequestHandler;
import org.se.lab.client.Requestor;
import org.se.lab.commons.RPCCommunicationException;
import org.se.lab.server.domain.UserService;

public class RemotingErrorTest
{
	private UserService service;
	private String host;
	private int port;
	
	@Before
	public void setup() throws IOException
	{
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/org/se/lab/commons/socket.properties"));
		host = properties.getProperty("host");
		port = Integer.parseInt(properties.getProperty("port"));
		
		ClientRequestHandler requestHandler = new ClientRequestHandler(host, port);
		Requestor requestor = new Requestor(requestHandler);
		service = new ClientProxy(requestor);
	}

	/*
	 * In the case of a server-side IllegalArgument exception we get a RuntimeException.
	 * 
	 * In the case that the server is not running, we get an RPCCommunicationException.
	 */
	@Test 
	public void testLogin_InvalidUsername()
	{
		// simulate application exception
		try
		{
			service.addUser("tei", "xxxxxxxxxx");
			Assert.fail();
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Server-Side IllegalArgumentException: " + e.getMessage());
		}
		catch(RPCCommunicationException e)
		{
			System.out.println("RPCCommunicationException: " + e.getMessage());
		}
	}	
	
}
