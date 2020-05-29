package com.cmgcode.dailies.xml.pull

import java.io.IOException
import java.io.InputStream
import java.io.Reader

interface XmlPullParser {
    @Throws(XmlPullParserException::class)
    fun setFeature(var1: String?, var2: Boolean)
    fun getFeature(var1: String?): Boolean

    @Throws(XmlPullParserException::class)
    fun setProperty(var1: String?, var2: Any?)
    fun getProperty(var1: String?): Any?

    @Throws(XmlPullParserException::class)
    fun setInput(var1: Reader?)

    @Throws(XmlPullParserException::class)
    fun setInput(var1: InputStream?, var2: String?)
    val inputEncoding: String?

    @Throws(XmlPullParserException::class)
    fun defineEntityReplacementText(var1: String?, var2: String?)

    @Throws(XmlPullParserException::class)
    fun getNamespaceCount(var1: Int): Int

    @Throws(XmlPullParserException::class)
    fun getNamespacePrefix(var1: Int): String?

    @Throws(XmlPullParserException::class)
    fun getNamespaceUri(var1: Int): String?
    fun getNamespace(var1: String?): String?
    val depth: Int
    val positionDescription: String?
    val lineNumber: Int
    val columnNumber: Int

    @get:Throws(XmlPullParserException::class)
    val isWhitespace: Boolean
    val text: String?
    fun getTextCharacters(var1: IntArray?): CharArray?
    val namespace: String?
    val name: String?
    val prefix: String?

    @get:Throws(XmlPullParserException::class)
    val isEmptyElementTag: Boolean
    val attributeCount: Int
    fun getAttributeNamespace(var1: Int): String?
    fun getAttributeName(var1: Int): String?
    fun getAttributePrefix(var1: Int): String?
    fun getAttributeType(var1: Int): String?
    fun isAttributeDefault(var1: Int): Boolean
    fun getAttributeValue(var1: Int): String?
    fun getAttributeValue(var1: String?, var2: String?): String?

    @get:Throws(XmlPullParserException::class)
    val eventType: Int

    @Throws(XmlPullParserException::class, IOException::class)
    operator fun next(): Int

    @Throws(XmlPullParserException::class, IOException::class)
    fun nextToken(): Int

    @Throws(XmlPullParserException::class, IOException::class)
    fun require(var1: Int, var2: String?, var3: String?)

    @Throws(XmlPullParserException::class, IOException::class)
    fun nextText(): String?

    @Throws(XmlPullParserException::class, IOException::class)
    fun nextTag(): Int

    companion object {
        const val NO_NAMESPACE = ""
        const val START_DOCUMENT = 0
        const val END_DOCUMENT = 1
        const val START_TAG = 2
        const val END_TAG = 3
        const val TEXT = 4
        const val CDSECT = 5
        const val ENTITY_REF = 6
        const val IGNORABLE_WHITESPACE = 7
        const val PROCESSING_INSTRUCTION = 8
        const val COMMENT = 9
        const val DOCDECL = 10
        val TYPES = arrayOf("START_DOCUMENT", "END_DOCUMENT", "START_TAG", "END_TAG", "TEXT", "CDSECT", "ENTITY_REF", "IGNORABLE_WHITESPACE", "PROCESSING_INSTRUCTION", "COMMENT", "DOCDECL")
        const val FEATURE_PROCESS_NAMESPACES = "http://xmlpull.org/v1/doc/features.html#process-namespaces"
        const val FEATURE_REPORT_NAMESPACE_ATTRIBUTES = "http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes"
        const val FEATURE_PROCESS_DOCDECL = "http://xmlpull.org/v1/doc/features.html#process-docdecl"
        const val FEATURE_VALIDATION = "http://xmlpull.org/v1/doc/features.html#validation"
    }
}
