package org.se.lab;

public class Money
{
	/*
	 * Constructor
	 */
	public Money(final long cents)
	{
		setCents(cents);
	}
	
	
	/*
	 * Property: cents
	 */
	private long cents;
	public final long getCents()
	{
		return cents;
	}
	protected final void setCents(final long cents)
	{
		this.cents = cents;
	}
	
	
	/*
	 * Operations
	 */
	
	public String toString()
	{
		return String.format("%5.2f", cents/100.0);
	}
}
