/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom.document

import _root_.java.io.InputStream
import _root_.java.io.StringBufferInputStream
import _root_.javax.xml.parsers.DocumentBuilder
import _root_.javax.xml.parsers.DocumentBuilderFactory
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.w3c.dom.Document

class DomDocumentHelper private() {
    import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper.{*}

}

object DomDocumentHelper {
    def init() : Unit = {
        val commonPhoneStrings : CommonPhoneStrings = CommonPhoneStrings.getInstance()
        //System.setProperty("jdk.xml.maxElementDepth", "5000");        
        System.setProperty("jdk.xml.maxElementDepth", commonPhoneStrings.ZERO)
        //System.setProperty("jdk.xml.xpathExprGrpLimit", commonPhoneStrings.ZERO);
        System.setProperty("jdk.xml.xpathExprOpLimit", commonPhoneStrings.ZERO)
        //System.setProperty("jdk.xml.xpathTotalOpLimit", "0");
        System.setProperty("jdk.xml.xpathTotalOpLimit", commonPhoneStrings.ZERO)
        val LIMIT : String = "500000"
        System.setProperty("jdk.xml.maxGeneralEntitySizeLimit", LIMIT)
        System.setProperty("jdk.xml.totalEntitySizeLimit", LIMIT)
    }

    def create() : Document = {
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

    def create(inputStream : InputStream) : Document = {
        try {
            var factory : DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
            var builder : DocumentBuilder = factory.newDocumentBuilder()
            //Document document = builder.parse(xmlFile.getFile());
            var document : Document = builder.parse(inputStream)
            return document
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def create(xmlString : String) : Document = {
        try {
            var factory : DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
            var builder : DocumentBuilder = factory.newDocumentBuilder()
            var document : Document = builder.parse(new StringBufferInputStream(xmlString))
            return document
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


