package baseball

class BaseballGame(
    private val baseballNumberGenerator: BaseballNumberGenerator
) {

    private lateinit var computerBaseballNumber: BaseballNumbers

    init {
        printGameInitMessage()
    }

    fun play() {
        do {
            computerBaseballNumber = generateComputerNumbers()
            playSingleGame()
        } while (readRestart().restart)
        printEndGame()
    }

    private fun playSingleGame() {
        do {
            val userBaseballNumbers = BaseballNumbers(readUserBaseballNumbers().numbers)
            val gameResult = computerBaseballNumber.compareWith(userBaseballNumbers)
            printGameResult(gameResult)
        } while (!gameResult.isStrikeOut())
    }

    private fun generateComputerNumbers(): BaseballNumbers = BaseballNumbers(
        baseballNumberGenerator.generateNumbersInRange(
            start = 1,
            end = 9,
            size = 3
        )
    )
}
