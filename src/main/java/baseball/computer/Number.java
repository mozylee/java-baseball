package baseball.computer;

import static baseball.constants.Count.NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Number {

    private final List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void initNumbers() {
        if (!numbers.isEmpty()) {
            numbers.clear();
        }

        addRandomNumbers();
    }

    private void addRandomNumbers() {
        while (numbers.size() < NUMBER_SIZE) {
            addRandomNumber();
        }
    }

    private void addRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (numbers.contains(randomNumber)) {
            return;
        }

        numbers.add(randomNumber);
    }

    // Singleton
    private static Number instance;

    private Number() {
    }

    public static Number getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Number();
        }

        return instance;
    }

}
