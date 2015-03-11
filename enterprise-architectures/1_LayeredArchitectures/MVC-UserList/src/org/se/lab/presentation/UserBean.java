package org.se.lab.presentation;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.se.lab.business.UserService;
import org.se.lab.data.User;


public class UserBean
{
	private final Logger logger = Logger.getLogger(UserBean.class);	
	private final ServiceFactory factory = new ServiceFactory();
	
	
	/*
	 * View-Helper Methods
	 */

	public String getUserTable()
	{
		StringBuilder html = new StringBuilder();
		try
		{
			UserService service = factory.createUserService();
			List<User> users = service.findAllUsers();
			
			for (User user : users)
			{
				html.append("<tr>");
				html.append("<td width=\"150\">").append(user.getFirstname()).append("</td>");
				html.append("<td width=\"150\">").append(user.getLastname()).append("</td>");
				html.append("<td width=\"150\">").append(user.getUsername()).append("</td>");
				html.append("<td width=\"150\">").append(user.getPassword()).append("</td>");
				html.append("<td width=\"100\" align=\"center\"><form method = \"post\" action = \"/MVC-UserList/controller\"><input type = \"hidden\" name = \"id\" value = \"");
				html.append(user.getId()).append("\"><input type = \"submit\" name = \"action\" value = \"Delete\" /></form></td>");
				html.append("</tr>").append("\n");
			}
		} 
		catch (Exception e)
		{
			// TODO: generate message
			logger.error("Can't create user HTML table", e);
		}
		return html.toString();
	}

	
	public String getTimeStamp()
	{
		Date timeStamp = new Date();
		return timeStamp.toString();
	}
}
