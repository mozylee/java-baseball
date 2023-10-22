package baseball.computer;

import static baseball.computer.hint.Hint.BALL;
import static baseball.computer.hint.Hint.NOTHING;
import static baseball.computer.hint.Hint.STRIKE;
import static baseball.constants.Count.NUMBER_SIZE;

import baseball.computer.hint.Hint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Judgement {

    public static List<Hint> judge(List<Integer> computerNumber, List<Integer> playerNumber) {
        List<Hint> hints = new ArrayList<>();
        for (int i = 0; i < NUMBER_SIZE; i++) {
            checkNumber(playerNumber.get(i), computerNumber, i, hints);
        }

        Collections.sort(hints, (hint1, hint2) -> hint1.ordinal() - hint2.ordinal());

        if (hints.isEmpty()) {
            hints.add(NOTHING);
        }

        return hints;
    }

    private static void checkNumber(int target, List<Integer> list, int index, List<Hint> hints) {
        if (!list.contains(target)) {
            return;
        }

        hints.add(Objects.equals(target, list.get(index)) ? STRIKE : BALL);
    }

}
