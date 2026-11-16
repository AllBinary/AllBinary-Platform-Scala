/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. * III * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.customizer.includes.meta

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.Validation
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.dhtml.html.head.meta.HtmlMetaAttributeData
import _root_.org.allbinary.logic.visual.dhtml.html.head.meta.HtmlMetaAttributeDataFactory
import _root_.org.allbinary.logic.visual.dhtml.html.head.meta.HtmlMetaData
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class MetaValidation private () extends Validation with DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var label : String = null

    private var name : String = null

    private var httpEquiv : String = null

    private var content : String = null

    //new
    def this(htmlMetaAttributeData : HtmlMetaAttributeData, label : String, attributeValue : String, contentValue : String) = {
        this()
        this.label = label
        if (htmlMetaAttributeData.equals(HtmlMetaAttributeDataFactory.getInstance().HTTP_EQUIV)) {
            this.httpEquiv = attributeValue
        } else if (htmlMetaAttributeData.equals(HtmlMetaAttributeDataFactory.getInstance().NAME)) {
            this.name = attributeValue
        }
        this.content = contentValue
    }

    //from db
    def this(document : Document) = {
        this()
        throw new Exception(CommonStrings.getInstance().NOT_IMPLEMENTED)
    }

    /*    public GlobalsValidation(HashMap hashMap)    {           }      */
    override def isValid() : _root_.java.lang.Boolean = {
        try {
            var valid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            /*          if(!this.isValid().booleanValue() && !this.logo.isValid().booleanValue())          {             valid = Boolean.FALSE;          }          */
            return valid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put("Failed to validate form", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    override def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            /*          if(!this.isValid().booleanValue() && !this.isValid().booleanValue())          {             stringBuffer.append("Include a title or logo for the header.");          }          */
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Validating Form"
            }
        }
        throw new IllegalStateException()
    }

    override def toValidationInfoDoc() : Document = {
        return null
    }

    override def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        var htmlMetaAttributeDataFactory : HtmlMetaAttributeDataFactory = HtmlMetaAttributeDataFactory.getInstance()
        hashMap.put(HtmlMetaData.getInstance().LABEL.toString(), this.label)
        hashMap.put(htmlMetaAttributeDataFactory.NAME.toString(), this.name)
        hashMap.put(htmlMetaAttributeDataFactory.HTTP_EQUIV.toString(), this.httpEquiv)
        hashMap.put(htmlMetaAttributeDataFactory.CONTENT.toString(), this.content)
        return hashMap
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = ModDomHelper.createNameValueNodes(document, HtmlMetaData.getInstance().NAME.toString(), this.toHashMap())
        return node
    }

}


