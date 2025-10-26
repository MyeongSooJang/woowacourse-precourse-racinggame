package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {
    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
