package org.se.lab.data;

import java.util.List;

public interface UserDAO
{
    void insert(final User user);
    void update(final User user);    
    void delete(final long id);
   
    User findById(final long id);
    List<User> findAll();
}