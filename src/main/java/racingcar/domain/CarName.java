package racingcar.domain;

public class CarName {

    private static final int MAX_LENGTH = 5;
    private final String value;

    public CarName(String name) {
        validateIsBlank(name);
        validateLength(name);
        this.value = name;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private void validateIsBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백으로만 이루어질 수 없습니다.");
        }
    }


    public String getValue() {
        return value;
    }
}
