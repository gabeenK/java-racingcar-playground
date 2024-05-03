package client;

import service.Racing;
import vo.Cars;

public class Output {

    Racing racing = new Racing();

    public void play(Cars cars, int tryCnt) {
        System.out.println("실행 결과");
        while (tryCnt > 0) {
            racing.setScore(cars);
            racing.printScore(cars);
            tryCnt--;
        }
        racing.printWinner(cars);
    }

}