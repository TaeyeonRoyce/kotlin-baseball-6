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

