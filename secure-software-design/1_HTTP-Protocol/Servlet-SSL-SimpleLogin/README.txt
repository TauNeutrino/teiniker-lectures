How to Create a KeyStore File?
-------------------------------------------------------------------------------
Create a keystore file to store the server's private key and self-signed  
certificate by executing the following command: 

$ pwd
/home/student

$ keytool -genkey -keystore SSLKeyStore -alias tomcat -keyalg RSA
	Enter keystore password: student  
	Re-enter new password: student 

	What is your first and last name?
  	[Unknown]:  egon teiniker
	What is the name of your organizational unit?
  	[Unknown]:  ase
	What is the name of your organization?
  	[Unknown]:  fhj
	What is the name of your City or Locality?
  	[Unknown]:  kberg
	What is the name of your State or Province?
  	[Unknown]:  st
	What is the two-letter country code for this unit?
  	[Unknown]:  at
	Is CN=egon teiniker, OU=ase, O=fhj, L=kberg, ST=st, C=at correct?
  	[no]:  yes

	Enter key password for <tomcat>
		(RETURN if same as keystore password):  
	Re-enter new password: 


Now we can find the KeyStore file in our home directory:

$ ll SSLKeyStore 
-rw-rw-r--. 1 student student 2215 May 24 14:08 SSLKeyStore





How to Configure Tomcat for Using the Keystore File ?
-------------------------------------------------------------------------------

First of all, make sure that Tomcat is not running when you change the configuration files.

    $CATALINA_BASE/bin/shutdown
    
We change the following Tomcat configuration: $CATALINA_BASE/conf/server.xml

    <!-- Define a SSL HTTP/1.1 Connector on port 8443
         This connector uses the JSSE configuration, when using APR, the
         connector should be using the OpenSSL style configuration
         described in the APR documentation -->
 
    <Connector port="8443" protocol="HTTP/1.1" SSLEnabled="true"
               maxThreads="150" scheme="https" secure="true"
               keystoreFile="${user.home}/SSLKeyStore" keystorePass="student" 
               clientAuth="false" sslProtocol="TLS" />

	
	After starting Tomcat, we can use a Browser to access the application's page:
    
    	https://localhost:8443/Servlet-SSL-SimpleLogin
    
	Note that it's also possible to access the page via regular HTTP: 
    
    	http://localhost:8080/Servlet-SSL-SimpleLogin
    	
	Note that Eclipse overrides these settings during server startup!!
	So it is a good idea to start Tomcat from the command line:
	
	$ pwd
	apache-tomcat-7.0.30
	
	$ bin/startup.sh
	$ tail -f logs/catalina.out
	
	To stop Tomcat, type:
	$ bin/shutdown.sh
	
    		
               
How to Configure your Web Application to Work with SSL ?
-------------------------------------------------------------------------------
	Open the WEB-INF/web.xml of the application and add this XML fragment:  	
 	
 	<security-constraint>
		<web-resource-collection>
			<web-resource-name>securedapp</web-resource-name>
			<url-pattern>/*</url-pattern>
		</web-resource-collection>
		<user-data-constraint>
			<transport-guarantee>CONFIDENTIAL</transport-guarantee>
		</user-data-constraint>
	</security-constraint>
	
	Note that this step is already done in this project.
	
	Now a Browser's request to 

		http://localhost:8080/Servlet-SSL-SimpleLogin 

	will be redirected to 

		https://localhost:8443/Servlet-SSL-SimpleLogin
	
               