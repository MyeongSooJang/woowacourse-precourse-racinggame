package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차는_이름을_가진다() {
        String input = "pobi";

        Car car = new Car(input);

        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 자동차는_초기_위치가_0이다() {
        String input = "pobi";

        Car car = new Car(input);

        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    void 전진_조건을_만족하면_위치가_1_증가한다() {
        String input = "pobi";

        Car car = new Car(input);
        car.move(true);

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    void 전진_조건을_만족하지_못하면_위치가_변하지_않는다() {
        String input = "pobi";

        Car car = new Car(input);
        car.move(false);

        assertThat(car.getLocation()).isEqualTo(0);
    }
}
