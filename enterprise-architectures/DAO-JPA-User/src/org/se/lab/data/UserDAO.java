package org.se.lab.data;


public interface UserDAO
	extends DAOTemplate<User>
{
	User createUser(String firstName, String lastName, String username, String password);
}
