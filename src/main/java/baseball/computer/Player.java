package baseball.computer;

import static baseball.constants.Count.MAX_NUMBER;
import static baseball.constants.Count.MIN_NUMBER;
import static baseball.constants.Count.NUMBER_SIZE;
import static baseball.constants.Message.EXCEPTION_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {

    public List<Integer> input(String inputLine) {
        List<Integer> parsedInputNumbers = parseInputNumbers(inputLine);

        return new ArrayList<>(parsedInputNumbers);
    }

    private static List<Integer> parseInputNumbers(String inputLine) {
        if (Objects.isNull(inputLine) || inputLine.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }

        List<Integer> parsedInputNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_SIZE; i++) {
            int parsedNumber = inputLine.charAt(i) - '0';

            validateNumberIsOneDigitAndNotZero(parsedNumber);
            validateNumberIsAlreadyExist(parsedInputNumbers, parsedNumber);

            parsedInputNumbers.add(parsedNumber);
        }

        return parsedInputNumbers;
    }

    private static void validateNumberIsAlreadyExist(List<Integer> list, int number) {
        if (!list.contains(number)) {
            return;
        }

        throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

    private static void validateNumberIsOneDigitAndNotZero(int parsedNumber) {
        // 1 <= parsedNumber <= 9
        if (parsedNumber >= MIN_NUMBER && parsedNumber <= MAX_NUMBER) {
            return;
        }

        throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

    // Singleton
    private static Player instance;

    private Player() {
    }

    public static Player getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Player();
        }

        return instance;
    }

}
