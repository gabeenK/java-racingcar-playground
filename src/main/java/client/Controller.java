package client;

import vo.Cars;

import java.util.Scanner;

public class Controller {
    private final Output output = new Output();

    public void racingController(String carInput, int tryCnt) {
        Cars cars = new Cars(carInput);
        output.play(cars, tryCnt);
    }
}