package org.bajiepka.orangeutilities.repository

import org.bajiepka.orangeutilities.dto.CreateMeterRequest

interface IMeterCountRepository {

    val allCounts: List<Any>

    open fun addNewCount(newCount: CreateMeterRequest)
}