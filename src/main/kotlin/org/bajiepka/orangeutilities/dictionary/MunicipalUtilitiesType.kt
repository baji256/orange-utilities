package org.bajiepka.orangeutilities.dictionary

import org.bajiepka.orangeutilities.dictionary.MunicipalUtilityUnit.*

enum class MunicipalUtilitiesType(
    val alias: String,
    val priority: Int,
    val unit: MunicipalUtilityUnit
) {
    ENERGY("Электроэнергия", 1, KWH),
    GAZ("Газ", 3, CUBM),
    WATER("Водоснабжение", 2, CUBM),
    FLAT_RATE("Квартплата", 4, SQRM),
    TRASH_PICKUP("Вывоз мусора", 4, CUBM),
    COMPLETE_REPAIR("Капитальный ремонт", 4, SQRM);
}