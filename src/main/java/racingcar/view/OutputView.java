package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private static final String OUTPUT_VIEW_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String NAME_DELIMITER =", ";
    private static final String LOCATION_SYMBOL= "-";
    private static final String LOCATION_FORMAT = " : ";


    public void showOutput() {
        System.out.println(OUTPUT_VIEW_MESSAGE);
    }

    public void showCarStatus(List<Car> cars) {
        for (Car car : cars) {
            printCarStatus(car);
        }
        System.out.println();
    }

    private void printCarStatus(Car car) {
        System.out.println(car.getName() + LOCATION_FORMAT + LOCATION_SYMBOL.repeat(car.getLocation()));
    }

    public void printWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE + String.join(NAME_DELIMITER, winners));
    }
}
