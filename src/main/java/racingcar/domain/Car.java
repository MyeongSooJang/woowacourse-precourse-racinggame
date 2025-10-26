package racingcar.domain;

public class Car {

    private final CarName name;
    private int location;

    public Car(String input) {
        this.name = new CarName(input);
        this.location = 0;
    }

    public String getName() {
        return name.getValue();
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
