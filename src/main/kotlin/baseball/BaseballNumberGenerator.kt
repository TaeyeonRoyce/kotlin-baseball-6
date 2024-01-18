package baseball

interface BaseballNumberGenerator {

    fun generateNumbersInRange(start: Int, end: Int, size: Int): List<Int>
}
