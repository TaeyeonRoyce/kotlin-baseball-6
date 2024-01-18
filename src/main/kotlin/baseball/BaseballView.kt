package baseball

import camp.nextstep.edu.missionutils.Console


private const val INIT_GAME_MESSAGE = "숫자 야구 게임을 시작합니다."
private const val READ_USER_NUMBER_MESSAGE = "숫자를 입력해주세요 : "
private const val READ_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

fun printGameInitMessage() = println(INIT_GAME_MESSAGE)


fun readUserBaseballNumbers() = BaseballUserInput.from(
    print(READ_USER_NUMBER_MESSAGE).run {
        Console.readLine()
    }
)

fun printGameResult(gameResult: BaseballGameResult) = with(gameResult) {
    when {
        isNothing() -> println("낫싱")
        containsBall() && containsStrike() -> println("${ballCount}볼 ${strikeCount}스트라이크")
        containsBall() -> println("${ballCount}볼")
        containsStrike() -> println("${strikeCount}스트라이크")
        isStrikeOut() -> println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
}

fun readRestart() = BaseballRestartInput.from(
    println(READ_RESTART_MESSAGE).run {
        Console.readLine()
    }
)

fun printEndGame() = println("게임 종료")
