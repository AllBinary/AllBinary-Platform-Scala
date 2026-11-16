/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.user

import _root_.org.allbinary.business.user.username.UserName
import _root_.org.allbinary.data.tables.user.UserEntityFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class EditValidationView(param_transformInfoInterface : TransformInfoInterface) extends UserView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_EditValidationView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            if (UserName.getInstance().isValid(this.getWeblisketSession().getUserName()) == _root_.java.lang.Boolean.FALSE) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_EditValidationView.putF("Failed to validate username", this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            this.user = UserEntityFactory.getInstance().getUser(this.getWeblisketSession().getUserName())
            if (this.user == null) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_EditValidationView.putF("User does not exist", this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            if (this.user.isValid() == _root_.java.lang.Boolean.FALSE) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_EditValidationView.putF("User exists but is invalid - Probably manually modified", this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_EditValidationView.put("Failed to validate", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            if (UserName.getInstance().isValid(this.getWeblisketSession().getUserName()) == _root_.java.lang.Boolean.FALSE) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_EditValidationView.putF("Failed to validate username", this, "validationInfo()")
                }
                stringBuffer.append("Session User Name is not valid - Your session data has been logged!")
            }
            if (this.user == null) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_EditValidationView.putF("User does not exist", this, this.commonStrings.IS_VALID)
                }
                stringBuffer.append("User profile does not exist - Your session data has been logged!")
            }
            if (this.user.isValid() == _root_.java.lang.Boolean.FALSE) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_EditValidationView.putF("User exists but is invalid - Probably manually modified", this, this.commonStrings.IS_VALID)
                }
                stringBuffer.append(this.user.validationInfo())
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_EditValidationView.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Getting Validation Info"
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

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


