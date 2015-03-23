package org.se.lab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/login.html")
public class ResponseFilter implements Filter
{
	/*
	 * Lifecycle methods
	 */
	
	public ResponseFilter()
	{
		System.out.println("ResponseFilter()");
	}

	public void init(FilterConfig fConfig) throws ServletException
	{
		System.out.println("ResponseFilter.init()");
	}

	public void destroy()
	{
		System.out.println("ResponseFilter.destroy()");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		if(response instanceof HttpServletResponse)
		{
			ResponseWrapper wrapper = new ResponseWrapper((HttpServletResponse)response);
			chain.doFilter(request, wrapper);
			
			String content = wrapper.toString();
			
			System.out.println("---------------------------------------------------");
			System.out.println("Response Filter");
	        System.out.println("---------------------------------------------------");
			System.out.println(content);
			
	        PrintWriter out = response.getWriter();
	        out.println(content);
	        out.close();
		}
		else
		{	
			chain.doFilter(request, response);
		}
	}
}
