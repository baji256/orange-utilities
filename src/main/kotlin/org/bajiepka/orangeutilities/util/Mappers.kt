package org.bajiepka.orangeutilities.util

import org.bajiepka.orangeutilities.entity.CurrencyEntity
import org.bajiepka.orangeutilities.model.CurrencyItem
import org.bajiepka.orangeutilities.model.CurrencyRateItem
import org.w3c.dom.Node

private const val CBR_DESCRIPTION_INDEX = 0
private const val CBR_RATE_INDEX = 2
private const val CBR_CODE_INDEX = 3
private const val CBR_QUANTITY_INDEX = 1
private const val CBR_ACRONYM_INDEX = 4

fun CurrencyEntity.toCurrencyRateItem() = with(this) {
    CurrencyItem(
        id = code,
        name = name,
        description = description
    )
}

fun Node.toCurrencyRateItem() = CurrencyRateItem(
    acronym = text(CBR_ACRONYM_INDEX),
    code = text(CBR_CODE_INDEX),
    description = text(CBR_DESCRIPTION_INDEX),
    rate = text(CBR_RATE_INDEX),
    quantity = text(CBR_QUANTITY_INDEX),
)