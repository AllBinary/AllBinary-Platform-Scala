/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class ValidationViewHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends ViewHelper(param_hashMap, param_pageContext) with ValidationComponentInterface {

    val logUtil_ValidationViewHelper : LogUtil = LogUtil.getInstance()

    private var viewInterface : ValidationComponentInterface = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        this.viewInterface = this.getViewObject().asInstanceOf[ValidationComponentInterface]
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
            this.logUtil_ValidationViewHelper.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                this.logUtil_ValidationViewHelper.putF("Started", this, this.commonStrings.IS_VALID)
            }
            return this.viewInterface.isValid()
        } catch {
            case e : Exception => {
                //error += "Unknown";
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_ValidationViewHelper.put(this.commonStrings.EXCEPTION, this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            return this.viewInterface.validationInfo()
        } catch {
            case e : Exception => {
                //error += "Unknown";
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_ValidationViewHelper.put(this.commonStrings.EXCEPTION, this, "validationInfo()", e)
                }
                return "Unknown Validation Error"
            }
        }
        throw new IllegalStateException()
    }

    def toValidationInfoDoc() : Document = {
        try {
            return this.viewInterface.toValidationInfoDoc()
        } catch {
            case e : Exception => {
                //error += "Unknown";
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_ValidationViewHelper.put(this.commonStrings.EXCEPTION, this, "toValidationInfoDoc()", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def toValidationInfoNode(document : Document) : Node = {
        try {
            return this.viewInterface.toValidationInfoNode(document)
        } catch {
            case e : Exception => {
                //error += "Unknown";
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_ValidationViewHelper.put(this.commonStrings.EXCEPTION, this, "toValidationInfoNode()", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


