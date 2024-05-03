package vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vo.Car;
import vo.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {
	/*
		1. 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
		2. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
		3. 자동차 이름은 쉼표(,)를 기준으로 구분한다.
		4. 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
		5. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
	*/

	// racing
	// car {name(5자 초과 하면 validate), value(random 값을 구하는 로직) , score}
	// racing {getJudgment(), judge(), getResult()}


	Cars sut = new Cars();

	@Test
	public void getPlayerCars() {
		// given
		String carNames = "aaa,bbb,ccc";
		// when
		List<Car> playerCars = sut.getPlayerCars(carNames);
		// then
		assertThat(playerCars.size()).isEqualTo(3);
		assertThat(playerCars.get(0).getName()).isEqualTo("aaa");
		assertThat(playerCars.get(1).getName()).isEqualTo("bbb");
		assertThat(playerCars.get(2).getName()).isEqualTo("ccc");
	}

	@Test
	public void carsToArray_자동차명_배열_변환() {
		// given
		String carNames = "111,222,333";
		// when
		String[] result = sut.carsToArray(carNames);
		// then
		assertThat(result).containsExactly("111", "222", "333");
	}

	@Test
	public void validateCarName_자동차_이름이_유효하지_않은_경우___5자_초과() {
		// given
		String test = "failvalue";

		// when - then
		assertThatThrownBy(() -> sut.validateCarName(test))
				.isInstanceOf(RuntimeException.class);
	}

	@Test
	public void validateCarName_자동차_이름이_유효하지_않은_경우___이름_미입력() {
		// given
		String test = "";

		// when - then
		assertThatThrownBy(() -> sut.validateCarName(test))
				.isInstanceOf(RuntimeException.class);
	}

	@Test
	public void validateCarName_자동차_이름이_유효하지_않은_경우___이름_정상() {
		// given
		String test = "pass";

		// when - then
		try {
			sut.validateCarName(test);
		} catch (Exception e) {
			Assertions.fail("이름 길이 테스트 실패");
		}
	}

	@Test
	void getWinnerScore() {
		// given
		Car car1 = new Car("aaa");
		Car car2 = new Car("bbb");
		Car car3 = new Car("ccc");
		Car car4 = new Car("ddd");

		int winnerScore = 4;
		setScore(car1, winnerScore - 1);
		setScore(car2, winnerScore - 2);
		setScore(car3, winnerScore - 3);
		setScore(car4, winnerScore);

		List<Car> carList = new ArrayList<>();
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		carList.add(car4);

		sut.setCars(carList);

		// when
		int result = sut.getWinnerScore();

		// then
		assertEquals(winnerScore, result);
	}

	@Test
	void getWinnerNames_우승자가_한명() {
		// given
		Car car1 = new Car("aaa");
		Car car2 = new Car("bbb");
		Car car3 = new Car("ccc");
		Car car4 = new Car("ddd");

		int winnerScore = 4;
		setScore(car1, winnerScore - 1);
		setScore(car2, winnerScore - 2);
		setScore(car3, winnerScore - 3);
		setScore(car4, winnerScore);

		List<Car> carList = new ArrayList<>();
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		carList.add(car4);

		sut.setCars(carList);

		// when
		List<String> winnerNameList = sut.getWinnerNames();

		// then
		assertEquals(1, winnerNameList.size());
		assertThat(winnerNameList).containsExactly(car4.getName());
	}

	@Test
	void getWinnerNames_우승자가_두명이상() {
		// given
		Car car1 = new Car("aaa");
		Car car2 = new Car("bbb");
		Car car3 = new Car("ccc");
		Car car4 = new Car("ddd");

		int winnerScore = 3;
		setScore(car1, winnerScore - 1);
		setScore(car2, winnerScore);
		setScore(car3, winnerScore - 2);
		setScore(car4, winnerScore);

		List<Car> carList = new ArrayList<>();
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		carList.add(car4);

		sut.setCars(carList);

		// when
		List<String> winnerNameList = sut.getWinnerNames();

		// then
		assertEquals(2, winnerNameList.size());
		assertThat(winnerNameList).containsExactly(car2.getName(), car4.getName());
	}

	private void setScore(Car car, int score) {
		IntStream.range(0, score).forEach(i -> car.addScore());
	}
}