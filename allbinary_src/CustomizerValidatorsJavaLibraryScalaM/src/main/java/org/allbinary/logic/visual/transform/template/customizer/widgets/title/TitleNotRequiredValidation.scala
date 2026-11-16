/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.customizer.widgets.title

import _root_.java.util.HashMap
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class TitleNotRequiredValidation private (super_1 : Node, constructor_ : Unit) extends TitleView(super_1) with ValidationInterface {

    val logUtil_TitleNotRequiredValidation : LogUtil = LogUtil.getInstance()

    def this(node : Node) = {
        this(node, ())
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this(hashMap, ())
    }

    def this() = {
        this(null, ())
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_TitleNotRequiredValidation.putF(this.commonStrings.START, this, this.commonStrings.IS_VALID)
            }
            var valid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if (!StringValidationUtil.getInstance().isValidNotRequired(this.getTitle(), 0, TitleData.getInstance().MAXLEN)) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Title: ")
                stringBuffer.append(this.getTitle())
                stringBuffer.append("End: ")
                stringBuffer.appendboolean(valid)
                this.logUtil_TitleNotRequiredValidation.putF(stringBuffer.toString(), this, this.commonStrings.IS_VALID)
            }
            return valid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_TitleNotRequiredValidation.put("Failed to validate form", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Title is not valid.")
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_TitleNotRequiredValidation.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Validating Form"
            }
        }
        throw new IllegalStateException()
    }

    def toValidationInfoDoc() : Document = {
        return null
    }

    def toValidationInfoNode(document : Document) : Node = {
        return null
    }

}


