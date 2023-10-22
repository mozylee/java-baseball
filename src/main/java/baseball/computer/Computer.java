package baseball.computer;

import static baseball.computer.hint.Hint.STRIKE;
import static baseball.constants.Count.NUMBER_SIZE;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import baseball.computer.hint.Hint;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Computer {

    private final Number number = Number.getInstance();

    private final Player player = Player.getInstance();

    public void startGame() {
        number.initNumbers();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> playerNumbers = getPlayerInput();
            List<Hint> hints = Judgement.judge(number.getNumbers(), playerNumbers);

            if (printHint(hints)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private boolean printHint(List<Hint> hints) {
        Map<Hint, Long> hintMap = hints.stream()
                                       .collect(groupingBy(identity(), counting()));
        System.out.println(hintMap.keySet()
                                  .stream()
                                  .map(k -> k.getPrintableString(hintMap.get(k).intValue()))
                                  .collect(Collectors.joining(" ")));

        return hints.size() == NUMBER_SIZE && hints.get(0) == STRIKE;
    }

    private List<Integer> getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");

        return player.input(readLine());
    }

    // Singleton
    private static Computer instance;

    private Computer() {
    }

    public static Computer getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Computer();
        }

        return instance;
    }

}
