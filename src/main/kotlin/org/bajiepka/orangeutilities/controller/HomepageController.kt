package org.bajiepka.orangeutilities.controller

import org.bajiepka.orangeutilities.service.CurrencyService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.time.LocalDateTime

@Controller
class HomepageController(
    private val currencyService: CurrencyService,
) {

    @GetMapping("/")
    fun homepage(model: Model): String {
        val ratesDate = LocalDateTime.now()
        model.addAttribute("ratesDate", ratesDate)
        model.addAttribute("currencyData", currencyService.availableCurrencies())
        model.addAttribute("currencyRates", currencyService.currencyRates(ratesDate))
        return "homepage"
    }
}