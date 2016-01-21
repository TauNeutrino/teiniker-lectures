<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="user" class="org.se.lab.presentation.UserBean" scope="request"/>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Vulnerable Web Application</title>
    </head>
    <body>

		<h1>Edit User List</h1>

    	<form method="POST" action="controller">
        	<table border="1">
            	<tr>
            		<th width="50">Id</th>
                	<th width="150">FirstName</th>
                	<th width="150">LastName</th>
                	<th width="150">Username</th>
                	<th width="150">Password</th>   
                	<th width="100">Actions</th> 
            	</tr>
            	<tr>
            		<td/>
                	<td><input type = "text" name = "firstName" maxlength="16" /></td>
                	<td><input type = "text" name = "lastName" maxlength="16" /></td>
                	<td><input type = "text" name = "username" maxlength="16" /></td>
                	<td><input type = "password" name = "password" /></td>
                	<td align="center"><input type = "submit" name = "action" value = "Add" /></td> 
            	</tr>
        	</table>
    	</form>

		
<%
	String message;
	if(request.getAttribute("message") == null)
		message = "";
	else
		message = (String)request.getAttribute("message");
%>

		<p style="color:blue"><i><%=message%></i></p>
    	<br/>    	    
		
		<p><a href="./list.jsp">Refresh User List</a></p>
		
		
		<table border="0">${user.userTable}</table>
		
        <h6>
        	${user.timeStamp}
        </h6>        
    </body>
</html>