package org.se.lab;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

public class SymmetricStreamCipher
{
	@Test
	public void testARC4() 
		throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, InvalidAlgorithmParameterException 
	{
		byte[] input = new byte[]
		{
			0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07,
			0x08,0x09,0x0a,0x0b,0x0c,0x0d,0x0e,0x0f,
			0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07			
		};
				
		System.out.println("input : " + Hex.encodeHexString(input) + " bytes: " + input.length);
		
		
		// Setup
		KeyGenerator keyGen = KeyGenerator.getInstance("ARC4");
		keyGen.init(128); // set key size in bits
		SecretKey key = keyGen.generateKey();
		System.out.println("key   : " + Hex.encodeHexString(key.getEncoded()) + " bytes: " + key.getEncoded().length);
		
		Cipher cipher = Cipher.getInstance("ARC4");		
//		Cipher cipher = Cipher.getInstance("ARC4", "BC");		
		System.out.println("block size: " + cipher.getBlockSize() + " bytes");	// block size == 0

		
		// Encryption
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
	
		int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
		ctLength += cipher.doFinal(cipherText, ctLength);
		System.out.println("cipher: " + Hex.encodeHexString(cipherText) + " bytes: " + ctLength);
		
		
		// Decryption
		cipher.init(Cipher.DECRYPT_MODE, key);
		
		byte[] plainText = new byte[cipher.getOutputSize(ctLength)];
		
		int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);
		ptLength += cipher.doFinal(plainText, ptLength);
		System.out.println("plain : " + Hex.encodeHexString(plainText) + " bytes: " + ptLength);
	}

}
