package org.se.lab;

import java.util.regex.Pattern;

public final class EMail
	implements Comparable<EMail>
{
	private final Pattern EMAIL_PATTERN =
		Pattern.compile("^[a-z0-9-+%.]+@[a-z0-9-.]+\\.[a-z]{2,4}$");

	/*
	 * Constructors
	 */
	public EMail(String address)
	{
		if(address == null)
			throw new IllegalArgumentException("address");

		if(!EMAIL_PATTERN.matcher(address).matches())
			throw new IllegalArgumentException("Invalid mail address: " + address);

		this.address = address;
	}


	/*
	 * Property: address:String
	 */
	private final String address;
	public final String getAddress()
	{
		return address;
	}


	/*
	 * Object methods
	 */
	public String toString()
	{
		return getAddress();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EMail other = (EMail) obj;
		if (address == null)
		{
			if (other.address != null)
				return false;
		}
		else if (!address.equals(other.address))
			return false;
		return true;
	}

	@Override
	public int compareTo(EMail o)
	{
		return getAddress().compareTo(o.getAddress());
	}
}
