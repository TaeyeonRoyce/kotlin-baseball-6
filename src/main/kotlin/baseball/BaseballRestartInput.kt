package baseball

private const val INVALID_RESTART_MESSAGE = "1 또는 2만 입력 가능합니다."

class BaseballRestartInput private constructor(
    val restart: Boolean
) {

    companion object {
        fun from(input: String): BaseballRestartInput = when (input) {
            "1" -> BaseballRestartInput(true)
            "2" -> BaseballRestartInput(false)
            else -> throw IllegalArgumentException(INVALID_RESTART_MESSAGE)
        }
    }
}
