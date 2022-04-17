package org.bajiepka.orangeutilities.service

import mu.KLogging
import org.bajiepka.orangeutilities.entity.CurrencyEntity
import org.bajiepka.orangeutilities.integration.rest.CbrClient
import org.bajiepka.orangeutilities.model.CurrencyItem
import org.bajiepka.orangeutilities.model.CurrencyRateItem
import org.bajiepka.orangeutilities.repository.AvailableCurrenciesRepository
import org.bajiepka.orangeutilities.util.toCurrencyRateItem
import org.bajiepka.orangeutilities.util.toXmlGregorianCalendar
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.w3c.dom.Element
import java.time.LocalDateTime

@Service
class CurrencyService(
    private val cbrClient: CbrClient,
    private val availableCurrenciesRepository: AvailableCurrenciesRepository,
) {
    fun availableCurrencies(): List<CurrencyItem> {
        val availableCurrencies = availableCurrenciesRepository
            .findAll(Sort.by("code"))
            .map(CurrencyEntity::toCurrencyRateItem)

        return availableCurrencies
    }

    fun currencyRates(rateDateTime: LocalDateTime): List<CurrencyRateItem> {

        val valueData = cbrClient.getDailyCurrencyRates(rateDateTime.toXmlGregorianCalendar())
            ?.content
            ?.firstOrNull() as Element

        val currencies = valueData.getElementsByTagName(CBR_CURRENCY_TAG_NAME)

        return (0 until currencies.length)
            .map { index -> currencies.item(index) }
            .mapNotNull { it.toCurrencyRateItem() }
            .sortedWith(compareBy(CurrencyRateItem::acronym))
    }

    companion object : KLogging() {
        private const val CBR_CURRENCY_TAG_NAME = "ValuteCursOnDate"
    }
}