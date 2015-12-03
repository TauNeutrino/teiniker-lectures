package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UserTest
{
	private User user;
	
	@Before
	public void setup()
	{
		user = new User(7,"teini", "******");	
	}
	
	
	@Test
	public void testConstructor()
	{
		assertEquals(7, user.getId());
		assertEquals("teini", user.getUsername());
		assertEquals("******", user.getPassword());
	}
	
	
	@Test
	public void testToString()
	{
		String s = user.toString();
		
		assertEquals("7,teini,******", s);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testUsernameNull()
	{
		user.setUsername(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testUsernameEmpty()
	{
		user.setUsername(" ");
	}
	
		
	@Test(expected = IllegalArgumentException.class)
	public void testPasswordNull()
	{
		user.setPassword(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPasswordEmpty()
	{
		user.setPassword(" ");
	}


	@Test
	public void testHashCode()
	{
		User u1 = new User(7,"teini", "******");	
		User u2 = new User(7,"teinixx", "xxxxx");
		
		Assert.assertTrue(u1.hashCode() == u2.hashCode());
	}
	
	@Test
	public void testEquals1()
	{
		Assert.assertTrue(user.equals(user));
	}
	
	@Test
	public void testEquals2()
	{
		Assert.assertFalse(user.equals(null));
	}

	@Test
	public void testEquals3()
	{
		Assert.assertFalse(user.equals(""));
	}
	
	@Test
	public void testEquals4()
	{
		User u1 = new User(7,"teini", "******");	
		User u2 = new User(7,"teinixx", "xxxxx");

		Assert.assertTrue(u1.equals(u2));
	}

	@Test
	public void testEquals5()
	{
		User u1 = new User(7,"teini", "******");	
		User u2 = new User(1,"teinixx", "xxxxx");

		Assert.assertFalse(u1.equals(u2));
	}

	
}
