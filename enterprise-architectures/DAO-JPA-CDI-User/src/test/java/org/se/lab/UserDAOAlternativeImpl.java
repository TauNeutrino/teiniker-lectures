package org.se.lab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import org.apache.log4j.Logger;


@Alternative
public class UserDAOAlternativeImpl 
	implements UserDAO
{
	private final Logger LOG = Logger.getLogger(UserDAOAlternativeImpl.class);
	
    /*
     * Simulate the database table in a HashMap
     */
    private static Map<Integer,User> table = new HashMap<>();
    
    
    /*
     * DOA operations
     */
    
    public void insert(User p)
    {
    	LOG.debug("insert(" + p + ")");
        table.put(p.getId(), p);
    }

    public void update(User p)
    {
        table.put(p.getId(), p);
    }

    public void delete(long id)
    {
        table.remove(id);
    }

    public User findById(long id)
    {
    	LOG.debug("findById(" + id + ")");
        return table.get(id);        
    }
    
    public List<User> findAll()
    {
        return new ArrayList<User>(table.values());
    }
}
