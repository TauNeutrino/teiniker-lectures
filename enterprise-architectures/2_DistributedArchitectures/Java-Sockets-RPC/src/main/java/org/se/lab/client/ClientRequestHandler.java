package org.se.lab.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.se.lab.commons.Logger;
import org.se.lab.commons.RPCCommunicationException;

public class ClientRequestHandler
{
	/*
	 * Constructor
	 */
	public ClientRequestHandler(String host, int port)
	{
		if(host == null)
			throw new IllegalArgumentException();

		if(port <= 1024)
			throw new IllegalArgumentException();

		this.host = host;
		this.port = port;
	}
	
	
	/*
	 * Property: port:int
	 */
	private final int port;

	
	/*
	 * Property: host:String
	 */
	private final String host;
	
	
	public String sendMessage(String message)
	{
		try
		{
			Socket socket = new Socket(host, port);
			Logger.log("connect to " + socket);
			
			// send request
			Logger.log("send: '" + message + "'");
			PrintWriter out = new PrintWriter(socket.getOutputStream());		
			out.println(message);
			out.flush();

			// read response
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response = in.readLine();
			Logger.log("receive: '" + response + "'");
			
			in.close();
			out.close();
			socket.close();

			return response;
		}
		catch(UnknownHostException e)
		{
			throw new RPCCommunicationException("Can't send message " + message, e);
		}
		catch(IOException e)
		{
			throw new RPCCommunicationException("Can't send message " + message, e);
		}
	}
}
