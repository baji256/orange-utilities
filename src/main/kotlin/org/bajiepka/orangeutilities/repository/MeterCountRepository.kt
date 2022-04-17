package org.bajiepka.orangeutilities.repository

import org.bajiepka.orangeutilities.dto.CreateMeterRequest
import org.springframework.stereotype.Repository

@Repository
class MeterCountRepository : IMeterCountRepository {
    private val counts: MutableList<CreateMeterRequest> = mutableListOf()

    override val allCounts: List<CreateMeterRequest>
        get() = counts

    override fun addNewCount(newCount: CreateMeterRequest) {
        counts.add(newCount)
    }
}