package org.se.lab.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Before;

public abstract class AbstractTestBase
{
	protected Proxy PROXY;
	protected String HOST;
	protected String PORT;

	// Cipher settings
	protected String keyProperty;
	protected String ivProperty;


	@Before
    public void setup() throws IOException
    {
    	Properties properties = new Properties();
    	properties.load(this.getClass().getResourceAsStream("/rest.properties"));
    	HOST = properties.getProperty("rest.host");
    	PORT = properties.getProperty("rest.port");
    	System.out.println("Connect to " + HOST + ":" + PORT);
    
    	// Cipher settings
    	keyProperty = properties.getProperty("encryption.key");
        ivProperty = properties.getProperty("encryption.iv");
    	
    	String proxyAddress = properties.getProperty("proxy.address");
    	String proxyPort = properties.getProperty("proxy.port");
    	if (proxyAddress != null && proxyPort != null)
    	{
    		System.out.println("Use proxy " + proxyAddress + ":" + proxyPort);
    		int port = Integer.parseInt(proxyPort);
    		PROXY = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyAddress, port));
    	}
    	else
    	{
    		PROXY = Proxy.NO_PROXY;
    	}
    }

	
	/*
	 * Utility methods
	 */
	
	protected String readResponseContent(InputStream in) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		StringBuffer content = new StringBuffer();
		while ((line = reader.readLine()) != null)
		{
			content.append(line).append("\n");
		}
		return content.toString();
	}
	
    
    protected String encryptToString(String inputString)
    {
        try
        {   
            byte[] input = inputString.getBytes();
            byte[] ivBytes = Hex.decodeHex(ivProperty.toCharArray());
            byte[] keyBytes = Hex.decodeHex(keyProperty.toCharArray());
            
            // Setup
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
            byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
            int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
            ctLength += cipher.doFinal(cipherText, ctLength);
            return Hex.encodeHexString(cipherText);
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException 
                | InvalidKeyException | InvalidAlgorithmParameterException 
                | ShortBufferException | IllegalBlockSizeException 
                | BadPaddingException | DecoderException e)
        {
            throw new IllegalStateException("Can't encrypt input!", e);
        }
    }
    
    
    protected String decryptToString(String cipherText)
    {
        try
        {
            byte[] ivBytes = Hex.decodeHex(ivProperty.toCharArray());
            byte[] keyBytes = Hex.decodeHex(keyProperty.toCharArray());
            byte[] cipherBytes = Hex.decodeHex(cipherText.toCharArray());
            
            // Setup
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
            int ctLength = cipherBytes.length;
            byte[] plainText = new byte[cipher.getOutputSize(ctLength)];
            int ptLength = cipher.update(cipherBytes, 0, ctLength, plainText, 0);
            ptLength += cipher.doFinal(plainText, ptLength);
            return new String(plainText);
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException 
                | InvalidKeyException | InvalidAlgorithmParameterException 
                | ShortBufferException | IllegalBlockSizeException 
                | BadPaddingException | DecoderException e)
        {
            throw new IllegalStateException("Can't encrypt input!", e);
        }
    }
}
