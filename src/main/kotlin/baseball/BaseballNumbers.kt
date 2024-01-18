package baseball

private const val INVALID_NUMBER_SIZE = "3개의 숫자여야 합니다."
private const val NOT_IN_RANGE_MESSAGE = "모든 숫자는 1부터 9 사이여야 합니다."
private const val NUMBER_DUPLICATION = "숫자는 중복 될 수 없습니다."

class BaseballNumbers(
    private val numbers: List<Int>
) {

    init {
        validateInput(numbers)
    }

    private fun validateInput(numbers: List<Int>) {
        require(numbers.size == 3) { INVALID_NUMBER_SIZE }
        require(numbers.all { it in 1..9 }) { NOT_IN_RANGE_MESSAGE }
        require(numbers.distinct().size == numbers.size) { NUMBER_DUPLICATION }
    }

    fun compareWith(other: BaseballNumbers): BaseballGameResult {
        val strikeCount = countStrike(other)
        val ballCount = countBall(other, strikeCount)
        return BaseballGameResult(
            strikeCount = strikeCount,
            ballCount = ballCount
        )
    }

    private fun countStrike(other: BaseballNumbers) =
        numbers.zip(other.numbers).count { (number, otherNumber) -> number == otherNumber }

    private fun countBall(other: BaseballNumbers, strikeCount: Int) =
        numbers.intersect(other.numbers.toSet()).count() - strikeCount
}
