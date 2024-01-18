package baseball

private const val CONTAINS_NON_NUMBER_INPUT = "입력값은 숫자만 포함해야 합니다."
private const val INVALID_NUMBER_SIZE = "3개의 숫자여야 합니다."
private const val NOT_IN_RANGE_MESSAGE = "모든 숫자는 1부터 9 사이여야 합니다."
private const val NUMBER_DUPLICATION = "숫자는 중복 될 수 없습니다."



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
            validateInput(numbers)
            return BaseballUserInput(numbers)
        }

        private fun validateInput(numbers: List<Int>) {
            require(numbers.size == 3) { INVALID_NUMBER_SIZE }
            require(numbers.all { it in 1..9 }) { NOT_IN_RANGE_MESSAGE }
            require(numbers.distinct().size == numbers.size) { NUMBER_DUPLICATION }
        }
    }
}
