package org.se.lab.business;

import java.util.List;

import org.se.lab.data.User;

public interface UserService
{
    void addUser(final String firstName, final String lastName, final String username, final String password);
    void removeUser(final String idString);

    List<User> findAllUsers(); 
}