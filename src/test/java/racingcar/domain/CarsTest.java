package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatus;

public class CarsTest {

    @Test
    @DisplayName("자동차 이름을 통해 자동차가 만들어진다.")
    void makeCarsByCarNames() {

        List<String> carNames = List.of("pobi", "woni", "jun");

        Cars cars = new Cars(carNames);

        assertThat(cars).isNotNull();
    }

    @Test
    void 빈_리스트로_생성하면_예외가_발생한다() {
        // given
        List<String> emptyList = List.of();

        assertThatThrownBy(() -> new Cars(emptyList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 전달한_이름_개수만큼_자동차가_생성된다() {
        List<String> carNames = List.of("pobi", "woni", "jun");

        Cars cars = new Cars(carNames);

        assertThat(cars.getSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("전략에 따라 모든 자동차를 이동시킨다")
    void moveAll() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carNames);
        MovingStrategy alwaysMove = () -> true;

        cars.moveAll(alwaysMove);

        List<CarStatus> result = cars.getCarStatus();
        assertThat(result.get(0).getLocation()).isEqualTo(1);
        assertThat(result.get(1).getLocation()).isEqualTo(1);
        assertThat(result.get(2).getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("전략이 false를 반환하면 자동차가 이동하지 않는다")
    void doNotMoveWhenStrategyReturnsFalse() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carNames);
        MovingStrategy neverMove = () -> false;

        cars.moveAll(neverMove);

        List<CarStatus> result = cars.getCarStatus();
        assertThat(result.get(0).getLocation()).isEqualTo(0);
        assertThat(result.get(1).getLocation()).isEqualTo(0);
        assertThat(result.get(2).getLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("가장 많이 이동한 자동차가 우승자다")
    void findSingleWinner() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carNames);

        MovingStrategy moveThirdCarOnly = new MovingStrategy() {
            private int callCount = 0;

            @Override
            public boolean canMove() {
                return callCount++ == 2;
            }
        };

        cars.moveAll(moveThirdCarOnly);

        assertThat(cars.getWinners()).containsExactly("jun");
    }

    @Test
    @DisplayName("공동 우승자를 모두 찾는다")
    void findMultipleWinners() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carNames);

        MovingStrategy moveSecondAndThirdCar = new MovingStrategy() {
            private int callCount = 0;

            @Override
            public boolean canMove() {
                int index = callCount++;
                return index == 1 || index == 2;
            }
        };

        cars.moveAll(moveSecondAndThirdCar);

        assertThat(cars.getWinners()).containsExactlyInAnyOrder("woni", "jun");
    }

}
