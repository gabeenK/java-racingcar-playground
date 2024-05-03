package service;

import org.junit.jupiter.api.Test;
import service.MovableStrategyImpl;
import service.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MovableStrategyImplTest {

	MovableStrategyImpl sut = new MovableStrategyImpl();

	@Test
	void move_less_than_4() {
		// given
		RandomNumberGenerator randomNumberGenerator = () -> 4;

		// when
		boolean move = sut.move(randomNumberGenerator);

		// then
		assertFalse(move);
	}

	@Test
	void move_over_5() {
		// given
		RandomNumberGenerator randomNumberGenerator = () -> 5;

		// when
		boolean move = sut.move(randomNumberGenerator);

		// then
		assertTrue(move);
	}
}