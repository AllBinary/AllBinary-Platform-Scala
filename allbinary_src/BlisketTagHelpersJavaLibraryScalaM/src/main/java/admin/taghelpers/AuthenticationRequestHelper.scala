/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.business.user.password.Password
import _root_.org.allbinary.business.user.role.BasicUserRole
import _root_.org.allbinary.data.tables.user.UserEntityFactory
import _root_.org.allbinary.data.tables.user.UserEntityInterface
import _root_.org.allbinary.globals.GLOBALS2
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSessionData
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSessionInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.email.NewPasswordEmail
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory

class AuthenticationRequestHelper private () extends TagHelper {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    private var weblisketSession : WeblisketSession = null

    private var request : HttpServletRequest = null

    def this(hashMap : HashMap[Object, Object], pageContext : PageContext) = {
        this()
        this.weblisketSession = new WeblisketSession(hashMap, pageContext)
        this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
    }

    def this(hashMap : HashMap[Object, Object], httpServletRequest : HttpServletRequest) = {
        this()
        this.weblisketSession = new WeblisketSession(hashMap, httpServletRequest)
        this.request = httpServletRequest
    }

    private def generateNewPassword() : String = {
        //Remove this method after complete rebuild
        if ((this.weblisketSession != null) && (this.weblisketSession.getId() != null)) {
            var startIndex : Int = this.weblisketSession.getId().length()
            if (startIndex >= 8) {
                return this.weblisketSession.getId().substring(startIndex - 8)
            } else {
                throw new Exception("Error Generating New Password")
            }
        } else {
            throw new Exception("No Session Available For Generating New Password")
        }
        throw new IllegalStateException()
    }

