package org.se.lab;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTableTest 
	extends AbstractJdbcTest
{		
	@Before
	public void setup() throws ClassNotFoundException, SQLException  
	{
		executeSqlScript("src/test/resources/sql/createUserTable.sql");
		executeSqlScript("src/test/resources/sql/insertUserTable.sql");
	}
	
	@After
	public void teardown()
	{		        
        executeSqlScript("src/test/resources/sql/dropUserTable.sql");
	}

	
	@Test
	public void testSetupAndTearDown()
	{
	    // do nothing but execute setup() and teardown()
	}

	
	@Test
    public void testLogin() throws SQLException, 
        ClassNotFoundException
    {
        final String username = "homer";
        final String password = "*******";
        
        Service service = new Service();
        boolean result = service.login(getConnection(), username, password);
        Assert.assertTrue(result);
    }
}
