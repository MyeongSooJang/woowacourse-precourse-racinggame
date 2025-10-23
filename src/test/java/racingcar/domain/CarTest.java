package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차는 이름을 가진다.")
    void carHasName() {
        String input = "pobi";

        Car car = new Car(input);

        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차는 초기 위치가 0이다")
    void carHasLocation() {
        String input = "pobi";

        Car car = new Car(input);

        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("전진 조건을 만족하면 위치가 1 증가한다.")
    void carCanMove() {
        String input = "pobi";

        Car car = new Car(input);
        car.move(true);

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진 조건을 만족하면 위치가 변하지 않는다.")
    void carCanReturnLocation() {
        String input = "pobi";

        Car car = new Car(input);
        car.move(false);

        assertThat(car.getLocation()).isEqualTo(0);
    }
}
