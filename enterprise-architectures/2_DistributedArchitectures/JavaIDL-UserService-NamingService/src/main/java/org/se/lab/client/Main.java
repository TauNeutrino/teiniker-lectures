package org.se.lab.client;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.se.lab.UserService;
import org.se.lab.UserServiceHelper;

/*
 * This Main class shows the usage of the OMG Naming Service to obtain a
 * reference to the HelloWorld CORBA object.
 */
public class Main
{	
    public static void main(String[] args)
    {
        try 
        {
            // Create and initialize the ORB (based on command line parameters)            
            ORB orb = ORB.init(args, null);

            // Retrieve the OMG Naming Service from the ORB            
            org.omg.CORBA.Object nsobj = orb.resolve_initial_references("NameService");
            NamingContextExt ns = NamingContextExtHelper.narrow(nsobj);
            
            // Use the Naming Service to obtain a reference to the HelloWorld CORBA object.
            org.omg.CORBA.Object obj = ns.resolve(ns.to_name("org/se/lab/UserService"));
            UserService service = UserServiceHelper.narrow(obj);
            
            // Invoke methods on the CORBA object's interface as usual.
            service.addUser("teini", "xxxxxxxxxx");     
    		System.out.println("client> " + service.login("teini", "xxxxxxxxxx"));
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }    
}
