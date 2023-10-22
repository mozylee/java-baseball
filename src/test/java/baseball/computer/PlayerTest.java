package baseball.computer;

import static baseball.constants.Message.EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    Player player;

    @BeforeEach
    void beforeEach() {
        player = Player.getInstance();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "789"})
    @DisplayName("플레이어는 3자리 정수를 입력할 수 있다.")
    void input(String givenString) throws Exception {
        // given

        // when
        List<Integer> result = player.input(givenString);

        // then
        assertThat(result).hasSize(3)
                          .containsExactlyInAnyOrderElementsOf(Arrays.stream(givenString.split(""))
                                                                     .map(Integer::parseInt)
                                                                     .toList());
    }

    @ParameterizedTest
    @ValueSource(strings = {"99", "1000"})
    @DisplayName("플레이어가 100 미만의 수를 입력하거나, 999 초과의 수를 입력하면 예외가 발생한다.")
    void input2(String givenString) throws Exception {
        // given

        // when // then
        assertThatIllegalArgumentException().isThrownBy(() -> player.input(givenString))
                                            .withMessage(EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"120", "980", "012"})
    @DisplayName("플레이어가 입력한 3자리 정수에 0이 포함되는 경우, 예외가 발생한다.")
    void input3(String givenString) throws Exception {
        // given

        // when // then
        assertThatIllegalArgumentException().isThrownBy(() -> player.input(givenString))
                                            .withMessage(EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"121", "989", "224"})
    @DisplayName("플레이어가 입력한 3자리 정수에 동일한 수가 존재하는 경우, 예외가 발생한다.")
    void input4(String givenString) throws Exception {
        // given

        // when // then
        assertThatIllegalArgumentException().isThrownBy(() -> player.input(givenString))
                                            .withMessage(EXCEPTION_MESSAGE);
    }

}