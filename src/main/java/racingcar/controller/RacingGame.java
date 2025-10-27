package racingcar.controller;

import java.util.List;
import racingcar.domain.Attempt;
import racingcar.domain.Cars;
import racingcar.domain.MovingStrategy;
import racingcar.domain.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final MovingStrategy movingStrategy;

    public RacingGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.movingStrategy = new RandomMovingStrategy();
    }

    public void run() {
        Cars cars = createCars();
        Attempt attempt = inputView.readAttempt();

        playRacingGame(cars, attempt);
        announceWinner(cars);
    }

    private Cars createCars() {
        List<String> carNames = inputView.readCarNames();
        return new Cars(carNames);
    }

    private void playRacingGame(Cars cars, Attempt attempt) {
        outputView.showOutput();
        for (int i = 0; i < attempt.getValue(); i++) {
            cars.moveAll(movingStrategy);
            outputView.showCarStatus(cars.getCars());
        }
    }

    private void announceWinner(Cars cars) {
        outputView.printWinners(cars.getWinners());
    }

}
