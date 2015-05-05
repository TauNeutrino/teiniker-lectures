package org.se.lab.client;

import org.se.lab.commons.RPCApplicationException;
import org.se.lab.commons.RPCBooleanType;
import org.se.lab.commons.RPCRequest;
import org.se.lab.commons.RPCResponse;
import org.se.lab.commons.RPCStringType;
import org.se.lab.commons.RPCVoidType;
import org.se.lab.server.domain.UserService;


public class ClientProxy
	implements UserService
{
	/*
	 * Constructor
	 */
	public ClientProxy(Requestor requestor)
	{
		if(requestor == null)
			throw new IllegalArgumentException();
		this.requestor = requestor;
	}


	/*
	 * Association: ---[1]-> requestor:Requestor 
	 */
	private final Requestor requestor;

	
	public void addUser(String username, String password)
	{
		RPCRequest request = new RPCRequest("UserService:1.0","addUser", new RPCStringType(username), new RPCStringType(password));
		RPCResponse response = new RPCResponse(new RPCVoidType());
		
		requestor.invoke(request, response);
		
		if(response.getException() != null)
		{
			if(response.getException() instanceof RPCApplicationException)
			{
				// TODO: reconstruct application exception e.g. IllegalArgumentException 
				throw new IllegalArgumentException(response.getException().getMessage());
			}
			else
			{
				throw response.getException();
			}
		}
	}

	
	public boolean login(String username, String password)
	{
		RPCRequest request = new RPCRequest("UserService:1.0","login", new RPCStringType(username), new RPCStringType(password));		
		RPCResponse response = new RPCResponse(new RPCBooleanType()); 
		
		requestor.invoke(request, response);
		
		if(response.getException() != null)
		{
			if(response.getException() instanceof RPCApplicationException)
			{
				// TODO: reconstruct application exception e.g. IllegalArgumentException 
				throw new RuntimeException(response.getException().getMessage());
			}
			else
			{
				throw response.getException();
			}
		}
		else
		{
			return ((RPCBooleanType)response.getType()).getValue();
		}
	}
}
