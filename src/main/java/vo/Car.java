package vo;

public class Car {

	public String name;
	public int score;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void addScore() {
		this.score++;
	}

	@Override
	public String toString() {
		return "Car{" +
				"name='" + name + '\'' +
				", score=" + score +
				'}';
	}
}