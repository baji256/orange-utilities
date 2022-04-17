package org.bajiepka.orangeutilities.model

import java.time.LocalDate

data class TariffItem(
    val start: LocalDate,
    val end: LocalDate,
    val cost: Double,
    val isCurrent: Boolean
)