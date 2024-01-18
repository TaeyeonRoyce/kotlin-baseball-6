package baseball

class BaseballNumbers(
    private val numbers: List<Int>
) {

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
