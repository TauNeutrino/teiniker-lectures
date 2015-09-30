package org.se.lab;

public class Dvd
	extends Article
{
	/*
	 * Constructor
	 */
	public Dvd(final int id, final String description, final long price)
	{
		super(id, description,price);
	}	
	
	
	/*
	 * Operations
	 */

	@Override
	public String toString()
	{
		return "DVD:\t" + super.toString();
	}

	@Override
	public String toXml()
	{
		return "<dvd" + super.toXml() + "/>";
	}
}
