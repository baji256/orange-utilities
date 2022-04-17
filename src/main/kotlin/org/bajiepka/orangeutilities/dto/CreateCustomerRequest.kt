package org.bajiepka.orangeutilities.dto

data class CreateCustomerRequest(
    val name: String,
    val lastName: String,
    val postalCode: String,
    val clientAge: String
)