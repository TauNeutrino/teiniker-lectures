package org.se.lab;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegerCounterTest
{    
	private final Logger LOG = Logger.getLogger(IntegerCounterTest.class);
	
	private IntegerCounter counter;
	
	@Before
    public void setUp() throws NamingException  
    {
    	final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        
        final String jndiName = "ejb:" + "" 
        		+ "/" + "EJB-IntegerCounter" 
        		+ "/" + ""
        		+ "/" + "IntegerCounterEJB" 
        		+ "!" + IntegerCounter.class.getName()
        		+ "?stateful";
   
        LOG.info("JNDI Name = " + jndiName);
        counter =  (IntegerCounter) context.lookup(jndiName);
    }
    
    
    @Test
    public void testRemoteCounter()
    {
    	counter.increment();
    	counter.increment();
    	counter.increment();

     	Assert.assertEquals(3, counter.getValue());
     		
     	counter.decrement();
     	counter.decrement();
     	
     	Assert.assertEquals(1, counter.getValue());
     	
     	counter.removeCounter();
    }
}
