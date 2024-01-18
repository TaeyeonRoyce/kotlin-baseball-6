package baseball

class BaseballGameResult(
    val strikeCount: Int,
    val ballCount: Int
) {

    fun isNothing(): Boolean {
        return strikeCount == 0 && ballCount == 0
    }

    fun isStrikeOut(): Boolean {
        return strikeCount == 3
    }

    fun containsBall(): Boolean {
        return ballCount > 0
    }

    fun containsStrike(): Boolean {
        return strikeCount > 0
    }
}
