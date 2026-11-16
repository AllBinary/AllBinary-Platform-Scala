/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.customizer.page

import _root_.java.util.HashMap
import _root_.org.allbinary.business.page.PageData
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.Validation
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.title.TitleData
import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.title.TitleValidation
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class PageValidation() extends Validation with DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var title : TitleValidation = null

    //Constructor
    {
        this.title = new TitleValidation()
    }

    def this(document : Document) = {
        this()
        var node : Node = DomSearchHelper.getNode(TitleData.getInstance().NAME, document.getElementsByTagName(PageData.getInstance().NAME))
        this.title = new TitleValidation(node)
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        this.getFormData(hashMap)
    }

    def getFormData(hashMap : HashMap[Object, Object]) : Unit = {
        this.title = new TitleValidation(hashMap)
    }

    override def isValid() : _root_.java.lang.Boolean = {
        try {
            var valid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("PageValidation", this, this.commonStrings.IS_VALID)
            }
            if (!this.title.isValid().booleanValue()) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("PageValidation: " + valid, this, this.commonStrings.IS_VALID)
            }
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
            if (!this.title.isValid().booleanValue()) {
                stringBuffer.append(this.title.validationInfo())
            }
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

    def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(PageData.getInstance().NAME)
        node.appendChild(this.title.toXmlNode(document))
        return node
    }

}


