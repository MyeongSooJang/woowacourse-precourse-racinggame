package racingcar.domain;

public class CarStatus {
    private final String name;
    private final int location;

    public CarStatus(String name, int position) {
        this.name = name;
        this.location = position;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
