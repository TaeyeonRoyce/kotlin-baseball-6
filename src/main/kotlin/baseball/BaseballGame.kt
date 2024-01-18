package baseball

class BaseballGame(
    private val baseballNumberGenerator: BaseballNumberGenerator
) {

    private lateinit var computerBaseballNumber: BaseballNumbers

    init {
        printGameInitMessage()
    }

    fun play() {
        computerBaseballNumber = generateComputerNumbers()
        val userBaseballNumbers = BaseballNumbers(readUserBaseballNumbers().numbers)
        val gameResult = computerBaseballNumber.compareWith(userBaseballNumbers)
        printGameResult(gameResult)
    }

    private fun generateComputerNumbers(): BaseballNumbers = BaseballNumbers(
        baseballNumberGenerator.generateNumbersInRange(
            start = 1,
            end = 9,
            size = 3
        )
    )
}
