SpringSecurity: Session Management
-------------------------------------------------------------------------------

How to access the Web application from a browser?
-------------------------------------------------------------------------------

URL: http://localhost:8080/SpringSecurity-SessionManagement/


How to use HTTP Basic authentication?
-------------------------------------------------------------------------------

Replace <form-login/> with <http-basic/>

Analyze the HTTP headers used in the request response transactions.
Authorization: Basic c3R1ZGVudDpzdHVkZW50
decode base64 => student:student


How to add HTTPS support?
-------------------------------------------------------------------------------
Change or add the following configurations to the spring-security.xml

	<http auto-config="true" use-expressions="true">
		 <intercept-url pattern="/**" access="hasRole('USER')" 
		 	requires-channel="https"/>
		 
		 <port-mappings>
		 	<port-mapping http="8080" https="8443"/>
		 </port-mappings>
		...
	</http>	

With this configuration in place, if a user attempts to access anything matching the 
"/**" pattern using HTTP, they will first be redirected to an HTTPS URL.
The available options are "http", "https" or "any". Using the value "any" means that 
either HTTP or HTTPS can be used.

If the application uses non-standard ports for HTTP and/or HTTPS, we can specify a 
list of port mappings.

Analyse the HTTP(S) traffic using BurpSuite.



How to add password hashing?
-------------------------------------------------------------------------------
This is supported by the <password-encoder> element. With SHA-256 encoded 
passwords, the original authentication provider configuration would look 
like this:

	<authentication-manager>
		<authentication-provider>
			<password-encoder hash="sha-256"/>
			<user-service>
				<user name="student" 
					password="264c8c381bf16c982a4e59b0dd4c6f7808c51a05f64c35db42cc78a2a72875bb" 
					authorities="ROLE_USER" />
				<user name="bart" 
					password="9551dadbf76a27457946e70d1aebebe2132f8d3bce6378d216c11853524dd3a6" 
					authorities="ROLE_USER" />
			</user-service>
		</authentication-provider>
	</authentication-manager>

Note: We can use BurpSuite/Decoder to calculate the hash values. 


How to add password hashing with salt (using BCrypt)?
-------------------------------------------------------------------------------

	<authentication-manager>
		<authentication-provider>
			<password-encoder hash="bcrypt"/>
			<user-service>
				<user name="student" 
					password="$2a$10$rw4FZiFAGyZcwpQYFl0PA.B0WiY3dLoO2/5ypZ5VNF.sUyiYN8TZm" 
					authorities="ROLE_USER" />
				<user name="bart" 
					password="$2a$10$83118r21RDrIIBV31byTWOsjPRFvAgMTf.8/FwHKlfGO6eJHxtewK" 
					authorities="ROLE_USER" />
			</user-service>
		</authentication-provider>
	</authentication-manager>

To create password hash values we use a simple JUnit test:

	@Test
	public void testEncoder()
	{
		String password = "student";
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
	
		System.out.println(hashedPassword);
	}
	
	
	
		
How to run Wildfly and deploy the Web application?
-------------------------------------------------------------------------------

$ mvn wildfly:run

Make sure that you have configured the wildfly-maven-plugin:

	<configuration>
		<jbossHome>/home/student/install/wildfly-8.2.0.Final</jbossHome>
		<port>9990</port>
		<server-config>standalone.xml</server-config>
	</configuration> 
