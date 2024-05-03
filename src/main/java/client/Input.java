package client;

import vo.Cars;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        client();
    }

    public static void client() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carInput = scanner.next();

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCnt = scanner.nextInt();

        controller(carInput, tryCnt);

    }

    public static void controller(String carInput, int tryCnt) {
        Cars cars = new Cars(carInput);
        new Output().play(cars, tryCnt);
    }
}