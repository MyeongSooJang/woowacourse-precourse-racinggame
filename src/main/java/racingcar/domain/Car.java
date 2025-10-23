package racingcar.domain;

public class Car {

    private final String name;
    private int location;

    public Car(String input) {
        this.name = input;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void move(boolean canMove) {
        if (canMove) {
            location++;
        }
    }
}
