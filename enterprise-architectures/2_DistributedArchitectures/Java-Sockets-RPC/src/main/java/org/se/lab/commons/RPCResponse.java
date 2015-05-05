package org.se.lab.commons;


public class RPCResponse
{
	/*
	 * Constructor
	 */
	public RPCResponse(RPCType type)
	{
		setType(type);
	}
	
	public RPCResponse(RPCException exception)
	{
		setException(exception);
	}
	
	
	/*
	 * Association: type:RPCType
	 */
	private RPCType type;
	public RPCType getType()
	{
		return type;
	}
	public void setType(RPCType result)
	{
		this.type = result;
	}

	
	/*
	 * Association: ---[1]-> exception:RPCException
	 */
	private RPCException exception;
	public RPCException getException()
	{
		return exception;
	}
	public void setException(RPCException exception)
	{
		this.exception = exception;
	}
}
