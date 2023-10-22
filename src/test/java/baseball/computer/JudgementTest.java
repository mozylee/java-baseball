package baseball.computer;

import static baseball.computer.hint.Hint.BALL;
import static baseball.computer.hint.Hint.NOTHING;
import static baseball.computer.hint.Hint.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.computer.hint.Hint;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgementTest {

    @Test
    @DisplayName("입력한 수에 대해 같은 수가 자리에 있으면 스트라이크이다.")
    void judge() throws Exception {
        // given
        List<Integer> playerNumbers = List.of(9, 8, 3);
        List<Integer> computerNumbers = List.of(1, 2, 3);

        // when
        List<Hint> result = Judgement.judge(computerNumbers, playerNumbers);

        // then
        assertThat(result).hasSize(1)
                          .containsExactlyInAnyOrder(STRIKE);
    }

    @Test
    @DisplayName("입력한 수에 대해 같은 수가 다른 자리에 있으면 볼이다.")
    void judge2() throws Exception {
        // given
        List<Integer> playerNumbers = List.of(9, 8, 1);
        List<Integer> computerNumbers = List.of(1, 2, 3);

        // when
        List<Hint> result = Judgement.judge(computerNumbers, playerNumbers);

        // then
        assertThat(result).hasSize(1)
                          .containsExactlyInAnyOrder(BALL);
    }

    @Test
    @DisplayName("입력한 수에 대해 같은 수가 전혀 없으면 낫싱이다.")
    void judge3() throws Exception {
        // given
        List<Integer> playerNumbers = List.of(9, 8, 7);
        List<Integer> computerNumbers = List.of(1, 2, 3);

        // when
        List<Hint> result = Judgement.judge(computerNumbers, playerNumbers);

        // then
        assertThat(result).hasSize(1)
                          .containsExactlyInAnyOrder(NOTHING);
    }

}