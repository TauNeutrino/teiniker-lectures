package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class ParameterizedTest
{
	@Test
	public void testToString1()
	{
		testToStringWithParameter("homer");
	}

	@Test
	public void testToString2()
	{
		testToStringWithParameter("h");
	}
	
	@Test
	public void testToString3()
	{
		testToStringWithParameter("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	
	/*
	 * We can extract the common fixture setup, exercise SUT, and verify into a new
	 * parameterized test method. 
	 */
	public void testToStringWithParameter(String username)
	{
		User u = new User(7, username, "**********");
		
		final String EXPECTED = "7," + username + ",**********";
		Assert.assertEquals(EXPECTED, u.toString());
	}
}
