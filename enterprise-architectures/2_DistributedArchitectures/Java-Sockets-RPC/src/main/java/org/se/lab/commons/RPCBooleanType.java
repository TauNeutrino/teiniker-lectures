package org.se.lab.commons;


public class RPCBooleanType
	extends RPCType
{
	/*
	 * Constructor
	 */
	public RPCBooleanType(boolean value)
	{
		setValue(value);
	}
	
	public RPCBooleanType()
	{
		setValue(false);
	}
	
	
	/*
	 * Property: value:boolean
	 */
	private boolean value;

	public boolean getValue()
	{
		return value;
	}

	public void setValue(boolean value)
	{
		this.value = value;
	}
	
	@Override
	public String toString()
	{
		return Boolean.toString(getValue());
	}
}
