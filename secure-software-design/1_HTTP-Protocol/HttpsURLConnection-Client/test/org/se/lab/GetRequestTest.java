package org.se.lab;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

public class GetRequestTest
	extends AbstractHttpClientTest
{
	@Test
	public void test() throws MalformedURLException 
	{
		// Set the path to the used key store
		System.setProperty( "javax.net.ssl.trustStore", "/home/student/SSLKeyStore" );
		System.setProperty( "javax.net.ssl.trustStorePassword", "student" );
		
		URL url = new URL("https://localhost:8443" +
				"/Servlet-SSL-SimpleLogin/controller" +
				"?username=student&password=student&usergroup=User&action=Login");			

		String response = httpsGetRequest(url);
		
		Assert.assertTrue(response.contains("Welcome"));
	}
}
