package org.se.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvokerTest
{
	private String host;
	private int port;
	
	@Before
	public void setup() throws IOException
	{
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/org/se/lab/commons/socket.properties"));
		host = properties.getProperty("host");
		port = Integer.parseInt(properties.getProperty("port"));
	}
	
	@Test
	public void testLogin() throws UnknownHostException, IOException
	{
		{
			Socket socket = new Socket(host, port);
			// send request
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println("request,UserService:1.0,addUser,teini,xxxxxxxxxx");
			out.flush();

			// read response
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response = in.readLine();

			in.close();
			out.close();
			socket.close();

			Assert.assertEquals("response,ok,void",response);
		}
		
		{
			Socket socket = new Socket(host, port);
			// send request
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println("request,UserService:1.0,login,teini,xxxxxxxxxx");
			out.flush();

			// read response
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response = in.readLine();

			in.close();
			out.close();
			socket.close();

			Assert.assertEquals("response,ok,true", response);
		}

		{
			Socket socket = new Socket(host, port);
			// send request
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println("request,UserService:1.0,login,homer,xxxxxxxxxx");
			out.flush();

			// read response
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response = in.readLine();

			in.close();
			out.close();
			socket.close();

			Assert.assertEquals("response,ok,false", response);
		}	
	}
}
