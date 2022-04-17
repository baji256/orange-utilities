package org.bajiepka.orangeutilities.integration.rest

import org.springframework.stereotype.Component
import ru.cbr.web.DailyInfo
import ru.cbr.web.GetCursOnDateXMLResponse
import javax.xml.datatype.XMLGregorianCalendar

@Component
class CbrClient {
    private val dailyService = DailyInfo().dailyInfoSoap

    fun getDailyCurrencyRates(
        xmlGregorianCalendar: XMLGregorianCalendar
    ): GetCursOnDateXMLResponse.GetCursOnDateXMLResult? = dailyService.getCursOnDateXML(xmlGregorianCalendar)
}