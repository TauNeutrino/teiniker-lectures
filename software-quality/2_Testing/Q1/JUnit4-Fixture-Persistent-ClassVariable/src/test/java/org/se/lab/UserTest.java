package org.se.lab;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/*
 * Persistent Test Fixture: class variable
 * 
 * Here we test a User class that asks a static variable to set its
 * value for the id property.
 */
public class UserTest
{
	// Note that the order of test executions is not defined, thus,
	// the value of id can be different in each test run :-(
	
	// By setting the sequence number in the @Before or @After method
	// to a known value, we can guarantee the value of id.

	@Before
	public void setup()
	{
//		LongSequence.setSequenceNumber(1);
	}
	
	@After
	public void teardown()
	{
		LongSequence.resetSequenceNumber();
	}
	
	
	@Test
	public void testConstructor()
	{
		User user = new User("homer", "**********");
		
		Assert.assertEquals(1, user.getId());
		Assert.assertEquals("homer", user.getUsername());
		Assert.assertEquals("**********", user.getPassword());
	}
	

	@Test
	public void testToString()
	{
		User user = new User("homer", "**********");
		
		Assert.assertEquals("User [id=1, username=homer, password=**********]", user.toString());
	}
}
