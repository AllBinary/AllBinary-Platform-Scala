/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.customizer.includes.style.css.template.retail

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.Validation
import _root_.org.allbinary.logic.control.validate.ValidationInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.dhtml.style.StyleData
import _root_.org.allbinary.logic.visual.dhtml.style.StylesData
import _root_.org.allbinary.logic.visual.dhtml.style.StylesValidationFactory
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class CssStyleValidation() extends Validation with DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    var cssStyleElementVector : BasicArrayList = null

    //Constructor
    {
        this.cssStyleElementVector = new BasicArrayListD()
    }

    def this(document : Document) = {
        this()
        this.cssStyleElementVector = StylesValidationFactory.getInstance().getInstance(document)
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        this.cssStyleElementVector = StylesValidationFactory.getInstance(hashMap)
    }

    override def isValid() : _root_.java.lang.Boolean = {
        try {
            var isValid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.IS_VALID)
            }
            var size : Int = this.cssStyleElementVector.size()

            {
                var i : Int = 0
                while (i < size) {
                    var styleValidationInterface : ValidationInterface = this.cssStyleElementVector.get(i).asInstanceOf[ValidationInterface]
                    if (!styleValidationInterface.isValid().booleanValue()) {
                        isValid = _root_.java.lang.Boolean.FALSE
                    }
                    i += 1
                }
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("End: " + isValid, this, this.commonStrings.IS_VALID)
            }
            return isValid
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
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
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
        var node : Node = document.createElement(StylesData.getInstance().NAME)
        var styleNode : Node = document.createElement(StyleData.getInstance().NAME)
        node.appendChild(styleNode)
        var size : Int = this.cssStyleElementVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var styleDomNodeInterface : DomNodeInterface = this.cssStyleElementVector.get(i).asInstanceOf[DomNodeInterface]
                styleNode.appendChild(styleDomNodeInterface.toXmlNode(document))
                i += 1
            }
        }
        return node
    }

}


