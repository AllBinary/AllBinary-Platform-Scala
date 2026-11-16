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

class EditValidationUserView(param_transformInfoInterface : TransformInfoInterface) extends UserView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_EditValidationUserView : LogUtil = LogUtil.getInstance()

    private var userName : String = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        //this.userName = new UserName(hashMap).get();
        this.userName = this.getWeblisketSession().getUserName()
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            if (UserName.getInstance().isValid(this.userName) == _root_.java.lang.Boolean.TRUE) {
                this.user = UserEntityFactory.getInstance().getUser(this.userName)
                if (this.user == null) {
                    return _root_.java.lang.Boolean.FALSE
                }
            } else {
                return _root_.java.lang.Boolean.FALSE
            }
            return this.user.isValid()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_EditValidationUserView.put("Failed to validate form", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            if (UserName.getInstance().isValid(this.userName).booleanValue()) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_EditValidationUserView.putF("User Name is valid", this, "validationInfo()")
                }
                this.user = UserEntityFactory.getInstance().getUser(this.userName)
                if (this.user == null) {
                    stringBuffer.append("User does not exist.<br />")
                    return stringBuffer.toString()
                }
            } else {
                stringBuffer.append("User Name is not valid.<br />")
                return stringBuffer.toString()
            }
            if (this.user.isValid() == _root_.java.lang.Boolean.FALSE) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_EditValidationUserView.putF("User exists but is invalid - Probably manually modified", this, "validationInfo()")
                }
                stringBuffer.append("User data is not valid - Please call administrator.<br />")
                stringBuffer.append(this.user.validationInfo())
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_EditValidationUserView.put("Failed to generate validation error info", this, "validationInfo()", e)
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

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


