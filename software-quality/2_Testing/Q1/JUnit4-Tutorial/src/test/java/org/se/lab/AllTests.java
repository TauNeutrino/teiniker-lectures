package org.se.lab;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * To run several test classes into a suite we write an empty class with
 * @RunWith and @Suite annotations.
 * 
 * The @RunWith annotation is telling JUnit to use the org.junit.runner.Suite
 * runner which allows us to manually build a suite containing tests from many
 * classes.
 * The names of these classes are defined in the @Suite.SuiteClasses annotation.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    JUnit4Test.class, 
    TestSuite.class
})
public class AllTests
{
    @BeforeClass
    public static void setUpSuite()
    {
        System.out.println("AllTests.setUpSuite()");
        // TODO
    }
    

    @AfterClass
    public static void tearDownSuite()
    {
        System.out.println("AllTests.tearDownSuite()");
        // TODO
    }
}
