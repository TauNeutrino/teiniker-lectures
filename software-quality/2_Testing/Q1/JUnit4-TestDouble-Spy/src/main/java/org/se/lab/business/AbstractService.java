package org.se.lab.business;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractService
{
	
	/*
	 * Dependency: ---[1]-> connection:Connection
	 */
	protected Connection connection;
	protected Connection getConnection()
	{
		return connection;
	}
	public void setConnection(Connection connection)
	{
		if(connection == null)
			throw new NullPointerException("connection");
		this.connection = connection;
	}
	
	
	
	/*
	 * Transaction methods
	 */
	
	protected void begin() 
	{
		try
        {
            connection.setAutoCommit(false);
        } 
		catch (SQLException e)
        {
		    throw new ServiceException("transaction begin failure", e);
        } 
	}

	protected void commit() 
	{
		try
        {
            connection.commit();
            connection.setAutoCommit(true);
        } 
		catch (SQLException e)
        {
		    throw new ServiceException("transaction commit failure", e);
        }
	}

	protected void rollback() 
	{
		try
        {
            connection.rollback();
        } 
		catch (SQLException e)
        {
            throw new ServiceException("transaction rollback failure", e);
        }
	}
}