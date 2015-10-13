package org.se.lab;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.business.UserService;
import org.se.lab.business.UserServiceImpl;
import org.se.lab.data.UserDAOImpl;

public class UserDAOSpyTest 
	extends AbstractJdbcTest
{	
	private UserService service;
	private UserDAOSpy spy;
	
	@Before
	public void setup() throws ClassNotFoundException, SQLException  
	{		
		executeSqlScript("src/test/resources/sql/createUser.sql");
				
		Connection c = getConnection();
		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.setConnection(c);
		
		// Inject test spy: UserServiceImpl->UserDAOSpy->UserDAOImpl
		spy = new UserDAOSpy(userDAO);
		
		
		UserServiceImpl serviceImpl = new UserServiceImpl();
		serviceImpl.setConnection(c);	
		serviceImpl.setUserDAO(spy);
		service = serviceImpl;
		
		service.addUser("Homer", "Simpson", "homer", "*********");
		service.addUser("Bart", "Simpson", "bart", "*********");
		service.addUser("Lisa", "Simpson", "lisa", "*********");		
	}
	
	@After
	public void teardown() throws SQLException
	{		        
        executeSqlScript("src/test/resources/sql/dropUser.sql");
        closeConnection();
	}

	
	@Test
    public void testFindAllUsers() 
	{			
		service.findAllUsers();
        
		// behavioral verification
		List<String> logs = spy.getLogs();
		Assert.assertEquals(4, logs.size());
		Assert.assertTrue(logs.get(0).contains("UserDAO.insert"));
		Assert.assertTrue(logs.get(1).contains("UserDAO.insert"));
		Assert.assertTrue(logs.get(2).contains("UserDAO.insert"));
		Assert.assertTrue(logs.get(3).contains("UserDAO.findAll"));
		Assert.assertTrue(logs.get(3).contains("1,Homer,Simpson,homer,b8020e8e15c5362a7ac49800e3e86e99"));
		Assert.assertTrue(logs.get(3).contains("2,Bart,Simpson,bart,b8020e8e15c5362a7ac49800e3e86e99"));
		Assert.assertTrue(logs.get(3).contains("3,Lisa,Simpson,lisa,b8020e8e15c5362a7ac49800e3e86e99"));
		System.out.println(spy.getLogs());

	}

	
	
	@Test
	public void removeUser()
	{
		service.removeUser("2");

		// behavioral verification
		List<String> logs = spy.getLogs();
		Assert.assertEquals(4, logs.size());
		Assert.assertTrue(logs.get(0).contains("UserDAO.insert"));
		Assert.assertTrue(logs.get(1).contains("UserDAO.insert"));
		Assert.assertTrue(logs.get(2).contains("UserDAO.insert"));
		Assert.assertTrue(logs.get(3).contains("UserDAO.delete"));
		Assert.assertTrue(logs.get(3).contains("id=2"));
	}
}
