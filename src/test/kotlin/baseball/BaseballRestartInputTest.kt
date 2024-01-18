package baseball

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BaseballRestartInputTest {

    @Test
    fun `사용자 입력값이 1일 경우 true 반환`() {
        val userInput = "1"

        val restartInput = BaseballRestartInput.from(userInput)

        assertThat(restartInput.restart).isTrue()
    }

    @Test
    fun `사용자 입력값이 2일 경우 false 반환`() {
        val userInput = "2"

        val restartInput = BaseballRestartInput.from(userInput)

        assertThat(restartInput.restart).isFalse()
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "3", "restart", "exit"])
    fun `사용자 입력값이 1 또는 2가 아닐 경우 예외 발생`(userInput: String) {
        assertThatThrownBy { BaseballRestartInput.from(userInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("1 또는 2만 입력 가능합니다.")
    }
}
