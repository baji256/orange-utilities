package org.bajiepka.orangeutilities.util

import org.w3c.dom.Node
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*
import javax.xml.datatype.DatatypeFactory
import javax.xml.datatype.XMLGregorianCalendar

fun Node.text(index: Int) = childNodes.item(index).textContent

fun LocalDateTime.toXmlGregorianCalendar(): XMLGregorianCalendar {
    val gregorianCalendar = GregorianCalendar().apply {
        time = Date.from(toInstant(ZoneOffset.UTC))
    }

    return DatatypeFactory
        .newInstance()
        .newXMLGregorianCalendar(gregorianCalendar)
}