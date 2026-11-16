/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.data

import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class TransformDocument() extends TransformDocumentInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var baseNode : Node = null

    private var document : Document = null

    //Constructor
    {
        try {
            this.document = DomDocumentHelper.create()
            var allbinaryNode : Node = this.document.createElement("allbinary")
            this.baseNode = allbinaryNode
            this.document.appendChild(this.baseNode)
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


