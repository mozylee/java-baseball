package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.computer.Computer;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Computer computer = Computer.getInstance();
        while (true) {
            computer.startGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int answer = Integer.parseInt(readLine());
            if (answer == 2) {
                break;
            }
        }
    }

}
