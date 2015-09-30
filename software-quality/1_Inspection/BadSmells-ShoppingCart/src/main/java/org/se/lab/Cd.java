package org.se.lab;


public class Cd
	extends Article
{
	/*
	 * Constructor
	 */
	public Cd(final int id, final String description, final long price)
	{
		super(id, description,price);
	}
	
	
	/*
	 * Operations
	 */
	
	@Override
	public String toString()
	{
		return "CD:\t" + super.toString();
	}

	@Override
	public String toXml()
	{
		return "<cd" + super.toXml() + "/>";
	}
}
