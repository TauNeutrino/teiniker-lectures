How to configure a Datasource in Wildfly 8?
-------------------------------------------------------------------------------

To allow our applicatios to connect to a database, we will need to configure 
Wildfly by adding a datasource. Upon server startup, each datasource is 
prepopulated with a pool of database connections.

Applications acquire a database connection from the pool by doing a JNDI lookup
and then calling getConnection().

Any database configuration requires a two step procedure:
	- Installing the JDBC driver
	- Adding the datasource to our configuration
	
1. Installing the JDBC driver
-----------------------------

The recommended approach is to install the driver as a module.
The firts step to install a new module is to create the directory structure 
under the modules folder:

$ pwd
/home/student/install/wildfly-8.2.0.Final

$ tree modules
modules/
├── com
│   └── mysql
│       └── main
│           ├── module.xml
│           └── mysql-connector-java-5.1.24-bin.jar
...

You can find this structure and the JDBC driver in the modules folder in
this project.
 
Second we have to create the module.xml file. This file contains the actual
module definition. 

Note that a working module.xml can be found in the project's module folder.

module.xml:

	<module xmlns="urn:jboss:module:1.0" name="com.mysql">
		<resources>             
			<resource-root path="mysql-connector-java-5.1.24-bin.jar"/>	
		</resources>
		<dependencies>
			<module name="javax.api"/>
		</dependencies>
	</module>


2. Adding a local datasource
----------------------------

Once the JDBC driver is installed, we need to configure the datasource within 
the application server's configuration file.

$ pwd
/home/student/install/wildfly-8.2.0.Final/standalone/configuration

standalone.xml
		...
        <subsystem xmlns="urn:jboss:domain:datasources:2.0">
            <datasources>
                <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true">
                    <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
                    <driver>h2</driver>
                    <security>
                        <user-name>sa</user-name>
                        <password>sa</password>
                    </security>
                </datasource>
<!-- add begin -->
                <datasource jndi-name="java:jboss/datasources/MySqlDS" pool-name="MySqlDS" enabled="true" use-java-context="true" use-ccm="true">
                    <connection-url>jdbc:mysql://localhost:3306/testdb</connection-url>
                    <driver>mysql</driver>
                    <security>
                        <user-name>student</user-name>
                        <password>student</password>
                    </security>
                </datasource>
<!-- add end -->
                <drivers>
                    <driver name="h2" module="com.h2database.h2">
                        <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
                    </driver>
<!-- add begin -->
                    <driver name="mysql" module="com.mysql">
                        <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
                    </driver>
<!-- add end -->                    
                </drivers>
            </datasources>
        </subsystem>
        ...  	
        
The elements of the <datasource> configurations mean:

	<connection-url> is used to define the connection path to the database
    
    <driver> is used to define the JDBC driver class
    
    <security> is used to configure the connection credentials.
    

    