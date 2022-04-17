package org.bajiepka.orangeutilities.repository

import org.bajiepka.orangeutilities.dto.Price
import org.springframework.stereotype.Repository
import java.util.ArrayList

@Repository
class PriceRepository {
    private val prices: MutableList<Price> = ArrayList<Price>()
    val allPrices: List<Price>
        get() = prices

    fun addPrice(dto: Price) {
        prices.add(dto)
    }

    fun addAllPrices(prices: List<Price>?) {
        this.prices.addAll(prices!!)
    }

    fun deleteAllPrices() {
        prices.clear()
    }
}