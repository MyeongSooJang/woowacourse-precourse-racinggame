package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class AttemptTest {

    @Test
    void 유효한_시도_횟수로_Attempt_객체를_생성한다() {
        String attemptNumber = "5";

        assertThatCode(() -> new Attempt(attemptNumber))
                .doesNotThrowAnyException();
    }

    @Test
    void 시도_횟수가_1_미만이면_예외를_발생시킨다() {
        String attemptNumber = "0";

        assertThatThrownBy(() -> new Attempt(attemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 시도_횟수가_숫자가_아니면_예외를_발생시킨다() {
        String attemptNumber = "abc";

        assertThatThrownBy(() -> new Attempt(attemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자여야 합니다.");
    }

    @Test
    void 시도_횟수가_빈_문자열이면_예외를_발생시킨다() {
        String attemptNumber = "";

        assertThatThrownBy(() -> new Attempt(attemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수를 입력해주세요.");
    }
}
