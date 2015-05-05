package org.se.lab.client;

import org.se.lab.commons.Marshaller;
import org.se.lab.commons.RPCRequest;
import org.se.lab.commons.RPCResponse;


public class Requestor
{	
	/*
	 * Constructor
	 */
	public Requestor(ClientRequestHandler requestHandler)
	{
		if(requestHandler == null)
			throw new IllegalArgumentException();
		
		this.requestHandler = requestHandler;
	}
	
	
	/*
	 * Association: ---[1]-> requestHandler:ClientRequestHandler
	 */
	private final ClientRequestHandler requestHandler;


	public void invoke(RPCRequest request, RPCResponse response)
	{
		String requestMessage = Marshaller.marshal(request);
		String responseMessage = requestHandler.sendMessage(requestMessage);			
		Marshaller.unmershal(response, responseMessage);
	}
}
