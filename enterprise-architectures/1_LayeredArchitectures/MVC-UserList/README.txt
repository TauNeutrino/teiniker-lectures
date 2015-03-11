How to start and stop the MySQL server?
---------------------------------------------------------------------

$ su
root66

# systemctl start mysqld.service

# systemctl stop mysqld.service


How to install the JDBC driver in Tomcat?
---------------------------------------------------------------------

Copy the lib/mysql/mysql-connector-java-5.1.13-bin.jar file
into the Tomcat's lib directory:

$ cd install/apache-tomcat-8.0.11
$ tree lib/
...
├── mysql-connector-java-5.1.13-bin.jar
...


How to set the JDBC properties?
---------------------------------------------------------------------
Edit the jdbc.properties file.

Here are the default settings:

jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/testdb
jdbc.username=student
jdbc.password=student


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

http://localhost:8080/MVC-UserList/

