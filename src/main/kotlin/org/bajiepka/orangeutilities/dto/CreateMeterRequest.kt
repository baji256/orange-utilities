package org.bajiepka.orangeutilities.dto

import org.bajiepka.orangeutilities.dictionary.MunicipalUtilitiesType

data class CreateMeterRequest(
    val type: MunicipalUtilitiesType,
    val count: Int
)