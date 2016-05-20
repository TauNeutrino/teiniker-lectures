package org.se.lab;


import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListProcessorTest
{
    private List<String> list;
    
    @Before
    public void setup()
    {
        list = Arrays.asList("Eins", "Zwei", "Drei", "Vier");
    }
    
    @Test
    public void testToUpperCaseUsingCommand()
    {
        List<String> result = ListProcessor.process(list, new ToLowerCommand());
        
        Assert.assertEquals("[eins, zwei, drei, vier]", result.toString());
    }

    
    @Test
    public void testToLowerCaseUsingAnonymousClass()
    {
        List<String> result = ListProcessor.process(list,
                new Command() {
                    public String process(String s)
                    {
                        return s.toUpperCase();
                    }
                });
        
        Assert.assertEquals("[EINS, ZWEI, DREI, VIER]", result.toString());
    }

    @Test
    public void testToUpperCaseUsingLambda()
    {
        List<String> result = ListProcessor.process(list, s -> s.toUpperCase());
        
        Assert.assertEquals("[EINS, ZWEI, DREI, VIER]", result.toString());
    }
    
}
