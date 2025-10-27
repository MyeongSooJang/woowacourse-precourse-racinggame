package racingcar.dto;

public class CarStatus {
    private final String name;
    private final int location;

    public CarStatus(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
