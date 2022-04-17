package org.bajiepka.orangeutilities.repository

import org.bajiepka.orangeutilities.entity.CurrencyEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface AvailableCurrenciesRepository : PagingAndSortingRepository<CurrencyEntity, Int>