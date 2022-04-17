package org.bajiepka.orangeutilities.repository

import org.bajiepka.orangeutilities.entity.Customer
import org.springframework.stereotype.Repository

@Repository
class CustomerRepository {
    private val customers: MutableList<Customer> = ArrayList()
    val abonentById: List<Customer>
        get() = customers

    fun save(customer: Customer): String {
        customer.id = customers.size.toString()
        customers.add(customer)
        return customer.id
    }
}