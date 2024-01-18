package baseball

class BaseballGame(
    private val baseballNumberGenerator: BaseballNumberGenerator
) {

    private lateinit var baseballNumbers: BaseballNumbers

    init {
        printGameInitMessage()
    }

    fun play() {
        val userNumbers = readUserBaseballNumbers()
        baseballNumbers = generateComputerNumbers()

    }

    private fun generateComputerNumbers(): BaseballNumbers = BaseballNumbers(
        baseballNumberGenerator.generateNumbersInRange(
            start = 1,
            end = 9,
            size = 3
        )
    )
}
