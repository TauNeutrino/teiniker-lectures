How to start and stop the MySQL server?
---------------------------------------------------------------------

$ su
root66

# systemctl start mariadb.service 

# systemctl stop mariadb.service 


How to create the user table in the MySQL server?
------------------------------------------------------------------------------

$ cd MVC-UserList
$ mysql -u student -p
Enter password: student

MariaDB [(none)]> use testdb;
[testdb]> show tables;

[testdb]> source sql/createUserTable.sql

[testdb]> describe user;
+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| id        | int(11)     | NO   | PRI | NULL    | auto_increment |
| firstname | varchar(32) | NO   |     | NULL    |                |
| lastname  | varchar(32) | NO   |     | NULL    |                |
| username  | varchar(32) | NO   |     | NULL    |                |
| password  | varchar(32) | NO   |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+

[testdb]> quit


How to access tha application from a browser?
------------------------------------------------------------------------------

http://localhost:8080/VulnerableWebApp/


Application Monitoring
------------------------------------------------------------------------------

In a shell, type:

$ jvisualvm

Note that jvisualvm is shipped with the JDK.


Load Testing
------------------------------------------------------------------------------
http://jmeter.apache.org/

$ cd apache-jmeter-2.13/
$ bin/jmeter.sh

	TestPlan
		+-- Thread Group 
				+-- HTTP Request
					Server: localhost
					Port: 8080
					Path: VulnerableWebApp/controller
					Parameters: ...					
				+-- View Results Tree
				+-- Graph Results
					=> Throughput = number of requests / minute
				+-- Response Time Graph

						
Security Testing (a.k.a. Penetration Testing)
------------------------------------------------------------------------------

Automatic: ZAP
			=> http://localhost:8080/VulnerableWebApp/
			=> select * from user;
				
Manual: 
	list.jsp
		=> Use Firebug to change Page
		=> XSS <script>alert('XSS');</script> 			
		=> Lookup password hash via Google
		
	login.jsp
		=> username: lisa' #0
		
			
	
