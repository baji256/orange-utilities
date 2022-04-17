package org.bajiepka.orangeutilities.model

enum class Currency(
    var code: Long,
    var label: String,
    var description: String
) {
    EUR(978L, "Euro", "Евро"),
    RUB(643L, "Russian ruble", "Российский рубль"),
    UAH(980L, "Ukrainian hryvna", "Украинская гривна"),
    USD(840L, "United States dollar", "Американский доллар");
}