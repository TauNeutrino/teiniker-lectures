package org.se.lab;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;


/**
 * Test classes don't have to extend junit.framework.TestCase anymore.
 * In fact, they don't have to extend anything, JUnit4 uses annotations 
 * instead.
 */
public class ExceptionTest
{
     /**
     * The @Test annotation supports the optional expected parameter
     * which declares that a test method should throw an exception.
     * If the method doesn't throw the expected exception, the test fails.
     */
    @Test(expected = Exception.class)
    public void aMethodWithException() throws Exception
    {
        out.println("aMethodWithException()");
        throw new Exception();
    }    
    
    @Test
    public void test2()
    {
    	try
    	{
    		setName(null);
    		fail();
    	}
    	catch(NullPointerException e)
    	{
    		String msg = e.getMessage();
    		assertEquals("name is null!", msg);
    	}
    }
    
    
    protected void setName(String name)
    {
    	if(name == null)
    		throw new NullPointerException("name is null!");
    	
    	// do something
    }
}
