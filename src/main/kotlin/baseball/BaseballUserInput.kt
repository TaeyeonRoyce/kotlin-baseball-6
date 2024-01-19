package baseball

private const val CONTAINS_NON_NUMBER_INPUT = "입력값은 숫자만 포함해야 합니다."

class BaseballUserInput private constructor(
    val numbers: List<Int>
) {

    companion object {
        fun from(input: String): BaseballUserInput {
            val numbers = try {
                input.map { it.toString().toInt() }
            } catch (exception: NumberFormatException) {
                throw IllegalArgumentException(CONTAINS_NON_NUMBER_INPUT)
            }
            return BaseballUserInput(numbers)
        }
    }
}
