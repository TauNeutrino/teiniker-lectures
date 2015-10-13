package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class SmellyVerificationTest
{

	/*
	 * Here we compare each attribute of an object with a separate assert statement.
	 */
	@Test
	public void testEquals_EachAttribute()
	{
		User u1 = new User(7, "homer", "**********");		
		User u2 = new User(7, "homer", "**********");
		
		Assert.assertEquals(u1.getId(), u2.getId());
		Assert.assertEquals(u1.getUsername(), u2.getUsername());
		Assert.assertEquals(u1.getPassword(), u2.getPassword());
	}
	
	
	/*
	 * The usage of the User.equals() method is not helpful for testing
	 * because the implementation of equals just compares the id numbers.
	 */
	@Test
	public void testEquals_ExpectedObject()
	{
		User u1 = new User(7, "homer", "**********");		
		User u2 = new User(7, "homer", "xxxxxxxxxxx");

		Assert.assertEquals(u1,u2);
	}
	

	/*
	 * Test code duplication because of the different username values we want to test.
	 */
	
	@Test
	public void testToString1()
	{
		User u = new User(7, "homer", "**********");
		
		final String EXPECTED = "7,homer,**********";
		Assert.assertEquals(EXPECTED, u.toString());
	}

	@Test
	public void testToString2()
	{
		User u = new User(7, "a", "**********");
		
		final String EXPECTED = "7,a,**********";
		Assert.assertEquals(EXPECTED, u.toString());
	}
	
	@Test
	public void testToString3()
	{
		User u = new User(7, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "**********");
		
		final String EXPECTED = "7,aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,**********";
		Assert.assertEquals(EXPECTED, u.toString());
	}
}
