/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom.document

import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.StringReader
import _root_.java.io.StringWriter
import _root_.java.io.Writer
import _root_.javax.xml.parsers.DocumentBuilderFactory
import _root_.javax.xml.transform.OutputKeys
import _root_.javax.xml.transform.Transformer
import _root_.javax.xml.transform.TransformerConfigurationException
import _root_.javax.xml.transform.TransformerFactory
import _root_.javax.xml.transform.dom.DOMSource
import _root_.javax.xml.transform.stream.StreamResult
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.java.characters.CharacterSetData
import _root_.org.w3c.dom.Document
import _root_.org.xml.sax.InputSource

/**  *  * @author User  */
class XmlDocumentHelper private() {
    import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val INDENT_NUMBER : String = "indent-number"

    private var indent : Int = 0

    private var ignoreDeclaration : Boolean = false

    //Constructor
    {
        this.init(4, true)
    }

    def init(indent : Int, ignoreDeclaration : Boolean) : Unit = this.synchronized {
        this.indent = indent
        this.ignoreDeclaration = ignoreDeclaration
    }

    private def createTransformer(indent : Int, ignoreDeclaration : Boolean) : Transformer = {
        val booleanFactory : BooleanFactory = BooleanFactory.getInstance()
        val transformerFactory : TransformerFactory = TransformerFactory.newInstance()
        transformerFactory.setAttribute(this.INDENT_NUMBER, Integer.valueOf(indent))
        val transformer : Transformer = transformerFactory.newTransformer()
        transformer.setOutputProperty(OutputKeys.ENCODING, CharacterSetData.getInstance().UTF_8)
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, (if (ignoreDeclaration) booleanFactory.YES else booleanFactory.NO))
        transformer.setOutputProperty(OutputKeys.INDENT, booleanFactory.YES)
        return transformer
    }

    def createTransformer() : Transformer = {
        var currentIndent : Int = 0
        var currentIgnoreDeclaration : Boolean = false
        this.synchronized {
            currentIndent = this.indent
            currentIgnoreDeclaration = this.ignoreDeclaration
        }
        return this.createTransformer(currentIndent, currentIgnoreDeclaration)
    }

    def format(xmlString : String) : String = {
        return this.formatWithTransformer(xmlString, this.createTransformer())
    }

    def formatWithTransformer(xmlString : String, transformer : Transformer) : String = {
        val src : InputSource = new InputSource(new StringReader(xmlString))
        val document : Document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src)
        val out : Writer = new StringWriter()
        transformer.transform(new DOMSource(document), new StreamResult(out))
        return out.toString()
    }

}

object XmlDocumentHelper {
    private val instance : XmlDocumentHelper = new XmlDocumentHelper()

    /**      * @return the instance      */
    def getInstance() : XmlDocumentHelper = {
        return XmlDocumentHelper.instance
    }

    def toString(document : Document) : String = {
        try {
            val domSource : DOMSource = new DOMSource(document)
            val byteArrayOutputStream : ByteArrayOutputStream = new ByteArrayOutputStream()
            val streamResult : StreamResult = new StreamResult(byteArrayOutputStream)
            val copyTransformerFactory : TransformerFactory = TransformerFactory.newInstance()
            val copyTransformer : Transformer = copyTransformerFactory.newTransformer()
            copyTransformer.transform(domSource, streamResult)
            return byteArrayOutputStream.toString()
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


