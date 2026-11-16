/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.style.css

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class CssElementValidation private (super_1 : Node, constructor_ : Unit) extends CssElementView(super_1) with ValidationInterface {

    val logUtil_CssElementValidation : LogUtil = LogUtil.getInstance()

    def this(node : Node) = {
        this(node, ())
    }

    def this() = {
        this(null, ())
    }

    /*    public CssElementValidation(HashMap hashMap)    {       super(hashMap);    }      */
    def isValid() : _root_.java.lang.Boolean = {
        try {
            var valid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_CssElementValidation.putF("CssElementValidation", this, this.commonStrings.IS_VALID)
            }
            /*          if(!StringValidationUtil.isValidRequired(,1,StyleData.NAMEMAXLEN))          {             valid = Boolean.FALSE;          }           iter = this.getStyleAttributes();          while(iter.next())          {             ValidationInterface styleAttributeValidationInterface =                 (ValidationInterface) iter.next();              if(styleAttributeValidationInterface.isValid().booleanValue())             {                valid = Boolean.FALSE;             }          }          */
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_CssElementValidation.putF("CssElementValidation: " + valid, this, this.commonStrings.IS_VALID)
            }
            return valid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_CssElementValidation.put("Failed to validate data", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(this.getValue())
            stringBuffer.append(" Css Style is not valid.")
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_CssElementValidation.put("Failed to generate validation info error", this, "validationInfo()", e)
                }
                return "Error Validating Data"
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


