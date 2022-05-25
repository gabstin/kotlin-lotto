package lotto

class Machine(private val purchasePrice: Int) {
    var lottoCount = 0
        private set

    var lottoList = emptyList<Lotto>()
        private set

    var lottoResultList = emptyList<LottoResult>()
        private set

    private fun List<Lotto>.checkResult(winningValue: String): List<LottoResult> {
        return this.map { LottoResult(winningValue, it) }
    }

    fun purchase() {
        lottoCount = purchasePrice / LOTTO_PRICE
        lottoList = (1..lottoCount).toList().map {
            Lotto(Extractor.getAutoNumbers())
        }
    }

    fun run(winningValue: String) {
        lottoResultList = lottoList.checkResult(winningValue)
    }


    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
