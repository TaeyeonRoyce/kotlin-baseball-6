package baseball

fun main() {

    val baseballGame = BaseballGame(
        baseballNumberGenerator =  RandomNumberGenerator()
    )

    baseballGame.play()
}
