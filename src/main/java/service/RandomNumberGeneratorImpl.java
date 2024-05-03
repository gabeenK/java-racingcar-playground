package service;

import java.security.SecureRandom;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {
	private static final int MAX_NUM = 10;

	@Override
	public int random() {
		return new SecureRandom().nextInt(MAX_NUM);
	}
}
