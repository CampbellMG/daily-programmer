package com.cmgcode.dailies.xml

import com.cmgcode.dailies.xml.data.XmlFile
import com.cmgcode.dailies.xml.data.XmlNode
import com.cmgcode.dailies.xml.pull.KXmlParser
import com.cmgcode.dailies.xml.pull.XmlPullParser
import java.io.FileInputStream

class Parser {

    var currentId = 0

    fun parseInputStream(uri: String): XmlFile {

        val xmlPullParser = KXmlParser()

        FileInputStream(uri).use {
            xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
            xmlPullParser.setInput(it, null)
            val nodeMap = parseNode(xmlPullParser)
            return XmlFile(
                    "",
                    nodeMap!!
            )
        }
    }


    private fun parseNode(parser: XmlPullParser, node: XmlNode? = null): XmlNode? {
        var currentNode = node

        do {
            when (parser.eventType) {
                XmlPullParser.START_TAG -> {
                    if (currentNode == null) {
                        currentNode = XmlNode(
                                currentId++,
                                parser.name ?: "",
                                null,
                                parser.getAttributes().toMutableMap(),
                                mutableListOf()
                        )

                    } else {
                        parseNode(parser)?.let {
                            currentNode.children.add(it)
                        }
                    }
                }
                XmlPullParser.TEXT -> currentNode?.value = parser.text
                XmlPullParser.END_TAG -> return currentNode
            }
        } while (parser.next() != XmlPullParser.END_DOCUMENT)

        return currentNode
    }

    fun XmlPullParser.getAttributes(): Map<String, String> =
            (0 until attributeCount)
                    .map {
                        (getAttributeName(it) ?: "") to (getAttributeValue(it) ?: "")
                    }
                    .toMap()


//    fun saveToOutputStream(serializer: XmlSerializer, outputStream: OutputStream, xmlFile: XmlFile) {
//        outputStream.use { _ ->
//            serializer.setOutput(outputStream, "UTF-8")
//            serializer.startDocument("UTF-8", true)
//            saveXmlNode(serializer, xmlFile.rootNode, xmlFile.nodeMap)
//            serializer.endDocument()
//            serializer.flush()
//        }
//    }
//
//    private fun saveXmlNode(serializer: XmlSerializer, currentNode: XmlNode, nodeMap: Map<Int, XmlNode>) {
//
//        serializer.startTag(null, currentNode.name)
//        currentNode.attributes.forEach {
//            serializer.attribute(null, it.name, it.value)
//        }
//        serializer.text(currentNode.value)
//        currentNode.children.forEach {
//            saveXmlNode(serializer, nodeMap[it]!!, nodeMap)
//        }
//        serializer.endTag(null, currentNode.name)
//
//    }
}
