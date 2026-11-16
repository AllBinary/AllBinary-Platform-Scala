/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.user

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.user.username.UserName
import _root_.org.allbinary.data.tables.user.UserEntityFactory
import _root_.org.allbinary.logic.communication.http.request.RequestParams
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class DeleteValidationUserView(param_transformInfoInterface : TransformInfoInterface) extends UserView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_DeleteValidationUserView : LogUtil = LogUtil.getInstance()

    private var userName : String = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        var httpServletRequest : HttpServletRequest = this.getPageContext().getRequest().asInstanceOf[HttpServletRequest]
        var hashMap : HashMap[Object, Object] = new RequestParams(httpServletRequest).toHashMap().asInstanceOf[HashMap[Object, Object]]
        this.userName = new UserName(hashMap).get()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_DeleteValidationUserView.putF("User Name: " + this.userName, this, this.commonStrings.CONSTRUCTOR)
        }
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
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_DeleteValidationUserView.put("Failed to validate form", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            if (UserName.getInstance().isValid(this.userName) == _root_.java.lang.Boolean.TRUE) {
                this.user = UserEntityFactory.getInstance().getUser(this.userName)
                if (this.user == null) {
                    stringBuffer.append("User does not exist.<br />")
                }
            } else {
                stringBuffer.append("User Name is not valid.<br />")
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_DeleteValidationUserView.put("Failed to generate validation error info", this, "validationInfo()", e)
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


