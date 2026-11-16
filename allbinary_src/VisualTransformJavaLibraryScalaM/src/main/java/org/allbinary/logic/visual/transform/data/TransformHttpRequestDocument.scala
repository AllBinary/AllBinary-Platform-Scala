/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.data

import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.http.AcceptableResponseGenerator
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.search.SearchRequest
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class TransformHttpRequestDocument private () extends TransformDocumentInterface {
    import _root_.org.allbinary.logic.visual.transform.data.TransformHttpRequestDocument.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var baseNode : Node = null

    private var document : Document = null

    def this(pageContext : PageContext, weblisketSession : WeblisketSession) = {
        this()
        try {
            var contentType : String = AcceptableResponseGenerator.getInstance().get(pageContext.getRequest().asInstanceOf[HttpServletRequest])
            this.document = DomDocumentHelper.create()
            var contentTypeNode : Node = this.document.createElement(contentType)
            var languageTypeNode : Node = this.document.createElement(language)
            var localTypeNode : Node = this.document.createElement(local)
            this.baseNode = localTypeNode
            languageTypeNode.appendChild(localTypeNode)
            contentTypeNode.appendChild(languageTypeNode)
            this.document.appendChild(contentTypeNode)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                this.logUtil.putF(this.log(), this, this.commonStrings.CONSTRUCTOR)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
                }
                throw e
            }
        }
    }

    def this(searchRequest : SearchRequest) = {
        this()
        try {
            var contentType : String = searchRequest.getContentType()
            this.document = DomDocumentHelper.create()
            var contentTypeNode : Node = this.document.createElement(contentType)
            var languageTypeNode : Node = this.document.createElement(language)
            var localTypeNode : Node = this.document.createElement(local)
            this.baseNode = localTypeNode
            languageTypeNode.appendChild(localTypeNode)
            contentTypeNode.appendChild(languageTypeNode)
            this.document.appendChild(contentTypeNode)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
                }
                throw e
            }
        }
    }

    def getBaseNode() : Node = {
        return this.baseNode
    }

    def getDoc() : Document = {
        return this.document
    }

    def log() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        if (this.baseNode != null) {
            stringBuffer.append("BaseNode: ")
            stringBuffer.append(this.baseNode.getNodeName())
        } else {
            stringBuffer.append("Log-Error: BaseNode is Null")
        }
        stringBuffer.append("\nDocument: ")
        stringBuffer.append(XmlDocumentHelper.toString(this.document))
        return stringBuffer.toString()
    }

}

object TransformHttpRequestDocument {
    //language_country = en_US
    private val language : String = "en"

    private val local : String = "US"

}


