package org.se.lab.server;

import org.se.lab.commons.Logger;
import org.se.lab.commons.Marshaller;
import org.se.lab.commons.RPCApplicationException;
import org.se.lab.commons.RPCBooleanType;
import org.se.lab.commons.RPCCommunicationException;
import org.se.lab.commons.RPCResponse;
import org.se.lab.commons.RPCVoidType;
import org.se.lab.server.domain.UserService;


/*
 * This concrete Invoker class will be generated from the Interface Description 
 * and is used as a remote facade.
 */

public class UserServiceInvoker
	implements Invoker
{
	/*
	 * Constructor
	 */
	public UserServiceInvoker(UserService service)
	{
		if(service == null)
			throw new IllegalArgumentException();
		this.service = service;
	}

	
	/*
	 * Association: ---[1]-> service:UserService
	 */
	private final UserService service;

	
	/*
	 * The invoker demarshalls the request and dispatches it to the remote 
	 * object implementation.
	 * Results are returned as replies in the reverse order.
	 */
	public String invoke(String message)
	{
		Logger.log("invoke: " + message);
		
		String[] tokens = message.split(",");
		
		// Check message for being a request
		if(!tokens[0].equals("request"))
			throw new IllegalArgumentException("Invalid request message: is not a request!");

		// Check for the right class name and version
		if(!tokens[1].equals("UserService:1.0"))
			throw new IllegalArgumentException("Invalid request message: wrong remote object type or version!");

		// Invoke the right operation on the remote object
		switch(tokens[2])
		{
			case "addUser":
				return invokeAddUser(tokens[3], tokens[4]);
			
			case "login":
				return invokeLogin(tokens[3], tokens[4]);
					
			default:
				return Marshaller.marshal(
					new RPCResponse(
						new RPCCommunicationException("Unknown operation: " + message)));
		}
	}
	
	
	protected String invokeAddUser(String arg1, String arg2)
	{
		RPCResponse response;
		try
		{
			// void addUser(String username, String password);
			service.addUser(arg1, arg2);			
			response = new RPCResponse(new RPCVoidType());
		}
		catch(Exception e)
		{
			response = new RPCResponse(new RPCApplicationException(e.getMessage(),e));				
		}
		return Marshaller.marshal(response);
	}
	
	
	protected String invokeLogin(String arg1, String arg2)
	{
		RPCResponse response;
		try
		{
			// boolean login(String username, String password);
			boolean result = service.login(arg1, arg2);
			response = new RPCResponse(new RPCBooleanType(result));
		}
		catch(Exception e)
		{
			response = new RPCResponse(new RPCApplicationException(e.getMessage(), e));				
		}
		return Marshaller.marshal(response);
	}
}
