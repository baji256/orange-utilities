package org.bajiepka.orangeutilities.service

import org.bajiepka.orangeutilities.dto.CreatePriceRequest
import org.bajiepka.orangeutilities.dto.Price
import org.bajiepka.orangeutilities.repository.PriceRepository
import org.springframework.stereotype.Service

@Service
class PriceService(
    private val priceRepository: PriceRepository
) {
    val prices: List<Price>
        get() = priceRepository.allPrices

    fun addPrice(dto: CreatePriceRequest): String {
        val price = Price(dto.price)
        priceRepository.addPrice(price)
        return "Цена добавлена"
    }

    fun deletePrices(): String {
        //  Мы пришли в этот метод и после того как сделаем очистку мы должны вернуть сообщение:
        //  1. Вызвать очистку
        //  2. Вернуть сообщение
        priceRepository.deleteAllPrices()
        return "Цены очищены."
    }
}