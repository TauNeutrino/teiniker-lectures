package org.se.lab.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class UserDAOImpl 
	extends AbstractDAOImpl
	implements UserDAO
{
	private final Logger logger = Logger.getLogger(UserDAOImpl.class);

	/*
	 * DAO operations
	 */

	public void insert(final User user)
	{
		if (user == null)
			throw new IllegalArgumentException();

		final String SQL = "INSERT INTO user VALUES (NULL,?,?,?,?)";
		logger.debug("SQL> " + SQL);
		PreparedStatement pstmt = null;

		try
		{
			pstmt = getConnection().prepareStatement(SQL);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			throw new DAOException("insert failure", e);
		} 
		finally
		{
			closePreparedStatement(pstmt);
		}
	}

	public void update(final User user)
	{
		if (user == null)
			throw new IllegalArgumentException();

		final String SQL = "UPDATE user SET firstname=?, lastname=?, "
				+ "username=?, password=? WHERE id=?";
		logger.debug("SQL> " + SQL);
		PreparedStatement pstmt = null;

		try
		{
			pstmt = getConnection().prepareStatement(SQL);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			pstmt.setLong(5, user.getId());
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			throw new DAOException("update failure", e);
		} 
		finally
		{
			closePreparedStatement(pstmt);
		}
	}

	
	public void delete(final long id) 
	{
		final String SQL = "DELETE FROM user WHERE ID = ?";
		logger.debug("SQL> " + SQL);
		PreparedStatement pstmt = null;
		try
		{
			pstmt = getConnection().prepareStatement(SQL);
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			throw new DAOException("update failure", e);
		} 
		finally
		{
			closePreparedStatement(pstmt);
		}
	}

	public User findById(final long id) 
	{
		final String SQL = "SELECT * FROM user WHERE id=? ";
		logger.debug("SQL> " + SQL);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try
		{
			pstmt = getConnection().prepareStatement(SQL);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			user = new User(rs.getLong("id"), rs.getString("firstName"),
					rs.getString("lastName"), rs.getString("username"),
					rs.getString("password"));
		} 
		catch (SQLException e)
		{
			throw new DAOException("update failure", e);
		} 
		finally
		{
			closeResultSet(rs);
			closePreparedStatement(pstmt);
		}
		return user;
	}

	
	public List<User> findAll()
	{
		final String SQL = "SELECT * FROM user";
		logger.debug("SQL> " + SQL);
		Statement stmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();

		try
		{
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery(SQL);

			while (rs.next())
			{
				long id = rs.getLong("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String username = rs.getString("username");
				String password = rs.getString("password");
				User user = new User(id, firstName, lastName, username,password);
				users.add(user);
			}
		} 
		catch (SQLException e)
		{
			throw new DAOException("update failure", e);
		} 
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return users;
	}
}
