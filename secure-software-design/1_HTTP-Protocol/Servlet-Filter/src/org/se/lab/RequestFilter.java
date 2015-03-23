package org.se.lab;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/login.html")
public class RequestFilter implements Filter 
{
	public RequestFilter()
	{
		System.out.println("RequestFilter()");
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
		System.out.println("RequestFilter.init()");
	}

	public void destroy()
	{
		System.out.println("RequestFilter.destroy()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
		throws IOException, ServletException 
	{
		// place your code here
		System.out.println("---------------------------------------------------");
		System.out.println("Request Filter");
        System.out.println("---------------------------------------------------");

        System.out.println("Server:");
        System.out.println("    server name = " + request.getServerName());
        System.out.println("    server port = " + request.getServerPort());
        System.out.println("---------------------------------------------------");

        System.out.println("Client:");
        System.out.println("    remote address = " + request.getRemoteAddr());
        System.out.println("    remote host    = " + request.getRemoteHost());
        System.out.println("    remote port    = " + request.getRemotePort());
        System.out.println("    protocol       = " + request.getProtocol());
        System.out.println("    https          = " + request.isSecure());
        
        System.out.println("---------------------------------------------------");
        
        
        System.out.println("Parameters:");
        Enumeration<String> parameterNames = request.getParameterNames();	
        while(parameterNames.hasMoreElements())
        {
        	String name = parameterNames.nextElement();
        	String value = request.getParameter(name);
        	System.out.println("    " + name + "  = " + value);
        }
     
        System.out.println("---------------------------------------------------\n");
        
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
}
