SpringSecurity: Simple Login
-------------------------------------------------------------------------------


		


How to access the Web application from a browser?
-------------------------------------------------------------------------------

URL: http://localhost:8080/SpringSecurity-SessionManagement/


How to run Wildfly and deploy the Web application?
-------------------------------------------------------------------------------

$ mvn wildfly:run

Make sure that you have configured the wildfly-maven-plugin:

	<configuration>
		<jbossHome>/home/student/install/wildfly-8.2.0.Final</jbossHome>
		<port>9990</port>
		<server-config>standalone.xml</server-config>
	</configuration> 
