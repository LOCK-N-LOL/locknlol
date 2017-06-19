package com.locknlol.coukie.domain.riot.auth;

import java.util.Random;

/**
 * Created by Oscar on 2017. 6. 11..
 */
public class AuthKeyGenerator {

	//Random is thread safe.
	private static Random random = new Random();

	private static final int MAX_LENGTH = 12;
	private static final int UPPER_CASE = 0;
	private static final int LOWER_CASE = 1;
	private static final int NUMBER = 2;
	private static final int LOWER_CASE_A_ASCII_CODE = 97;
	private static final int UPPER_CASE_A_ASCII_CODE = 65;
	private static final int NUMBER_OF_ALPHABAT = 26;
	private static final int NUMBER_OF_NUMBER = 10;

	public static String generateAuthKey() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < MAX_LENGTH; ++i) {
			builder.append(getRandomCharacter(random.nextInt(3)));
		}

		return builder.toString();
	}

	protected static Object getRandomCharacter(int type) {
		switch (type) {
			case LOWER_CASE:
				return (char) (random.nextInt(NUMBER_OF_ALPHABAT) + LOWER_CASE_A_ASCII_CODE);
			case UPPER_CASE:
				return (char) (random.nextInt(NUMBER_OF_ALPHABAT) + UPPER_CASE_A_ASCII_CODE);
			case NUMBER:
				return (random.nextInt(NUMBER_OF_NUMBER));
			default:
				return (random.nextInt(NUMBER_OF_NUMBER));
		}
	}
}
