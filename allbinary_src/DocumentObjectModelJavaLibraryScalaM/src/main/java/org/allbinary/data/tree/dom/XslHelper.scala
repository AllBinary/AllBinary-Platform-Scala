/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom

import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.File
import _root_.java.io.OutputStream
import _root_.java.io.StringBufferInputStream
import _root_.javax.xml.transform.Templates
import _root_.javax.xml.transform.Transformer
import _root_.javax.xml.transform.TransformerFactory
import _root_.javax.xml.transform.URIResolver
import _root_.javax.xml.transform.stream.StreamResult
import _root_.javax.xml.transform.stream.StreamSource
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.w3c.dom.Document

//import org.allbinary.data.tree.dom.document.DomDocumentHelper;
class XslHelper private() {
    import _root_.org.allbinary.data.tree.dom.XslHelper.{*}

    def translate(xsltStreamSource : StreamSource, xmlStreamSource : StreamSource, streamResult : StreamResult) : OutputStream = {
        try {
            //TWB - GAE needed xalan.jar and serializer.jar
            val transformerFactory : TransformerFactory = TransformerFactory.newInstance()
            val transformer : Transformer = transformerFactory.newTransformer(xsltStreamSource)
            transformer.transform(xmlStreamSource, streamResult)
            return streamResult.getOutputStream()
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def translate(resolver : URIResolver, xsltStreamSource : StreamSource, xmlStreamSource : StreamSource, streamResult : StreamResult) : OutputStream = {
        try {
            //TWB - GAE needed xalan.jar and serializer.jar
            val tFactory : TransformerFactory = TransformerFactory.newInstance()
            tFactory.setURIResolver(resolver)
            val transformer : Transformer = tFactory.newTransformer(xsltStreamSource)
            //transformer.setURIResolver(resolver);
            transformer.transform(xmlStreamSource, streamResult)
            return streamResult.getOutputStream()
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def translateTemplate(templates : Templates, xmlStreamSource : StreamSource) : String = {
        try {
            val outputStream : ByteArrayOutputStream = new ByteArrayOutputStream()
            val streamResult : StreamResult = new StreamResult(outputStream)
            templates.newTransformer().transform(xmlStreamSource, streamResult)
            return streamResult.getOutputStream().toString()
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def translate(xsltStreamSource : StreamSource, xmlDocument : Document) : String = {
        try {
            val outputStream : ByteArrayOutputStream = new ByteArrayOutputStream()
            return this.translate(xsltStreamSource, new StreamSource(new StringBufferInputStream(XmlDocumentHelper.toString(xmlDocument))), new StreamResult(outputStream)).toString()
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def translate(xsltStreamSource : StreamSource, xmlStreamSource : StreamSource) : String = {
        try {
            val outputStream : ByteArrayOutputStream = new ByteArrayOutputStream()
            return this.translate(xsltStreamSource, xmlStreamSource, new StreamResult(outputStream)).toString()
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def translate(resolver : URIResolver, xsltStreamSource : StreamSource, xmlStreamSource : StreamSource) : String = {
        try {
            val outputStream : ByteArrayOutputStream = new ByteArrayOutputStream()
            return this.translate(resolver, xsltStreamSource, xmlStreamSource, new StreamResult(outputStream)).toString()
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def `export`(outputFile : File, xsltFilePath : String, xmlDocument : Document) : Unit = {
        try {
            outputFile.createNewFile()
            this.translate(new StreamSource(xsltFilePath), new StreamSource(new StringBufferInputStream(XmlDocumentHelper.toString(xmlDocument))), new StreamResult(outputFile))
        } catch {
            case e : Exception => {
                throw e
            }
        }
    }

}

object XslHelper {
    private val instance : XslHelper = new XslHelper()

    /**      * @return the instance      */
    def getInstance() : XslHelper = {
        return XslHelper.instance
    }

}


