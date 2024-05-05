package service;

public class MovableStrategyImpl implements MovableStrategy {

	private static final int JUDGE_NUM = 4;

	private final RandomNumberGenerator randomNumberGenerator;

	public MovableStrategyImpl() {
		this.randomNumberGenerator = new RandomNumberGeneratorImpl();
	}

	public MovableStrategyImpl(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	@Override
	public boolean move() {
		return randomNumberGenerator.random() > JUDGE_NUM;
	}
}
