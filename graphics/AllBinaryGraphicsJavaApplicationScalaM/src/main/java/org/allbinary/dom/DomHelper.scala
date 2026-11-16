/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.dom

import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.File
import _root_.javax.xml.parsers.DocumentBuilder
import _root_.javax.xml.parsers.DocumentBuilderFactory
import _root_.javax.xml.transform.Transformer
import _root_.javax.xml.transform.TransformerFactory
import _root_.javax.xml.transform.dom.DOMSource
import _root_.javax.xml.transform.stream.StreamResult
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class DomHelper private() {
    import _root_.org.allbinary.dom.DomHelper.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def createDocument() : Document = {
        try {
            var factory : DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
            var builder : DocumentBuilder = factory.newDocumentBuilder()
            var document : Document = builder.newDocument()
            return document
        } catch {
            case e : Exception => {
                return null
            }
        }
        throw new IllegalStateException()
    }

    def createDocument(xmlFile : File) : Document = {
        try {
            var factory : DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
            var builder : DocumentBuilder = factory.newDocumentBuilder()
            var document : Document = builder.parse(xmlFile)
            return document
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def toString(document : Document) : String = {
        try {
            var domSource : DOMSource = new DOMSource(document)
            var byteArrayOutputStream : ByteArrayOutputStream = new ByteArrayOutputStream()
            var streamResult : StreamResult = new StreamResult(byteArrayOutputStream)
            var copyTransformerFactory : TransformerFactory = TransformerFactory.newInstance()
            var copyTransformer : Transformer = copyTransformerFactory.newTransformer()
            copyTransformer.transform(domSource, streamResult)
            return byteArrayOutputStream.toString()
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def save(file : File, document : Document) : Unit = {
        try {
            var copyTransformerFactory : TransformerFactory = TransformerFactory.newInstance()
            var copyTransformer : Transformer = copyTransformerFactory.newTransformer()
            var domSource : DOMSource = new DOMSource(document)
            file.createNewFile()
            var streamResult : StreamResult = new StreamResult(file)
            copyTransformer.transform(domSource, streamResult)
        } catch {
            case e : Exception => {
                throw e
            }
        }
    }

    def getChildNodeList(nodeName : String, nodeList : NodeList) : NodeList = {
        var numberOfNodes : Int = nodeList.getLength()

        {
            var index : Int = 0
            while (index < numberOfNodes) {
                var node : Node = nodeList.item(index)
                if (node.getNodeName().compareTo(nodeName) == 0) {
                    return node.getChildNodes()
                }
                index += 1
            }
        }
        throw new Exception(nodeName + " Node Not Found")
    }

    def getChildrenWithoutTextNodes(nodeName : String, nodeList : NodeList) : BasicArrayList = {
        var list : BasicArrayList = new BasicArrayListD()
        var childNodeList : NodeList = this.getChildNodeList(nodeName, nodeList)
        var numberOfChildren : Int = childNodeList.getLength()

        {
            var index : Int = 0
            while (index < numberOfChildren) {
                var node : Node = childNodeList.item(index)
                if (node.getNodeType() != Node.TEXT_NODE) {
                    list.add(node)
                }
                index += 1
            }
        }
        return list
    }

    def getWithoutTextNodes(nodeList : NodeList) : BasicArrayList = {
        var list : BasicArrayList = new BasicArrayListD()
        var numberOfChildren : Int = nodeList.getLength()

        {
            var index : Int = 0
            while (index < numberOfChildren) {
                var node : Node = nodeList.item(index)
                if (node.getNodeType() != Node.TEXT_NODE) {
                    list.add(node)
                }
                index += 1
            }
        }
        return list
    }

    def searchNodeList(nodeName : String, nodeList : NodeList) : Node = {
        var numberOfNodes : Int = nodeList.getLength()

        {
            var index : Int = 0
            while (index < numberOfNodes) {
                var node : Node = nodeList.item(index)
                this.logUtil.putF("NodeName: " + node.getNodeName(), this, "searchNodeList")
                if (node.getNodeName().compareTo(nodeName) == 0) {
                    return node
                }
                index += 1
            }
        }
        throw new Exception(nodeName + " Node Not Found in search")
    }

    def searchNodeList(nodeName : String, nodeList : BasicArrayList) : Node = {
        var numberOfNodes : Int = nodeList.size()

        {
            var index : Int = 0
            while (index < numberOfNodes) {
                var node : Node = nodeList.get(index).asInstanceOf[Node]
                this.logUtil.putF("NodeName: " + node.getNodeName(), this, "searchNodeList")
                if (node.getNodeName().compareTo(nodeName) == 0) {
                    return node
                }
                index += 1
            }
        }
        throw new Exception(nodeName + " Node Not Found in search")
    }

}

object DomHelper {
    private val instance : DomHelper = new DomHelper()

    /**      * @return the instance      */
    def getInstance() : DomHelper = {
        return DomHelper.instance
    }

}


