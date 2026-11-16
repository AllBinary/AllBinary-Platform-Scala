/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.customizer.hedges.heading

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.Validation
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.logo.LogoData
import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.logo.LogoValidation
import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.title.TitleData
import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.title.TitleValidation
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class HeadingValidation() extends Validation with DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var title : TitleValidation = null

    private var logo : LogoValidation = null

    //Constructor
    {
        this.title = new TitleValidation()
        this.logo = new LogoValidation()
    }

    def this(document : Document) = {
        this()
        var headingNodeList : NodeList = document.getElementsByTagName(HeadingData.NAME)
        var titleNode : Node = DomSearchHelper.getNode(TitleData.getInstance().NAME, headingNodeList.item(0).getChildNodes())
        var logoNode : Node = DomSearchHelper.getNode(LogoData.getInstance().NAME, headingNodeList.item(0).getChildNodes())
        this.title = new TitleValidation(titleNode)
        this.logo = new LogoValidation(logoNode)
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        this.getFormData(hashMap)
    }

    def getFormData(hashMap : HashMap[Object, Object]) : Unit = {
        this.title = new TitleValidation(hashMap)
        this.logo = new LogoValidation(hashMap)
    }

    override def isValid() : _root_.java.lang.Boolean = {
        try {
            var valid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            var titleValid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            var logoValid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.IS_VALID)
            }
            if (!this.title.isValid().booleanValue()) {
                titleValid = _root_.java.lang.Boolean.FALSE
            }
            if (!this.logo.isValid().booleanValue()) {
                logoValid = _root_.java.lang.Boolean.FALSE
            } else {
                this.logo.processLogoFile()
            }
            if (!titleValid.booleanValue() && !logoValid.booleanValue()) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("HeadingValidation: " + valid, this, this.commonStrings.IS_VALID)
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
            var valid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            var titleValid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            var logoValid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            var stringBuffer : StringMaker = new StringMaker()
            if (!this.title.isValid().booleanValue()) {
                titleValid = _root_.java.lang.Boolean.FALSE
            }
            if (!this.logo.isValid().booleanValue()) {
                logoValid = _root_.java.lang.Boolean.FALSE
            }
            if (!titleValid.booleanValue() && !logoValid.booleanValue()) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            if (!valid.booleanValue()) {
                stringBuffer.append("Include a title and/or logo for the header.")
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
        var node : Node = document.createElement(HeadingData.NAME)
        node.appendChild(this.logo.toXmlNode(document))
        node.appendChild(this.title.toXmlNode(document))
        return node
    }

}


