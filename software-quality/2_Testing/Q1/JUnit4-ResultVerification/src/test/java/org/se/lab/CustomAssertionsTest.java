package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class CustomAssertionsTest
{

	/*
	 * Here we compare two users by using a custom assertion method.
	 */
	@Test
	public void testEquals_EachAttribute()
	{
		User u1 = new User(7, "homer", "**********");		
		User u2 = new User(7, "homer", "**********");
		
		assertEquals(u1, u2);
	}
	
	
	/*
	 * Custom assertion method
	 */
	protected void assertEquals(User u1, User u2)
	{
		Assert.assertEquals(u1.getId(), u2.getId());
		Assert.assertEquals(u1.getUsername(), u2.getUsername());
		Assert.assertEquals(u1.getPassword(), u2.getPassword());		
	}
}
