package org.se.lab;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.client.ClientProxy;
import org.se.lab.client.ClientRequestHandler;
import org.se.lab.client.Requestor;
import org.se.lab.server.domain.UserService;

public class ClientProxyTest
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

	@Test
	public void testLogin()
	{
		service.addUser("teini", "xxxxxxxxxx");     
		
		{
			boolean result = service.login("teini", "xxxxxxxxxx");        
			Assert.assertTrue(result);
		}
		
		{
			boolean result = service.login("homer", "xxxxxxxxxx");        
			Assert.assertFalse(result);
		}		
	}	
}
