package org.se.lab;

import static java.lang.System.out;

import org.junit.Test;


/**
 * Test classes don't have to extend junit.framework.TestCase anymore.
 * In fact, they don't have to extend anything, JUnit4 uses annotations 
 * instead.
 */
public class TimeoutTest
{
    /**
     * The optional timeout parameter causes a test to fail if it takes
     * longer than a specified amount of clock time (in milliseconds).
     */
    @Test(timeout = 1000)
    public void aMethodWithTimeout()
    {
        out.println("aMethodWithTimeout()");
        while(true);
    }
}
