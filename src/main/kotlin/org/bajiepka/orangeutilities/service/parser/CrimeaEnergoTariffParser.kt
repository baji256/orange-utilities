package org.bajiepka.orangeutilities.service.parser

import org.bajiepka.orangeutilities.model.EnergyItems
import org.bajiepka.orangeutilities.model.TariffItem
import org.springframework.stereotype.Component

@Component
class CrimeaEnergoTariffParser : AbstractSiteParser(SITE_URL) {
    fun parseSiteData(): EnergyItems {
        val document = document
        return EnergyItems(emptyList<TariffItem>())
    }

    companion object {
        private const val SITE_URL = "https://crimea-energy.ru/consumers/price/tariful-2"
    }
}