package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Attempt;

public class InputView {

    private static final String CAR_NAMES_VIEW_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String DELIMITER = ",";


    public List<String> readNames() {
        System.out.println(CAR_NAMES_VIEW_MESSAGE);
        String input = Console.readLine();
        return parseCarNames(input);
    }

    private List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public Attempt readAttempt() {
        System.out.println(ATTEMPT_INPUT_MESSAGE);
        String input = Console.readLine();
        return new Attempt(input);
    }

}
