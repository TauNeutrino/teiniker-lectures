package org.se.lab.commons;


public class RPCApplicationException
	extends RPCException
{
	private static final long serialVersionUID = 1L;

	public RPCApplicationException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public RPCApplicationException(String message)
	{
		super(message);
	}
}
