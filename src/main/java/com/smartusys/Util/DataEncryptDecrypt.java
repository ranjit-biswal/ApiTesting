package com.smartusys.Util;

import android.util.Base64;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DataEncryptDecrypt {
	
	public static void main(String args[]) throws Exception
	{
		DataEncryptDecrypt dataEncryptDecrypt = new DataEncryptDecrypt();
		String a = dataEncryptDecrypt.Encrypt("abcd", "PasswordPassword");
		System.out.println(a);
		
	}
	

    public String Decrypt(String text, String key) throws Exception {
        //RSA/ECB/PKCS1Padding
        //String DecryptedString =  URLDecoder.decode(text);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] keyBytes = new byte[16];
        byte[] b = key.getBytes("UTF-8");
        int len = b.length;
        if (len > keyBytes.length) len = keyBytes.length;
        System.arraycopy(b, 0, keyBytes, 0, len);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        //BASE64Decoder decoder = new BASE64Decoder();
        //byte [] results = cipher.doFinal(decoder.decodeBuffer(text));
        //byte [] results = cipher.doFinal(Base64.decode(text));
        byte[] results = cipher.doFinal(Base64.decode(text, Base64.DEFAULT));
        return new String(results, "UTF-8");
    }

    public String Encrypt(String text, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] keyBytes = new byte[16];
        byte[] b = key.getBytes("UTF-8");
        int len = b.length;
        if (len > keyBytes.length) len = keyBytes.length;
        System.arraycopy(b, 0, keyBytes, 0, len);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
        //BASE64Encoder encoder = new BASE64Encoder();
        //return encoder.encode(results);
        return Base64.encodeToString(results, Base64.DEFAULT);
    }

    public String encryptIOS(String textToEncrypt) {
        //logger.debug("encryptIOS(String stringToEncrypt) is called...\n" + textToEncrypt);
        try {
            Cipher c = getCipher(Cipher.ENCRYPT_MODE);
            byte[] encryptedVal = c.doFinal(textToEncrypt.getBytes("ASCII"));
            //return Base64.getEncoder().encodeToString(encryptedVal);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(encryptedVal));
        } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
            //logger.error("Exception occurs in encryptIOS(String stringToEncrypt)...", e);
        } catch (Exception e) {
            //logger.error("Exception occurs in encryptIOS(String stringToEncrypt)...", e);
        }
        return null;
    }

    private static Cipher getCipher(int mode)
            throws Exception {
        //logger.debug("getCipher(int mode) is called...\n" + mode);
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivSpec = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        c.init(mode, generateKey(), ivSpec);
        return c;
    }

    private static SecretKeySpec generateKey() throws Exception {
        //logger.debug("generateKey() is called...");
//   	final String Constant = ;
        byte[] keyBytes = "PasswordPassword".getBytes("ASCII");
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        return keySpec;
    }

}
