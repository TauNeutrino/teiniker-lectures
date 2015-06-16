package org.se.lab;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginService
{
    public boolean login(Connection c, String username, String password)
    	throws SQLException
    {
        final String SQL 
        		= "SELECT id FROM User WHERE username ='" 
                + username
                + "' AND password = '" 
                + password + "'";
        System.out.println("SQL> " + SQL);

        Statement stmt = null;
        ResultSet rs = null;
        boolean result = false;
        try
        {
            stmt = c.createStatement();
            rs = stmt.executeQuery(SQL);
            result = rs.next();
        } 
        catch (SQLException e)
        {
            return false;
        } 
        finally
        {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
        }
        return result;
    }
}
