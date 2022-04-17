package org.bajiepka.orangeutilities.service

import org.bajiepka.orangeutilities.dto.CreateMeterRequest
import org.bajiepka.orangeutilities.repository.MeterCountRepository
import org.springframework.stereotype.Service

@Service
class MeterCountService(
    private val meterCountRepository: MeterCountRepository
) {
    val allCount: List<CreateMeterRequest>
        get() = meterCountRepository.allCounts

    fun addNewMeterCount(dto: CreateMeterRequest): String {
        meterCountRepository.addNewCount(dto)
        return "Я создала новые показания"
    }
}