package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    void 자동차_이름이_5자_이하인_경우_정상적으로_생성된다() {
        String input = "pobi";

        assertThatCode(() -> new CarName(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름이_5자_초과인_경우_예외를_발생시킨다() {
        String input = "pobbii";

        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 자동차_이름이_빈_문자열인_경우_예외를_발생시킨다() {
        String input = "";

        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 공백으로만 이루어질 수 없습니다.");
    }

    @Test
    void 자동차_이름이_공백으로만_이루어진_경우_예외를_발생시킨다() {
        String input = "   ";

        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 공백으로만 이루어질 수 없습니다.");
    }
}
