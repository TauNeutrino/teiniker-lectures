package org.se.lab.server;

import java.util.Date;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.Servant;
import org.se.lab.util.IOR;

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

            // Convert the CORBA object reference into a string and store this IOR
            // string in a file.
            String ior = orb.object_to_string(obj);
            IOR.store("UserService.ior", ior);
            
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
