package org.bajiepka.orangeutilities.model

data class CurrencyRateItem(
    val acronym: String,
    val rate: String,
    val description: String,
    val code: String,
    val quantity: String,
) {
    val currencyRate get() = String.format("%.3f", rate.toDouble() / quantity.toInt())
}