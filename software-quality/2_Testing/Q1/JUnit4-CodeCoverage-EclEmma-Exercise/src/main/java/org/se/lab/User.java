package org.se.lab;

public class User
{
	/*
	 * Constructor
	 */
	public User(int id, String username, String password)
	{
		setId(id);
		setUsername(username);
		setPassword(password);
	}
	
	
	/*
	 * Property: id
	 */
	private int id;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	} 
	
	
	/*
	 * Property: username
	 */
	private String username;
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		if(username == null 
				|| username.trim().length() == 0)
			throw new IllegalArgumentException("username: " + username);
		this.username = username;
	}
	
	
	/*
	 * Property: password
	 */
	private String password;
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		if(password == null || password.trim().length() == 0)
			throw new IllegalArgumentException("password: " + password);
		this.password = password;
	}
	

	/*
	 * Object methods
	 */

	@Override
	public String toString()
	{
		return getId() + "," + getUsername() + "," + getPassword();
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
