package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PasswordEncrypterTest
{
	private PasswordEncrypter manager;
	
	@Before
	public void setup()
	{
		manager = new PasswordEncrypter();
	}

	@Test
	public void testCheckPasswords()
	{
		Assert.assertTrue(manager.checkPassword("Trink4Bier", 
				"iSWOkuMQ+qV5G8oLNg432X5iti4OAHs79ar+lfKg1npFsspEbUuAvrhDjYzXsxmc"));
		Assert.assertTrue(manager.checkPassword("ase4all", "vOz4EjH2bHEYPABpg30Dp+eE0qJcQlKS0wLkoR/9xQ0X1OviLVLy9BQ2b45vMHzB"));
	}
	
	@Test
	public void testEncryptAndCheckPassword() 
	{
		// Note that encryptPassword always returns a different hash value 
		// because of the random salt 
		String hash = manager.encryptPassword("Trink4Bier");
		
		System.out.println(hash);
		
		Assert.assertTrue(manager.checkPassword("Trink4Bier", hash));
		Assert.assertFalse(manager.checkPassword("Trink2Bier", hash));
	}	
}
