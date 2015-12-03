package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.se.lab.User;


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
}
