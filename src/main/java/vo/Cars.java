package vo;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

	private List<Car> cars = new ArrayList<>();

	public Cars() {
	}

	public Cars(String carNames) {
		this.cars = getPlayerCars(carNames);
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	List<Car> getPlayerCars(String carNames) {
		String[] carNameArr = carsToArray(carNames);
		return Arrays.stream(carNameArr).map(Car::new).collect(Collectors.toList());
	}

	String[] carsToArray(String carNames) {
		String[] carNameArr = carNames.split(",");
		Arrays.stream(carNameArr).forEach(this::validateCarName);
		return carNameArr;
	}

	void validateCarName(String carName) {
		if (StringUtils.isEmpty(carName)) {
			throw new RuntimeException("입력은 해야지요?");
		}
		if (carName.length() > 5) {
			throw new RuntimeException(carName + " <- 이거 5자리 넘었잖아요? 정확하게 입력해야지요?");
		}
	}

	int getWinnerScore() {
		return this.cars.stream()
				.mapToInt(Car::getScore)
				.max()
				.orElse(0);
	}

	public List<String> getWinnerNames() {
		int winnerScore = this.getWinnerScore();
		return this.cars.stream()
				.filter(car -> car.getScore() == winnerScore)
				.map(Car::getName)
				.toList();
	}
}