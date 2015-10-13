package org.se.lab;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public abstract class AbstractJdbcTest
{
	public static final String SQL_STATEMENT_DELIMITER = ";";
	
	private String driver;
    private String url;
    private String user;
    private String password;  
	
    private Connection con;
    
    /*
     * Constructors
     */
    
    public AbstractJdbcTest()
    {
    	this("jdbc.properties");
    }
    
    public AbstractJdbcTest(String propertyFileName) 
    {
    	if(propertyFileName == null || propertyFileName.length() == 0)
    		throw new IllegalArgumentException("Invalid property file name!");
    	    	
        try
		{
        	Properties jdbcProperties = new Properties();
			jdbcProperties.load(new FileInputStream(propertyFileName));
			driver = jdbcProperties.getProperty("jdbc.driver");
			url = jdbcProperties.getProperty("jdbc.url");
			user = jdbcProperties.getProperty("jdbc.username");
			password = jdbcProperties.getProperty("jdbc.password");
			
	        Class.forName(driver);
	        con = DriverManager.getConnection(url, user, password);
		}
		catch(Exception e)
		{
			throw new IllegalStateException("Unable to load " + propertyFileName + "!");
		}
    }

    protected Connection getConnection()     	
    {
        return con;
    }
    
    protected void closeConnection() 
    	throws SQLException
    {
    	if(con != null)
    		con.close();
    }


    /*
     * Public Methods
     */
    
    
    /**
     * Read a SQL script and execute each SQL statement.
     * 
     * @param sqlScriptFileName
     */
    public void executeSqlScript(String sqlScriptFileName)
	{
    	if(sqlScriptFileName == null || sqlScriptFileName.length() == 0)
    		throw new IllegalArgumentException("Invalid SQL script file name!");

		try
		{			
			String sqlScript = loadSqlScript(sqlScriptFileName);
			String[] sqlStatements = sqlScript.split(SQL_STATEMENT_DELIMITER);		
			executeSqlStatements(sqlStatements);
		}
		catch(Exception e)
		{
			throw new RuntimeException("Can't execute SQL script: " + e.getMessage());
		}
	}

	    
    /**
     * Executes a single SQL statement given by a string parameter.
     * 
     * @param sqlStatement
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void executeSqlStatement(String sqlStatement) 
    	throws SQLException
    {
    	if(sqlStatement == null || sqlStatement.length() == 0)
    		throw new IllegalArgumentException("Empty sqlStatement!");
    	
    	Statement st = null;
    	try
    	{
    		st = con.createStatement();            
    		st.execute(sqlStatement);            
    	}
    	finally
    	{
    		if(st != null) 
    			st.close();
    	}
    }
    
    
    /**
     * Executes a sequence of SQL statements given by a string array parameter.
     * 
     * @param sqlStatements
     * @throws SQLException
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void executeSqlStatements(String[] sqlStatements) 
    	throws SQLException 
    {
    	if(sqlStatements == null)
    		throw new IllegalArgumentException("Empty sqlStatement array!");
    	
    	Statement st = null;
    	try
    	{
    		st = con.createStatement();            
    		for(String sqlStatement : sqlStatements)
    		{
    			System.out.println("SQL> " + sqlStatement);
    			st.execute(sqlStatement);
    		}
    	}
    	finally
    	{
    		if(st != null) 
    			st.close();
    	}
    }

    
    
    /*
     * Utility Methods
     */
    
    
    /**
     * Load an SQL script and eliminate comment lines.
     * 
     * @param sqlScriptFileName
     * @return
     * @throws IOException
     */
    protected String loadSqlScript(String sqlScriptFileName) 
    		throws IOException
    {
    	if(sqlScriptFileName == null || sqlScriptFileName.length() == 0)
    		throw new IllegalArgumentException("Invalid SQL script file name!");
    	
    	BufferedReader in = new BufferedReader(new FileReader(sqlScriptFileName));
    	StringBuilder buffer = new StringBuilder();
    	String line;
    	while((line = in.readLine()) != null)
    	{
    		if(isCommentLine(line))
    			continue;
    		buffer.append(line.trim());
    	}
    	in.close();
    	return buffer.toString();    
    }
    
    
    /**
     * Check if a given line is a SQL comment.
     * 
     * @param line
     * @return
     */
    protected boolean isCommentLine(String line)
    {
    	if(line == null || line.length() == 0)
    		return false;
    	
    	String comment = line.trim(); 
    	if(comment.startsWith("--") || comment.startsWith("//"))
    		return true;
    	else
    		return false;    	
    }

}
