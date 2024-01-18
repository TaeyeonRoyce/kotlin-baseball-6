package baseball

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BaseballNumbersTest {

    @Test
    fun `3자리가 아닐 경우 예외 발생`() {
        val numbers = listOf(1, 2)

        Assertions.assertThatThrownBy { BaseballNumbers(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("3개의 숫자여야 합니다.")
    }

    @Test
    fun `1부터 9 사이의 숫자가 아닌 경우 예외 발생`() {
        val numbers = listOf(1, 2, 10)

        Assertions.assertThatThrownBy { BaseballNumbers(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("모든 숫자는 1부터 9 사이여야 합니다.")
    }

    @Test
    fun `중복된 숫자가 존재하는 경우 예외 발생`() {
        val numbers = listOf(1, 2, 1)

        Assertions.assertThatThrownBy { BaseballNumbers(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자는 중복 될 수 없습니다.")
    }

    @Test
    fun `스트라이크 개수 계산 테스트`() {
        val baseballNumbers = BaseballNumbers(listOf(1, 2, 4))
        val userInput = BaseballNumbers(listOf(1, 2, 3))

        val result = baseballNumbers.compareWith(userInput)

        assertThat(result.strikeCount).isEqualTo(2)
    }

    @Test
    fun `볼 개수 계산 테스트`() {
        val baseballNumbers = BaseballNumbers(listOf(1, 2, 4))
        val userInput = BaseballNumbers(listOf(1, 3, 2))

        val result = baseballNumbers.compareWith(userInput)

        assertThat(result.ballCount).isEqualTo(1)
    }

    @Test
    fun `스트라이크와 볼이 없는 경우`() {
        val baseballNumbers = BaseballNumbers(listOf(1, 2, 4))
        val userInput = BaseballNumbers(listOf(3, 5, 6))

        val result = baseballNumbers.compareWith(userInput)

        assertThat(result.strikeCount).isEqualTo(0)
        assertThat(result.ballCount).isEqualTo(0)
    }

    @Test
    fun `스트라이크와 볼이 섞여있는 경우`() {
        val baseballNumbers = BaseballNumbers(listOf(1, 2, 4))
        val userInput = BaseballNumbers(listOf(1, 4, 2))

        val result = baseballNumbers.compareWith(userInput)

        assertThat(result.strikeCount).isEqualTo(1)
        assertThat(result.ballCount).isEqualTo(2)
    }
}
