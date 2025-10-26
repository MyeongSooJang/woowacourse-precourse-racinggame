package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptTest {


    @Test
    @DisplayName("유효한 시도 횟수로 Attempt 객체를 생성한다")
    void createValidAttempt() {
        String attemptNumber = "5";

        assertThatCode(() -> new Attempt(attemptNumber))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도 횟수가 1 미만이면 예외를 발생시킨다")
    void createInvalidAttempt() {
        String attemptNumber = "0";

        assertThatThrownBy(() -> new Attempt(attemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외를 발생시킨다")
    void createNonNumericAttempt() {
        String attemptNumber = "abc";

        assertThatThrownBy(() -> new Attempt(attemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 빈 문자열이면 예외를 발생시킨다")
    void createEmptyAttempt() {
        String attemptNumber = "";

        assertThatThrownBy(() -> new Attempt(attemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수를 입력해주세요.");

    }
}
