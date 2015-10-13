package org.se.lab.business;

import java.util.List;

import org.apache.log4j.Logger;
import org.se.lab.data.DAOException;
import org.se.lab.data.User;
import org.se.lab.data.UserDAO;


public class UserServiceImpl 
	extends AbstractService 
	implements UserService
{
	private final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	
	/*
	 * Dependency: ---[1]-> UserDAO 
	 */
	private UserDAO userDAO;
	protected final UserDAO getUserDAO()
	{
		return userDAO;
	}
	public final void setUserDAO(final UserDAO userDAO)
	{
		if(userDAO == null)
			throw new IllegalArgumentException();
		this.userDAO = userDAO;
	}

	
	/*
	 * Business methods
	 */
	
    public void addUser(final String firstName, final String lastName, 
			final String username, final String password) 
	{
		logger.debug("addUser()");
		String md5Password;
		try
		{
			md5Password = MD5Encoder.convertToMD5String(password);
			User newUser = new User(firstName,lastName, username, md5Password);
			logger.debug("new user: " + newUser);
			
			begin();
			getUserDAO().insert(newUser);				
			commit();			
		}
		catch(DAOException e)
		{
			rollback();
		}
	}
	

    public void removeUser(final String idString) 
	{
		logger.debug("removeUser()");
		
		if(idString == null)
			throw new IllegalArgumentException();

		try
		{
			long id = Long.valueOf(idString);
			
			begin();
			getUserDAO().delete(id);
			commit();
		}
        catch(DAOException e)
        {
            rollback();
        }
	}
	
	
    public List<User> findAllUsers()
	{
		logger.debug("findAllUsers()");
		
		List<User> users = null;
		try
		{
			begin();
			users = getUserDAO().findAll();
			commit();
		}
        catch(DAOException e)
        {
            rollback();
        }
		return users;
	}
}
