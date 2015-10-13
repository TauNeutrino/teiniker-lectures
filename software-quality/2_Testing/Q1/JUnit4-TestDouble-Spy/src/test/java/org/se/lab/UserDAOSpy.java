package org.se.lab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.se.lab.data.User;
import org.se.lab.data.UserDAO;

public class UserDAOSpy 
	implements UserDAO
{
	/*
	 * Constrictor injection
	 */
	private UserDAO dao;
	public UserDAOSpy(UserDAO dao)
	{
		if(dao == null)
			throw new NullPointerException();
		this.dao = dao;
	}
	
	
	/*
	 * Property: logs:String[*]
	 */
	private List<String> logs = new ArrayList<String>();
	public List<String> getLogs()
	{
		return logs;
	}
	public void addLog(String s)
	{
		Date now = new Date();
		logs.add(now.getTime() + ": " + s + "\n");
	}
	

	/*
	 * UserDAO Proxy 
	 */
	
	@Override
	public void insert(User user)
	{	
		addLog("UserDAO.insert: user=" + user);
		dao.insert(user);
	}
	
	@Override
	public void update(User user)
	{
		addLog("UserDAO.update: user=" + user);
		dao.update(user);
	}

	@Override
	public void delete(long id)
	{
		addLog("UserDAO.delete: id=" + id);
		dao.delete(id);
	}

	@Override
	public User findById(long id)
	{
		String s = "UserDAO.findById: id=" + id;
		User user = dao.findById(id);
		
		s += " result=" + user;
		addLog(s);
		return user;
	}

	@Override
	public List<User> findAll()
	{
		String s = "UserDAO.findAll:";
		List<User> users = dao.findAll();
		s += " result=" + users;
		addLog(s);
		return users;
	}
}
