package org.se.lab.server;


public class UserServiceRemoteFacade 
	extends org.se.lab.UserServicePOA // generated from the IDL compiler
{
	private UserService service;

	public UserServiceRemoteFacade()
	{
		service = new UserServiceImpl();
	}
	
	public void addUser(String username, String password)
	{
		Main.log("addUser(" + username + "," + password + ")");
		service.addUser(username, password);
	}

	public boolean login(String username, String password)
	{
		Main.log("login(" + username + "," + password + ")");
		boolean result = service.login(username, password);
		return result;
	}
}
