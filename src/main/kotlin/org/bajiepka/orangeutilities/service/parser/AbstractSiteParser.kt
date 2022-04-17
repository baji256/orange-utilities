package org.bajiepka.orangeutilities.service.parser

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.io.IOException
import java.lang.IllegalStateException
import java.util.*

abstract class AbstractSiteParser(private val url: String) {
    protected val document: Document
        protected get() = try {
            Jsoup.connect(url).get()
        } catch (e: IOException) {
            val message = "Could not connect to site: $url"
            throw IllegalStateException(message)
        }

    protected fun getNestedElement(elementCssQuery: String?, document: Document): Element {
        val element = document.select(elementCssQuery!!).first()
        return Optional
            .ofNullable(element)
            .orElseThrow { IllegalStateException("No nested elements found.") }
    }

    protected fun getFirstChildTextValue(element: Element): String {
        val node = element.childNodes().iterator().next()
        val (_, value) = node.attributes().iterator().next()
        return value
    }

    protected fun buildDivByIdQuery(divId: String): String {
        return "div[id=$divId]"
    }

    companion object {
        internal const val TABLE_ROW = "tr"
    }
}