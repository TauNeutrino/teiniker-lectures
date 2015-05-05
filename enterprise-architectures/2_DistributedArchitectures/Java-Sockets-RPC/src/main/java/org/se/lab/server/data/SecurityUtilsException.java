package org.se.lab.server.data;

public class SecurityUtilsException
	extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public SecurityUtilsException(String message)
	{
		super(message);
	}
	
	public SecurityUtilsException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
