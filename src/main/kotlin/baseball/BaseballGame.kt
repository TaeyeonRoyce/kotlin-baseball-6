package baseball

class BaseballGame(
    private val baseballNumberGenerator: BaseballNumberGenerator
) {

    private lateinit var computerBaseballNumber: BaseballNumbers

    init {
        printGameInitMessage()
    }

    fun play() {
        val userBaseballNumbers = BaseballNumbers(readUserBaseballNumbers().numbers)
        computerBaseballNumber = generateComputerNumbers()
        val gameResult = computerBaseballNumber.compareWith(userBaseballNumbers)
    }

    private fun generateComputerNumbers(): BaseballNumbers = BaseballNumbers(
        baseballNumberGenerator.generateNumbersInRange(
            start = 1,
            end = 9,
            size = 3
        )
    )
}
