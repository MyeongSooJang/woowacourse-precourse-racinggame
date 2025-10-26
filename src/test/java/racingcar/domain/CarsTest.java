package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 자동차_이름_리스트로_Cars_객체를_생성한다() {

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

        List<Car> result = cars.getCars();
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

        List<Car> result = cars.getCars();
        assertThat(result.get(0).getLocation()).isEqualTo(0);
        assertThat(result.get(1).getLocation()).isEqualTo(0);
        assertThat(result.get(2).getLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("가장 많이 이동한 자동차가 우승자다")
    void findSingleWinner() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carNames);

        cars.getCars().get(0).move(false);
        cars.getCars().get(1).move(false);
        cars.getCars().get(2).move(true);

        assertThat(cars.getWinners()).containsExactly("jun");

    }

    @Test
    @DisplayName("공동 우승자를 모두 찾는다")
    void findMultipleWinners() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carNames);

        cars.getCars().get(0).move(false);
        cars.getCars().get(1).move(true);
        cars.getCars().get(2).move(true);

        assertThat(cars.getWinners()).containsExactlyInAnyOrder("woni", "jun");
    }

}
