package com.loveahu.util.encrypy;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class EncryptUtil {

	public static final class AES {

		static final String algorithmStr = "AES/ECB/PKCS5Padding";

		static private KeyGenerator keyGen;

		static private Cipher staticCipher;

		static {
			try {
				// 初始化keyGen
				keyGen = KeyGenerator.getInstance("AES");
				keyGen.init(128);
				// 初始化cipher
				staticCipher = Cipher.getInstance(algorithmStr);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				System.exit(-1);
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}

		public static byte[] genKey() {
			return keyGen.generateKey().getEncoded();
		}
		
		public static byte[] encrypt2Bytes(byte[] content, byte[] keyBytes)
				throws InvalidKeyException, IllegalBlockSizeException,
				BadPaddingException {
			if (null==content) {
				return null;
			}
			byte[] encryptedText = content;
			Key key = new SecretKeySpec(keyBytes, "AES");
			try {
				Cipher cipher = Cipher.getInstance(algorithmStr);
				cipher.init(Cipher.ENCRYPT_MODE, key);
				encryptedText = cipher.doFinal(content);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			}
			return encryptedText;
		}
		
		// 解密为byte[]
		public static byte[] decrypt2Bytes(byte[] content, byte[] keyBytes)
				throws InvalidKeyException, IllegalBlockSizeException,
				BadPaddingException {
			if (null==content) {
				return null;
			}
			byte[] originBytes = null;
			Key key = new SecretKeySpec(keyBytes, "AES");
			try {
				Cipher cipher = Cipher.getInstance(algorithmStr);
				cipher.init(Cipher.DECRYPT_MODE, key);
				originBytes = cipher.doFinal(content);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			}
			return originBytes;
		}
	};

}
