package org.bajiepka.orangeutilities.service

import org.bajiepka.orangeutilities.dto.CreateMeterRequest
import org.bajiepka.orangeutilities.dto.Price
import org.springframework.stereotype.Service

@Service
class SumService(
    private val meterCountService: MeterCountService,
    private val priceService: PriceService
) {
    fun calculateMeterSum(): Int {
        val allMeters: List<CreateMeterRequest> = meterCountService.allCount
        val allPrices: List<Price> = priceService.prices
        val lastPrice: Price = allPrices[allPrices.size - 1]
        var sum = 0
        for (meter in allMeters) {
            sum += meter.count * lastPrice.value
        }
        return sum
    }
}