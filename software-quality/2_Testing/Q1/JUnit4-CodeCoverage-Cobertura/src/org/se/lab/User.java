package org.se.lab;

public class User
{
    
    /*
     * Constructor
     */
    public User(int id, String name, String password)
    {
        setId(id);
        setName(name);
        setPassword(password);
    }
    
    
    /*
     * Property: id
     */
    private int id;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }


    /*
     * Property: name
     */
    private String name;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        if(name == null || name.length() == 0)
            throw new IllegalArgumentException("Invalid parameter name!");
        this.name = name;
    }


    /*
     * Property: password
     */
    private String password;
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        if(password == null || password.length() == 0)
            throw new IllegalArgumentException("Invalid parameter password!");
        this.password = password;
    }
    
    
    /*
     * Housekeeping Methods
     */
    
    public String toString()
    {
        return id + "," + name + "," + password;
    }
}
