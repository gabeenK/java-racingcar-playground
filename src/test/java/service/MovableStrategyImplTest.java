package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MovableStrategyImplTest {

	private MovableStrategy sut;

	private void setGiven(int randomNum) {
		RandomNumberGenerator randomNumberGenerator = () -> randomNum;
		this.sut = new MovableStrategyImpl(randomNumberGenerator);
	}

	@Test
	void move_less_than_4() {
		// given
		setGiven(4);

		// when
		boolean move = sut.move();

		// then
		assertFalse(move);
	}

	@Test
	void move_over_5() {
		// given
		setGiven(5);

		// when
		boolean move = sut.move();

		// then
		assertTrue(move);
	}
}