    def newPassword() : _root_.java.lang.Boolean = {
        try {
            var userName : String = this.request.getParameter(WeblisketSessionData.REMOVABLEUSERNAME)
            var email : String = this.request.getParameter(UserData.MAINEMAIL)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                this.logUtil.putF("Generating New Password For: " + userName, this, "newPassword()")
            }
            /*          //Add back in if adding restriction based on role          UserRole role = this.weblisketSession.getRole();          if(role == null)          {             if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().TAGHELPER))             {                this.logUtil.putF("Trying role from request for: " + userName, this, "newPassword()");             }             String roleString = this.request.getParameter(UserRoleData.NAME);             if(role != null)             {                role = UserRole.getRole(roleString);             }          }           */
            var userEntityInterface : UserEntityInterface = UserEntityFactory.getInstance()
            var userInterface : UserInterface = userEntityInterface.getUser(userName)
            if (userInterface.getMainEmail().compareTo(email) != 0) {
                if ((userInterface.getSecondaryEmail() != null) && (userInterface.getSecondaryEmail().compareTo(email) != 0)) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                        this.logUtil.putF("Requested Email Is Not In User Profile", this, "newPassword()")
                    }
                    return _root_.java.lang.Boolean.FALSE
                }
            }
            var newPassword : String = this.generateNewPassword()
            userInterface.setPassword(newPassword)
            //update db with new password
            var newPasswordHashMap : HashMap[Object, Object] = userInterface.toPasswordHashMap().asInstanceOf[HashMap[Object, Object]]
            UserEntityFactory.getInstance().update(userName, newPasswordHashMap)
            //Send Communication with new password
            new NewPasswordEmail(this.abeClientInformation, userInterface, newPassword).process()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                this.logUtil.putF("Generated New Password For: " + userName, this, "newPassword()")
            }
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "newPassword()", e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def changePassword() : _root_.java.lang.Boolean = {
        try {
            var userName : String = this.request.getParameter(WeblisketSessionData.REMOVABLEUSERNAME)
            var passwordString : String = this.request.getParameter(WeblisketSessionData.REMOVABLEPASSWORD)
            var newPassword : String = this.request.getParameter(WeblisketSessionData.REMOVABLENEWPASSWORD)
            var newReenteredPassword : String = this.request.getParameter(WeblisketSessionData.REMOVABLEREENTERNEWPASSWORD)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                this.logUtil.putF("Changing Password For User: " + userName, this, "changePassword()")
            }
            /*          //Add back in if adding restriction based on role          UserRole role = this.weblisketSession.getRole();          if(role == null)          {             if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().TAGHELPER))             {                this.logUtil.putF("Trying role from request for: " + userName, this, "newPassword()");             }             String roleString = this.request.getParameter(UserRoleData.NAME);             if(role != null)             {                role = UserRole.getRole(roleString);             }          }           */
            var password : Password = new Password(newPassword)
            if (!password.isValid().booleanValue()) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                    this.logUtil.putF("New Password Is Not Valid", this, "changePassword()")
                }
                return _root_.java.lang.Boolean.FALSE
            }
            if (newPassword.compareTo(newReenteredPassword) != 0) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                    this.logUtil.putF("New Password Fields Do Not Match", this, "changePassword()")
                }
                return _root_.java.lang.Boolean.FALSE
            }
            var sessionPassword : String = this.weblisketSession.getPassword()
            var userEntityInterface : UserEntityInterface = UserEntityFactory.getInstance()
            var userInterface : UserInterface = userEntityInterface.getUser(userName)
            var login : String = userEntityInterface.login(userName, passwordString)
            if (login.compareTo(GLOBALS2.LOGINSUCCESS) == 0) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                    this.logUtil.putF("Authentication Successful", this, "changePassword()")
                }
                var newPasswordHashMap : HashMap[Object, Object] = password.toHashMap(null).asInstanceOf[HashMap[Object, Object]]
                UserEntityFactory.getInstance().update(userName, newPasswordHashMap)
                //Send Communication with new password
                new NewPasswordEmail(this.abeClientInformation, userInterface, newPassword).process()
                return _root_.java.lang.Boolean.TRUE
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                this.logUtil.putF("Authentication Failed", this, "changePassword()")
            }
            return _root_.java.lang.Boolean.FALSE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil.put("Authentication Failed", this, "changePassword()", e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    //Add role to session if it is a valid role
    def isRoleValid(userName : String, password : String, roles : BasicArrayList) : _root_.java.lang.Boolean = {
        try {
            var userEntityInterface : UserEntityInterface = UserEntityFactory.getInstance()
            var userInterface : UserInterface = userEntityInterface.getUser(userName)
            if (userInterface.getRole() == null) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                    this.logUtil.putF((("Role is null: " + userInterface.getRole()) + " Valid Roles: ") + roles.toString(), this, "isRoleValid()")
                }
                return _root_.java.lang.Boolean.FALSE
            }
            val basicUserRoleArray : Array[Object] = roles.toArray()
            val size : Int = basicUserRoleArray.length

            {
                var index : Int = 0
                while (index < size) {
                    var nextRole : BasicUserRole = basicUserRoleArray(index).asInstanceOf[BasicUserRole]
                    if (userInterface.getRole().getBasicUserRole().equals(nextRole)) {
                        /*if(userInterface.hasPermission(new RequestParams(this.request)))                {                   userInterface.validateSession(this.weblisketSession,new RequestParams(this.request));                }                else                {                   if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().TAGHELPER))                   {                      this.logUtil.putF("Role is not valid: " + userInterface.getRole() +                      " Valid Roles: " + roles.toString(),                      this,"isRoleValid()");                   }                                    return Boolean.FALSE;                }                 */
                        userInterface.validateSession(this.weblisketSession.asInstanceOf[WeblisketSessionInterface])
                        this.request.removeAttribute(WeblisketSessionData.REMOVABLEUSERNAME)
                        this.request.removeAttribute(WeblisketSessionData.REMOVABLEPASSWORD)
                        return _root_.java.lang.Boolean.TRUE
                    }
                    index += 1
                }
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Role is not valid: ")
                stringBuffer.append(userInterface.getRole().toString())
                stringBuffer.append(" Valid Roles: ")
                stringBuffer.append(roles.toString())
                this.logUtil.putF(stringBuffer.toString(), this, "isRoleValid()")
            }
            //on userInterface.getRole() failure
            return _root_.java.lang.Boolean.FALSE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "isRoleValid()", e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

}


