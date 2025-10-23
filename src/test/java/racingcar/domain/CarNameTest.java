package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름이 5자 이하인 경우 정상적으로 생성이 된다.")
    void createValidCarName() {
        String input = "pobi";

        assertThatCode(() -> new CarName(input))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과인 경우 예외를 발생시킨다.")
    void createInvalidLongCarName() {
        String input = "pobbii";

        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("자동차의 이름이 비어 있는 경우 예외를 발생시킨다.")
    void createInvalidEmptyCarName() {
        String input = "";

        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 값일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차의 이름이 공백으로만 이루어진 경우 예외를 발생시킨다.")
    void createInvalidBlankCarName() {
        String input = "   ";

        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백으로만 이루어질 수 없습니다.");
    }
}
