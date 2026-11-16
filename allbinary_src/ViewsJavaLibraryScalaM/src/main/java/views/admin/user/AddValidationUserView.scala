/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.user

import _root_.org.allbinary.business.user.NewUserFactory
import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.data.tables.user.UserEntityFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.HttpContextView

class AddValidationUserView(param_transformInfoInterface : TransformInfoInterface) extends HttpContextView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_AddValidationUserView : LogUtil = LogUtil.getInstance()

    var user : UserInterface = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.user = NewUserFactory.getInstance(transformInfoInterface)
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            if (UserEntityFactory.getInstance().getUser(this.user.getUserName()) != null) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_AddValidationUserView.putF("User already in existance.", this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            if (this.user.isValid() == _root_.java.lang.Boolean.FALSE) {
                return _root_.java.lang.Boolean.FALSE
            }
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_AddValidationUserView.put("Failed to validate", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            if (UserEntityFactory.getInstance().getUser(this.user.getUserName()) != null) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_AddValidationUserView.putF("User already exists", this, "validationInfo()")
                }
                stringBuffer.append("The User Name you selected is already in use.<br/>  Please select another User Name.<br />")
            }
            if (this.user.isValid() == _root_.java.lang.Boolean.FALSE) {
                stringBuffer.append(this.user.validationInfo())
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_AddValidationUserView.put("Failed to generate validation error info", this, "validationInfo()", e)
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

    override def view() : String = {
        return views.ValidationOnlyTempUtil.getInstance().view(this)
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


