package service;

public class MovableStrategyImpl implements MovableStrategy {

	private static final int JUDGE_NUM = 4;

	@Override
	public boolean move(RandomNumberGenerator randomNumberGenerator) {
		return  randomNumberGenerator.random() > JUDGE_NUM;
	}
}
