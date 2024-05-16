package client;

import service.Racing;
import vo.Cars;

public class Output {

	Racing racing = new Racing();

	public void play(Cars cars, int tryCnt) {
		System.out.println("실행 결과");
		for (int i = 0; i < tryCnt; i++) {
			racing.setScore(cars);
			racing.printScore(cars);
		}
		result(cars);
	}

	void result(Cars cars) {
		racing.printWinner(cars);
	}
}