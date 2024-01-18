package baseball

import camp.nextstep.edu.missionutils.Console


private const val INIT_GAME_MESSAGE = "숫자 야구 게임을 시작합니다."
private const val READ_USER_NUMBER_MESSAGE = "숫자를 입력해주세요 : "

fun printGameInitMessage() = println(INIT_GAME_MESSAGE)


fun readUserBaseballNumbers() = BaseballUserInput.from(
    print(READ_USER_NUMBER_MESSAGE).run {
        Console.readLine()
    }
)

fun printGameResult(gameResult: BaseballGameResult) {
    with(gameResult) {
        if (isNothing()) {
            println("낫싱")
            return
        }
        if (isStrikeOut()) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return
        }
        if (containsBall()) {
            println("$ballCount 볼")
        }
        if (containsStrike()) {
            println("$strikeCount 스트라이크")
        }
    }
}

