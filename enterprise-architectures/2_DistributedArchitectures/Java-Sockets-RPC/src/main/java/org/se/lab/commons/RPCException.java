package org.se.lab.commons;

import java.util.Arrays;


public abstract class RPCException
	extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public RPCException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public RPCException(String message)
	{
		super(message);
	}
	
	
	@Override
	public String toString()
	{
		return getMessage() + " - " + Arrays.toString(getStackTrace());
	}
}
