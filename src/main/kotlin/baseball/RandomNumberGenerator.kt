package baseball

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : BaseballNumberGenerator {

    override fun generateNumbersInRange(start: Int, end: Int, size: Int): List<Int> {
        val numbers = mutableSetOf<Int>()
        while (numbers.size < size) {
            numbers.add(Randoms.pickNumberInRange(start, end))
        }
        return numbers.toList()
    }
}
