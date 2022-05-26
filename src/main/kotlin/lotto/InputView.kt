package lotto


object InputView {
    private const val NULL_MESSAGE = "입력값은 null일 수 없습니다."
    private const val NEGATIVE_NUMBER_MESSAGE = "입력값은 음수일 수 없습니다."

    fun getPurchaseMoney(): PurchaseMoney {
        println("구입 금액을 입력해 주세요.")

        val money = readLine()?.toInt()

        requireNotNull(money) { NULL_MESSAGE }

        return PurchaseMoney(money)
    }

    fun getWinningNumbers(): WinningLottoTicket {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val winningValue = readLine()
            ?.replace(" ", "")
            ?.split(",")
            ?.map { it.toIntOrNull() ?: throw IllegalArgumentException(NEGATIVE_NUMBER_MESSAGE) }
            ?.map { LottoNumber(it) }


        requireNotNull(winningValue) { NULL_MESSAGE }

        return WinningLottoTicket(winningValue)
    }
}
