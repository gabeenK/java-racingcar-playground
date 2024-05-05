package service;

import org.apache.commons.lang3.StringUtils;
import vo.Car;
import vo.Cars;

import java.util.List;

public class Racing {

	public void setScore(Cars cars) {
		cars.getCars().forEach(car -> judgeScore(car, new MovableStrategyImpl()));
	}

	public void printScore(Cars cars) {
		cars.getCars().forEach(car -> System.out.println(getWinnerScoreWithPattern(car)));
		System.out.println();
	}

	public void printWinner(Cars cars) {
		List<String> winnerNames = cars.getWinnerNames();
		String winners = getWinnerNameWithPattern(winnerNames);

		System.out.println(winners + "가 최종 우승했습니다");
	}

	void judgeScore(Car car, MovableStrategy movableStrategy) {
		if (movableStrategy.move()) {
			car.addScore();
		}
	}

	String getWinnerScoreWithPattern(Car car) {
		return car.getName() + " : " + "-".repeat(car.getScore());
	}

	String getWinnerNameWithPattern(List<String> winnerNames) {
		return StringUtils.join(winnerNames, ",");
	}
}