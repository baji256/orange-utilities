package org.bajiepka.orangeutilities.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "available_currencies")
@Entity
data class CurrencyEntity(
    @Id
    @Column(name = "currency_code", nullable = false)
    val code: Int,
    @Column(name = "currency_name", nullable = false)
    val name: String,
    @Column(name = "currency_description", nullable = false)
    val description: String,
)
