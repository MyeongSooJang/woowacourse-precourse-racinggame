package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatus;

public class CarsTest {

    @Test
    void 자동차_이름을_통해_자동차가_만들어진다() {
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
    void 전략에_따라_모든_자동차를_이동시킨다() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carNames);
        MovingStrategy alwaysMove = () -> true;

        cars.moveAll(alwaysMove);

        List<CarStatus> result = cars.getCarStatuses();
        assertThat(result.get(0).getLocation()).isEqualTo(1);
        assertThat(result.get(1).getLocation()).isEqualTo(1);
        assertThat(result.get(2).getLocation()).isEqualTo(1);
    }

    @Test
    void 전략이_false를_반환하면_자동차가_이동하지_않는다() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carNames);
        MovingStrategy neverMove = () -> false;

        cars.moveAll(neverMove);

        List<CarStatus> result = cars.getCarStatuses();
        assertThat(result.get(0).getLocation()).isEqualTo(0);
        assertThat(result.get(1).getLocation()).isEqualTo(0);
        assertThat(result.get(2).getLocation()).isEqualTo(0);
    }

    @Test
    void 가장_많이_이동한_자동차가_우승자다() {
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
    void 공동_우승자를_모두_찾는다() {
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
