package org.se.lab;


/**
 * This is a dummy class that simulates UserDAO for unit tests.
 *
 */
public class UserDAOStub
	implements UserDAO
{
	/*
	 * Manage internal states
	 */

	private int id;
	protected int getId()
	{
		return id;
	}
	protected void setId(int id)
	{
		this.id = id;
	}
	
	private User user;
	protected User getUser()
	{
		return user;
	}
	protected void setUser(User user)
	{
		this.user = user;
	}
	
	
	/*
	 * UserDAO methods
	 */
	public void delete(int id)
	{
		System.out.println("UserDAOStub> delete: " + id);
		setId(id);
	}

	public User findById(int id)
	{
		System.out.println("UserDAOStub> findById: " + id);
		return getUser();
	}

	public void insert(User p)
	{
		System.out.println("UserDAOStub> insert: " + p);
		setUser(p);
	}

	public void update(User p)
	{
		System.out.println("UserDAOStub> update: " + p);
		setUser(p);
	}
}
