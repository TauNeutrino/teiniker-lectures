package org.se.lab;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.server.domain.UserService;
import org.se.lab.server.domain.UserServiceImpl;

public class UserServiceTest
{
	private UserService service;
	
	@Before
	public void setup() throws IOException
	{
		service = new UserServiceImpl();
		service.addUser("teini", "xxxxxxxxxx");     
	}

	@Test
	public void testLoginSuccess()
	{
		boolean result = service.login("teini", "xxxxxxxxxx");
		Assert.assertTrue(result);
	}	

	@Test
	public void testLoginFailure()
	{
		boolean result = service.login("homer", "xxxxxxxxxx");
		Assert.assertFalse(result);		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testLoginFailure_InvalidUsername()
	{
		service.login("tei", "xxxxxxxxxx");
	}
}
