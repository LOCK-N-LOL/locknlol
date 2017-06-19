package com.locknlol.coukie.domain.member.security;

import sun.misc.BASE64Encoder;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class Crypto {

	private static final SecureRandom RANDOM = new SecureRandom();

	public static final int SALT_LENGTH = 32;
	public static final int KEY_LENGTH = 256;
	public static final String ALGORITHM_PBKDF = "PBKDF2WithHmacSHA256";

	public static byte[] createSalt() {
		byte[] salt = new byte[SALT_LENGTH];
		RANDOM.nextBytes(salt);
		return salt;
	}

	// PBKDF2 암호화 : https://en.wikipedia.org/wiki/PBKDF2
	public static String pbkdf2(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
		return pbkdf2(password, createSalt());
	}

	public static String pbkdf2(String password, byte[] salt) throws InvalidKeySpecException, NoSuchAlgorithmException {
		BASE64Encoder encoder = new BASE64Encoder();

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM_PBKDF);
		KeySpec pdkdf2 = new PBEKeySpec(password.toCharArray(), salt, password.length() % 10 + 1, KEY_LENGTH);
		SecretKey key = keyFactory.generateSecret(pdkdf2);

		return String.format("%s:%s", encoder.encode(salt), encoder.encode(key.getEncoded()));
	}

}
