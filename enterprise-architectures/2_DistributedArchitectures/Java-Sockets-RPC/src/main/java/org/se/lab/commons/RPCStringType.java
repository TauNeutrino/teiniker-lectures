package org.se.lab.commons;


public class RPCStringType
	extends RPCType
{
	/*
	 * Constructor
	 */
	public RPCStringType(String value)
	{
		setValue(value);
	}
	
	/*
	 * Property: value:String
	 */
	private String value;

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		if(value == null)
			throw new IllegalArgumentException();
		this.value = value;
	}
	
	@Override
	public String toString()
	{
		return getValue();
	}
}
