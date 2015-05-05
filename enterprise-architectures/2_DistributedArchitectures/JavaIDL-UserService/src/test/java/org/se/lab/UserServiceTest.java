package org.se.lab;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.ORB;
import org.se.lab.util.IOR;

public class UserServiceTest
{
	private UserService service;
	
	@Before
	public void setup() throws IOException
	{
		String[] args = {};
        // Create and initialize the ORB (based on optional command line parameters)
        ORB orb = ORB.init(args, null);
       
        // Load the IOR string and convert it to a CORBA object reference.
        String ior = IOR.load("UserService.ior");
        org.omg.CORBA.Object obj = orb.string_to_object(ior);
        
        // Instantiate a remote proxy for the given CORBA object interface.
        service = UserServiceHelper.narrow(obj);
	}

	
	@Test
	public void testLogin()
	{
		// Invoke methods on the CORBA object's interface.
		service.addUser("teini", "xxxxxxxxxx");     

		Assert.assertTrue(service.login("teini", "xxxxxxxxxx"));
		
		Assert.assertFalse(service.login("homer", "xxxxxxxxxx"));
	}
}
