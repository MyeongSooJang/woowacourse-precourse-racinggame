package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 자동차_이름_리스트로_Cars_객체를_생성한다(){

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

}
