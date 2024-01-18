package baseball

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class BaseballNumberTest {

    @ValueSource(ints = [0, 10, -3])
    @ParameterizedTest
    fun `생성 테스트`(number: Int) {
        assertThatThrownBy { BaseballNumber(number) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자는 1~9 사이만 가능합니다.")
    }
}

