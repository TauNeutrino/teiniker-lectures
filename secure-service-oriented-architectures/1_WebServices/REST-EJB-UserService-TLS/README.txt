

How to configure Wildfly's HTTPS connection?
-------------------------------------------------------------------------------
*) Create a Keystore

$ cd JBOSS_HOME/standalone/configuration
$ keytool -genkeypair -keystore wildfly.keystore -storepass student -keypass student -keyalg RSA -alias wildfly -dname "cn=ims,o=fhj,c=at" 
 
*) Configure Wildfly (standalone.xml):

        <management>
        <security-realms>
			...
            
            <!-- SSL/TLS Configuration (BEGIN) --> 
			<security-realm name="CertificateRealm">
				<server-identities>
					<ssl>
						<keystore path="wildfly.keystore" relative-to="jboss.server.config.dir" keystore-password="student" />
					</ssl>
				</server-identities>
			</security-realm>
			<!-- SSL/TLS Configuration (END) -->

        </security-realms>

	
       <subsystem xmlns="urn:jboss:domain:undertow:2.0">
            <buffer-cache name="default"/>
            <server name="default-server">
                <http-listener name="default" socket-binding="http" redirect-socket="https"/>
				
				<!-- SSL/TLS Configuration (BEGIN) -->  
				<https-listener name="https" socket-binding="https" security-realm="CertificateRealm"/>	
                <!-- SSL/TLS Configuration (END) -->
                
                <host name="default-host" alias="localhost">
                    <location name="/" handler="welcome-content"/>
                    <filter-ref name="server-header"/>
                    <filter-ref name="x-powered-by-header"/>
                </host>
            </server>
			...
        </subsystem>

*) Restart Wildfly
	=> Undertow HTTPS listener https listening on localhost/127.0.0.1:8443
	
	
	
 