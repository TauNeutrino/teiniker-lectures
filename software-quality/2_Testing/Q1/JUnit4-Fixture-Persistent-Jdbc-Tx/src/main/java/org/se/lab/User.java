package org.se.lab;



public class User
{
	/*
	 * Constructors
	 */
	
	public User(long id, String username, String password)
	{
		setId(id);
		setUsername(username);
		setPassword(password);
	}

	public User(String username, String password)
	{
		this(0, username, password);
	}
	
	
	/*
	 * Property: id:long
	 */
	private long id;
	public final long getId()
	{
		return id;
	}
	private void setId(long id)
	{
		this.id = id;
	}


	/*
	 * Property: username:String
	 */
	private String username;
	public final String getUsername()
	{
		return username;
	}
	public final void setUsername(final String username)
	{
		if(username == null)
			throw new IllegalArgumentException();
		this.username = username;
	}

	
	/*
	 * Property: password:String
	 */
	private String password;
	public final String getPassword()
	{
		return password;
	}
	public final void setPassword(final String password)
	{
		if(password == null)
			throw new IllegalArgumentException();
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
		result = prime * result + (int) (id ^ (id >>> 32));
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
