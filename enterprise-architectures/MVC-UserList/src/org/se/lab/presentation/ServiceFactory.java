package org.se.lab.presentation;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.se.lab.business.UserService;
import org.se.lab.business.UserServiceImpl;
import org.se.lab.data.UserDAOImpl;


public class ServiceFactory
{
    private final Logger logger = Logger.getLogger(ServiceFactory.class);
        
    public UserService createUserService()
    {
        logger.debug("createUserService()");
        
        Connection c = createConnection();                
        UserDAOImpl userDAO = new UserDAOImpl(c);


        UserServiceImpl service = new UserServiceImpl(c);
        service.setUserDAO(userDAO);

        logger.debug("    service: " + service);    
        return service;    
    }
    
        
    /*
     * Utility methods
     */
    
    protected Connection createConnection()
    {
        logger.debug("getConnection()");
        try
        {
            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            DataSource ds = (DataSource) ctx.lookup("jdbc/mysqlDB");
            
            logger.debug("used DataSource object is: " + ds);
        
            return ds.getConnection();
        } 
        catch (NamingException e)
        {
            logger.debug("problem during JNDI lookup", e);
            throw new IllegalStateException(e);
        }
        catch (SQLException e)
        {
            logger.debug("problem during DAO setup", e);
            throw new IllegalStateException(e);
        }
    }
}
