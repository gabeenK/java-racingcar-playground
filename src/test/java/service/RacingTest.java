package service;

import org.junit.jupiter.api.Test;
import vo.Car;

import static org.junit.jupiter.api.Assertions.*;

class RacingTest {
	Racing sut = new Racing();

	@Test
	void setScore() {
	}


	@Test
	void judgeScore_기준_숫자가_4_이하() {
		// given
		Car car = new Car("aaa");

		RandomNumberGenerator randomNumberGenerator = () -> 4;
		MovableStrategy movableStrategy = new MovableStrategyImpl(randomNumberGenerator);

		// when
		sut.judgeScore(car, movableStrategy);

		// then
		assertEquals(0, car.getScore());
	}

	@Test
	void judgeScore_기준_숫자가_4_초과() {
		// given
		Car car = new Car("aaa");
		RandomNumberGenerator randomNumberGenerator = () -> 5;
		MovableStrategy movableStrategy = new MovableStrategyImpl(randomNumberGenerator);

		// when
		sut.judgeScore(car, movableStrategy);

		// then
		assertEquals(1, car.getScore());
	}

	@Test
	void printScore() {
	}

	@Test
	void getWinnerScoreWithPattern() {
		// given
		Car car = new Car("gabin");
		car.addScore();
		car.addScore();

		// when
		String winnerScoreWithPattern = sut.getWinnerScoreWithPattern(car);

		// then
		assertEquals("gabin : --", winnerScoreWithPattern);
	}

	@Test
	void getWinnerNameWithPattern() {
	}

	@Test
	void printWinner() {
	}
}