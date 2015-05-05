package org.se.lab.server;

import java.util.Date;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.Servant;

public class Main
{
    public static void main(String[] args)
    {
        try 
        {
            // Create and initialize the ORB (based on optional command line parameters)
            ORB orb = ORB.init(args, null);

            // Get reference to the RootPOA and activate the POAManager
            POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            poa.the_POAManager().activate();
            
            // Create a servant instance and get the CORBA object reference 
            // from the servant.         
            Servant servant = new UserServiceRemoteFacade();
            org.omg.CORBA.Object obj = poa.servant_to_reference(servant);

            // Retrieve the OMG Naming Service from the ORB                    
            org.omg.CORBA.Object nsobj = orb.resolve_initial_references("NameService");
            NamingContextExt ns = NamingContextExtHelper.narrow(nsobj);
            
            // Establish the following tree structure in the CORBA naming service:
            //  org 
            //    +-- se
            //        +-- lab 
            //			  +-- UserService
            
            // Create the "org" node (= context)
            NamingContext org = ns.new_context();
            ns.rebind_context(ns.to_name("org"), org);
            
            // Create the "se" node (= context)
            NamingContext se = ns.new_context();
            org.rebind_context(ns.to_name("se"), se);
            
            // Create the "lab" node (= context)
            NamingContext lab = ns.new_context();
            se.rebind_context(ns.to_name("lab"), lab);
            
            // Create the "UserService" name (= mapping from name to object reference)
            lab.rebind(ns.to_name("UserService"), obj);
            
            
            // Wait for invocations from clients
            Main.log("Server is running...");
            orb.run();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    
	public static void log(String msg)
	{		
		System.out.println("[" + timeStamp() + "] " + msg);
	}

	private static String timeStamp()
	{
		Date now = new Date();
		return now.toString();
	}
}
