package org.se.lab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Service
{
    public boolean login(Connection c, String username, String password) 
        throws SQLException
    {
        final String SQL = "SELECT id FROM User WHERE username=? AND password=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean result;
        try
        {
            pstmt = c.prepareStatement(SQL);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            result = rs.next();
        } 
        finally
        {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
        }
        return result;
    }
    
    
	public void insert(Connection c, User user) throws SQLException
	{
		if (user == null)
			throw new IllegalArgumentException();

		final String SQL = "INSERT INTO User VALUES (NULL,?,?)";
		
		PreparedStatement pstmt = null;

		try
		{
			pstmt = c.prepareStatement(SQL);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.executeUpdate();
		} 
		finally
        {
            if (pstmt != null)
                pstmt.close();
        }
	}

    
	public List<User> findAll(Connection c) 
		throws SQLException
	{
		final String SQL = "SELECT * FROM User";
		
		Statement stmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		try
		{
			stmt = c.createStatement();
			rs = stmt.executeQuery(SQL);

			while (rs.next())
			{
				long id = rs.getLong("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				User user = new User(id, username, password);
				users.add(user);
			}
		} 
		finally
		{
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
		}
		return users;
	}
}
