package org.se.lab;

import static java.lang.System.out;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


/**
 * Test classes don't have to extend junit.framework.TestCase anymore.
 * In fact, they don't have to extend anything, JUnit4 uses annotations 
 * instead.
 */
public class JUnit4Test
{
    /**
     * JUnit4 uses @BeforeClass and @AfterClass annotations to initialize 
     * and release resources per test class.
     * Note that these methods are declared as class methods (static).
     */
    @BeforeClass
    public static void perClassSetUp()
    {
        out.println("perClassSetUp()");
    }
    
    @AfterClass
    public static void perClassTearDown()
    {
        out.println("perClassTearDown()");
    }
    
    
    /**
     * JUnit4 uses @Before and @After annotations to initialize and
     * release resources per test method.
     * Therefore, we no longer need setUp() and teadDown().
     */
    @Before
    public void perMethodSetUp()
    {
        out.println("perMethodSetUp()");
    }
    
    @After
    public void perMethodTearDown()
    {
        out.println("perMethodTearDown()");
    }
    
    
    /**
     * To be executed as a test case, a JUnit4 class needs at least 
     * one @Test annotation. 
     * 
     * Because in JUnit4 a test class doesn't inherit from TestCase, we
     * have to use the prefixed syntax (e.g. org.junit.Assert.assertTrue),
     * or import statically the Assert class methods.
     */
    @Test
    public void aMethod()
    {
        out.println("aMethod()");
        assertTrue(true);
    }
    
    
    /**
     * We can add the @Ignore annotation in front or after @Test. 
     * Test runners will report the number of ignored tests, along
     * with the number of tests that ran and the number of tests
     * that failed.
     */
    @Ignore
    @Test
    public void anotherMethod()
    {
        out.println("anotherMethod()");
        assertFalse(false);
    }
}
