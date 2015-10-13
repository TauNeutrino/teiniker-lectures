package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;



/**
 * These test cases use the PersonService object as an Object Under Test.
 * 
 * Note that the UserService implementation uses the faked UserDAO
 * implementation, thus, only the UserService code is tested.
 */
public class UserServiceTest 
{   
    @Test
    public void testAddPerson()
    {
    	UserDAO stub = new UserDAOStub();
        UserService service = new UserService(stub);     	
    	
    	User user = new User(7, "Egon");
        service.addUser(user);      
        
        // Verify results and states
        assertEquals(new User(7, "Egon"), ((UserDAOStub)stub).getUser());
    }

    @Test
    public void testToCsv() 
    {
    	UserDAOStub stub = new UserDAOStub();
    	stub.setUser(new User(7,"Teiniker"));
    	UserService service = new UserService(stub);     	
        
        String csv = service.toCSV(7);
        
        // Verify results and states
        assertEquals("7,Teiniker", csv);
    }
    
}
