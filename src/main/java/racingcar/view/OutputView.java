package racingcar.view;

import java.util.List;
import racingcar.dto.CarStatus;

public class OutputView {
    private static final String OUTPUT_VIEW_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String NAME_DELIMITER =", ";
    private static final String LOCATION_SYMBOL= "-";
    private static final String LOCATION_FORMAT = " : ";


    public void showOutput() {
        System.out.println(OUTPUT_VIEW_MESSAGE);
    }

    public void showCarStatus(List<CarStatus> carStatuses) {
        for (CarStatus carStatus : carStatuses) {
            printCarStatus(carStatus);
        }
        System.out.println();
    }

    private void printCarStatus(CarStatus carStatus) {
        System.out.println(carStatus.getName() + LOCATION_FORMAT + LOCATION_SYMBOL.repeat(carStatus.getLocation()));
    }

    public void printWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE + String.join(NAME_DELIMITER, winners));
    }
}
