package org.se.lab;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EncodingDecoratorTest
{
	protected LoginService service;
	protected LoginServiceImpl impl;
	
	@Before
	public void setup()
	{
		impl = new LoginServiceImpl();
		
		service = new EncodingDecorator(new LoggingDecorator(impl));
		
		service.addUser(1, "lisa", "superlisa", "lisa.simpson@springfield.com");
		service.addUser(2, "bart", "karramba", "bart.simpson@springfield.com");
	}

	
	@Test
	public void testLoginSuccess()
	{
		Assert.assertTrue(service.login("lisa", "superlisa"));
	}
	
	@Test
	public void testAddUserEncoding()
	{
		List<User> users = impl.getUsers();
		
		Assert.assertEquals("4126ef98d9f1ae9ab149796ebadac81f", users.get(0).getPassword());
		Assert.assertEquals("c90f22f15432c55525d815a068b0f4b7", users.get(1).getPassword());
	}
}
