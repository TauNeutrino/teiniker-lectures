How to start and stop the MySQL server?
------------------------------------------------------------------------------

Become root:
$ su
root66

Start the server process:
# systemctl start mysqld.service

Stop the server process:
# systemctl stop mysqld.service



How to access the MySQL server from the shell?
------------------------------------------------------------------------------

$ mysql -u student -p
Enter password: student

MariaDB [(none)]> use testdb;
[testdb]> show tables;

[testdb]> source sql/createUser.sql

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


 

 