package org.se.lab.commons;

public class RPCCommunicationException
	extends RPCException
{
	private static final long serialVersionUID = 1L;

	public RPCCommunicationException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public RPCCommunicationException(String message)
	{
		super(message);
	}

}
