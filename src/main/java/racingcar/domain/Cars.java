package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarStatus;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateCarNames(carNames);
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름 리스트는 비어있을 수 없습니다.");
        }
    }

    public int getSize() {
        return cars.size();
    }

    public void moveAll(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy.canMove());
        }
    }

    public List<CarStatus> getCarStatuses() {
        return cars.stream()
                .map(car -> new CarStatus(car.getName(), car.getLocation()))
                .collect(Collectors.toList());
    }

    public List<String> getWinners(){
        int winnerLocation = getMaxLocation();
        return cars.stream()
                .filter(car-> car.getLocation() == winnerLocation)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxLocation(){
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }
}
