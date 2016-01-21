package org.se.lab.util;

public final class Validator
{
	private Validator() {}
	
	public static void validateNotNull(final Object o, final String message)
	{
		if(o == null)
			throw new NullPointerException(message);
	}
	
	public static void validateString(final String s, final int min, final int max, final String message)
	{
		validateNotNull(s, message);
		if(s.length() < min || s.length() > max)
			throw new IllegalArgumentException(message + " = \"" + s + "\"");
	}

	
	public static void validateLong(final long i, final long min, final long max, final String message)
	{
		if(i < min || i > max)
			throw new IllegalArgumentException(message + " = " + i);
	}
	public static void validateLong(final long i, final long min, final String message)
	{
		if(i < min || i > Long.MAX_VALUE)
			throw new IllegalArgumentException(message + " = " + i);
	}

}
