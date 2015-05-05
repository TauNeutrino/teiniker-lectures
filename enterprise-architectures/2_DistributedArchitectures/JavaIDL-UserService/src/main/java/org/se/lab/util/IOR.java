package org.se.lab.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IOR
{
    public static void store(String fileName, String ior) 
    	throws IOException
    {
        PrintWriter out = new PrintWriter(new FileWriter(fileName));
        out.println(ior);
        out.close();
    }
 
    public static String load(String fileName) 
    	throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String ior = in.readLine();
        in.close();
        return ior;
    }
}
