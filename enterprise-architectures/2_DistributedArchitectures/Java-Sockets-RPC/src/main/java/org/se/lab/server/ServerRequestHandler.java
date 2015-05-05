package org.se.lab.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.se.lab.commons.Logger;


public class ServerRequestHandler
{
	/*
	 * Constructor
	 */
	public ServerRequestHandler(int port, Invoker invoker)
	{
		if(port <= 1024)
			throw new IllegalArgumentException();

		if(invoker == null)
			throw new IllegalArgumentException();

		this.port = port;
		this.invoker = invoker;
	}
	
	
	/*
	 * Property: port:int
	 */
	private final int port;

	
	/*
	 * Association: invoker:Invoker
	 */
	private final Invoker invoker;

	
	/*
	 * Note that this ServerRequestHandler uses a very simple single threaded 
	 * implementation to handle all the incoming requests.
	 */
	public void run()
	{
		ServerSocket server = null;
		try
		{
			server = new ServerSocket(port);
			Logger.log("RPC Server is running...");
			while (true)
			{
				Socket connection = server.accept(); // wait for a connection
				Logger.log("connection: " + connection.toString());
				try
				{					
					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					PrintWriter out = new PrintWriter(connection.getOutputStream());

					String request = in.readLine();				
					String response = invoker.invoke(request);
					out.print(response);
					out.flush();
					
					connection.close();
				} 
				catch(Exception e)
				{
					e.printStackTrace();
				} 
				finally
				{
					if (connection != null)
						connection.close();
				}
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(server != null)
				server.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
