package racingcar.domain;

public class Attempt {
    private static final int MIN_ATTEMPT = 1;
    private final int value;

    public Attempt(String input) {
        validateNotEmpty(input);
        validateIsNumeric(input);
        int count = Integer.parseInt(input);
        validateRange(count);
        this.value = count;
    }

    private void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수를 입력해주세요.");
        }
    }

    private void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateRange(int count) {
        if (count < MIN_ATTEMPT) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
