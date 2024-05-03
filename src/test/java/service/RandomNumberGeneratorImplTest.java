package service;

import org.junit.jupiter.api.Test;
import service.RandomNumberGenerator;
import service.RandomNumberGeneratorImpl;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorImplTest {

	RandomNumberGenerator sut = new RandomNumberGeneratorImpl();

	@Test
	void random_랜덤숫자는_10의자리를_넘지_않는다() {
		for (int i = 0; i < 100; i++) {
			// given = when
			int num = sut.random();
			// then
			assertFalse(num >= 10);
		}
	}
}