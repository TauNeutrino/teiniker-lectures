package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

import com.google.json.JsonSanitizer;

public class SanitizerTest
{

    @Test
    public void testSanitizer()
    {
        String input = "{username:\"bart\"}";
        String actual = JsonSanitizer.sanitize(input);
        
        // Unquoted property names are quoted.
        Assert.assertEquals("{\"username\":\"bart\"}", actual);
    }
}
