package domain.store

import domain.lotto.Lotto
import domain.lotto.Lottos
import domain.lotto.PickType
import domain.money.Money

class LottoStore(val price: Money, private val lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()) {
    init {
        require(price > Money.ZERO)
    }

    fun buyLottos(money: Money, manualPicks: ManualPicks = ManualPicks(emptyList())): Lottos {
        val totalLottoCount = money.dividedBy(price)

        require(manualPicks.size <= totalLottoCount)

        val manualPickLottos = manualPicks.toLottos()
        val autoPickLottos = generateAutoPickLottos(size = totalLottoCount - manualPickLottos.size)

        return manualPickLottos + autoPickLottos
    }

    private fun generateAutoPickLottos(size: Long): Lottos = Lottos((1..size).map { generateLotto() })

    private fun generateLotto() = Lotto(lottoNumberGenerator.generate(), PickType.AUTO)
}
