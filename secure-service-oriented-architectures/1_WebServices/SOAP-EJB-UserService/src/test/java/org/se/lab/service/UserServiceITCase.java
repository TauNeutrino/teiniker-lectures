package org.se.lab.service;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.client.UserDTO;
import org.se.lab.client.UserResourceEJBService;
import org.se.lab.client.UserService;

public class UserServiceITCase 
{
	private static final JdbcTestHelper JDBC_HELPER = new JdbcTestHelper();
	
	private UserService service;
	
	@Before
	public void init()
	{
		JDBC_HELPER.executeSqlScript("sql/createUserTable.sql");
		JDBC_HELPER.executeSqlScript("sql/insertUserTable.sql");
	
		UserResourceEJBService ws = new UserResourceEJBService();
		service = ws.getUserServicePort();	
	}
	
	@After
	public void destroy()
	{
		JDBC_HELPER.executeSqlScript("sql/dropUserTable.sql");		
	}
	
	
	@Test
	public void testInsert()
	{
		// TODO
	}

	
	@Test
	public void testUpdate()
	{
		// TODO
	}
	
	
	@Test
	public void testDelete()
	{
		// TODO
	}
	
	
	@Test
	public void testFindById()
	{
		UserDTO u = service.findById(1);
		
		Assert.assertEquals("homer", u.getUsername());
		Assert.assertEquals("**********", u.getPassword());
	}
	
	
	@Test
	public void testFindAll() 
	{
		List<UserDTO> users = service.findAll();
		
		System.out.println(users);
		Assert.assertEquals(4, users.size());
		Assert.assertEquals("homer", users.get(0).getUsername());
		Assert.assertEquals("marge", users.get(1).getUsername());
		Assert.assertEquals("bart", users.get(2).getUsername());
		Assert.assertEquals("lisa", users.get(3).getUsername());
	}
}
