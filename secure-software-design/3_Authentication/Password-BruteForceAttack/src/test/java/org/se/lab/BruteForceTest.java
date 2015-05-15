package org.se.lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;


/*
 * To generate a wordlist, we use crunch, a wordlist generator
 * (see http://sourceforge.net/projects/crunch-wordlist/)
 * 
 * This is the procedure from the downloaded tar ball to the
 * final word list:
 * 
 * tar -xvzf crunch-3.2.tgz 
 * cd crunch3.2/
 * make
 * ./crunch 4 4 -o wordlist.txt
 */

public class BruteForceTest
{
	@Test
	public void testCalculateHashValue() throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		final String passwd = "student";
	
		String hash = calculateHashString(passwd);
		Assert.assertEquals("32ade5e7c36fa329ea39dbc352743db40da5aa7460ec55f95b999d6371ad20170094d88d9296643f192e9d5433b8d6d817d6777632e556e96e58f741dc5b3550", hash);
	}

	
	@Test
	public void testPasswordBruteForceAttack() throws NoSuchAlgorithmException, IOException
	{
		final String hashValue = "bb3340cfb96337e142cdd810678c0207be932bd8e6cd2890fbff2304491258efb07e6a51738ffd57dada2475b45f65650a5a2e2132a491766c8d7d7c67a9c85b";
		final String filename = "wordlist.txt";
			
		BufferedReader in = new BufferedReader(new FileReader(filename));			
		String line;	
		while((line = in.readLine()) != null)
		{
			String hash = calculateHashString(line);
			if(hash.equals(hashValue))
			{
				System.out.println("Success, password is: " + line);
				break;
			}
		}
		in.close();
	}

	
	/*
	 * Helper methods
	 */
	
	private String calculateHashString(final String message)
			throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		MessageDigest algorithm = MessageDigest.getInstance("SHA-512");		
		algorithm.update(message.getBytes("UTF-8"));
		byte[] bytes = algorithm.digest();
		return convertToHexString(bytes);
	}

	
	private String convertToHexString(byte[] bytes)
	{
		StringBuilder hex = new StringBuilder();
		for(byte b : bytes)
		{
			int i = (b & 0xff); // copy the byte bit pattern into int value
			hex.append(String.format("%02x", i));
		}
		return hex.toString();
	}
}
