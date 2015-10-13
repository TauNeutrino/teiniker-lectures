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
import org.se.lab.data.User;
import org.se.lab.data.UserDAOImpl;

public class UserServiceTest 
	extends AbstractJdbcTest
{	
	private UserService service;
	
	@Before
	public void setup() throws ClassNotFoundException, SQLException  
	{		
		executeSqlScript("src/test/resources/sql/createUser.sql");
				
		Connection c = getConnection();
		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.setConnection(c);
		
		UserServiceImpl serviceImpl = new UserServiceImpl();
		serviceImpl.setConnection(c);	
		serviceImpl.setUserDAO(userDAO);
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
		List<User> users = service.findAllUsers();
        
		Assert.assertEquals(3, users.size());
		Assert.assertEquals("[" +
				"1,Homer,Simpson,homer,b8020e8e15c5362a7ac49800e3e86e99, " +
				"2,Bart,Simpson,bart,b8020e8e15c5362a7ac49800e3e86e99, " +
				"3,Lisa,Simpson,lisa,b8020e8e15c5362a7ac49800e3e86e99" +
				"]", users.toString());        
    }

	
	@Test
	public void removeUser()
	{
		service.removeUser("2");

		List<User> users = service.findAllUsers();
		Assert.assertEquals(2, users.size());
		Assert.assertEquals("[" +
				"1,Homer,Simpson,homer,b8020e8e15c5362a7ac49800e3e86e99, " +
				"3,Lisa,Simpson,lisa,b8020e8e15c5362a7ac49800e3e86e99" +
				"]", users.toString());        

	}
}
