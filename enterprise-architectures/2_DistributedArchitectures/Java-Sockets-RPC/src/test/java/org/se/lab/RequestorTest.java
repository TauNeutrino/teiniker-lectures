package org.se.lab;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.client.ClientRequestHandler;
import org.se.lab.client.Requestor;
import org.se.lab.commons.RPCBooleanType;
import org.se.lab.commons.RPCRequest;
import org.se.lab.commons.RPCResponse;
import org.se.lab.commons.RPCStringType;
import org.se.lab.commons.RPCVoidType;

public class RequestorTest
{
	private Requestor requestor;
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
		requestor = new Requestor(requestHandler);
	}

	@Test
	public void testaddUser()
	{		
		{
			RPCRequest request = new RPCRequest("UserService:1.0","addUser", new RPCStringType("teini"), new RPCStringType("xxxxxxxxxx"));
			RPCResponse response = new RPCResponse(new RPCVoidType());
	
			requestor.invoke(request,response);
			
			Assert.assertNotNull(response.getType());
			Assert.assertNull(response.getException());
		}
		
		{
			RPCRequest request = new RPCRequest("UserService:1.0","login", new RPCStringType("teini"), new RPCStringType("xxxxxxxxxx"));		
			RPCResponse response = new RPCResponse(new RPCBooleanType()); 

			requestor.invoke(request, response);
			
			Assert.assertNull(response.getException());
			Assert.assertTrue(((RPCBooleanType)response.getType()).getValue());
		}

		{
			RPCRequest request = new RPCRequest("UserService:1.0","login", new RPCStringType("homer"), new RPCStringType("xxxxxxxxxx"));		
			RPCResponse response = new RPCResponse(new RPCBooleanType()); 
			
			requestor.invoke(request, response);
			
			Assert.assertNull(response.getException());
			Assert.assertFalse(((RPCBooleanType)response.getType()).getValue());
		}	
	}
}
