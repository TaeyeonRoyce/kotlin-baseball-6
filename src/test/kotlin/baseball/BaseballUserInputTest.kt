package baseball

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

@SuppressWarnings("NonAsciiCharacters")
class BaseballUserInputTest {

    @Test
    fun `사용자 입력값이 숫자일 경우 BaseballUserInput 객체 생성`() {
        val userInput = "123"

        val baseballUserInput = BaseballUserInput.from(userInput)

        assertThat(baseballUserInput.numbers).isEqualTo(listOf(1, 2, 3))
    }

    @Test
    fun `사용자 입력값이 숫자가 아닐 경우 예외 발생`() {
        val userInput = "abc"

        assertThatThrownBy { BaseballUserInput.from(userInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력값은 숫자만 포함해야 합니다.")
    }
}




