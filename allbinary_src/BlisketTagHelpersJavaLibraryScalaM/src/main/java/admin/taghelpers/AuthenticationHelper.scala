/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.javax.servlet.jsp.tagext.TagSupport
import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.business.user.role.BasicUserRole
import _root_.org.allbinary.business.user.role.UserRole
import _root_.org.allbinary.business.user.role.UserRoleFactory
import _root_.org.allbinary.data.tables.user.UserEntityFactory
import _root_.org.allbinary.data.tables.user.UserEntityInterface
import _root_.org.allbinary.globals.GLOBALS2
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.java.bool.BooleanUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class AuthenticationHelper(param_hashMap : HashMap[Object, Object], param_httpServletRequest : HttpServletRequest) extends TagHelper {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var weblisketSession : WeblisketSession = null

    private var authenticated : String = null

    private var sessionUserName : String = null

    private var role : UserRole = null

    private var timeout : String = null

    private var attemptsInteger : Integer = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val httpServletRequest : HttpServletRequest = param_httpServletRequest
        this.weblisketSession = new WeblisketSession(hashMap, httpServletRequest)
        this.getFormData()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATION)) {
            this.logUtil.putF(this.outputSessionInfo(), this, this.commonStrings.CONSTRUCTOR)
        }
    }

    //private final String TIMEOUT = "TIMEOUT";
    def this(hashMap : HashMap[Object, Object], pageContext : PageContext) = {
        this(hashMap, pageContext.getRequest().asInstanceOf[HttpServletRequest])
    }

    private def getFormData() : Unit = {
        this.authenticated = this.weblisketSession.getAuthentication()
        this.sessionUserName = this.weblisketSession.getUserName()
        this.role = this.weblisketSession.getRole()
        this.attemptsInteger = this.weblisketSession.getAttempts()
        this.timeout = this.weblisketSession.getTimeout()
    }

    def invalidateSession() : Integer = {
        try {
            this.weblisketSession.clear()
            //this.weblisketSession.invalidate();
            return new Integer(TagSupport.EVAL_BODY_INCLUDE)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATIONERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "invalidateSession()", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def isSessionOld() : _root_.java.lang.Boolean = {
        if (this.role != null) {
            var timeCreated : Long = this.weblisketSession.getCreationTime()
            var sessionTimout : Long = this.role.getSessionTimeout()
            var calendar : Calendar = Calendar.getInstance()
            var timeFirst : Long = calendar.getTimeInMillis() - sessionTimout
            if (timeFirst > timeCreated) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATION)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Session Is Old - Timeout: ")
                    stringBuffer.appendlong(sessionTimout)
                    stringBuffer.append(" Eval: ")
                    stringBuffer.appendlong(timeFirst)
                    stringBuffer.append(" > ")
                    stringBuffer.appendlong(timeCreated)
                    this.logUtil.putF(stringBuffer.toString(), this, "isSessionOld()")
                }
                return _root_.java.lang.Boolean.TRUE
            }
        } else {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATION)) {
                this.logUtil.putF("Role Is Not In Session", this, "isSessionOld()")
            }
        }
        return this.isRarelyUsedSession()
    }

    private def isRarelyUsedSession() : _root_.java.lang.Boolean = {
        if (this.role != null) {
            var timeCreated : Long = this.weblisketSession.getCreationTime()
            var lastAccess : Long = this.weblisketSession.getLastAccessedTime()
            var inactivityAllowed : Long = this.role.getSessionInactivityTimeout()
            var calendar : Calendar = Calendar.getInstance()
            var timeFirst : Long = calendar.getTimeInMillis() - lastAccess
            //Temp log - remove when fixed
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATION)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Session Is Rarely Used - Timeout: ")
                stringBuffer.appendlong(lastAccess)
                stringBuffer.append(" Eval: ")
                stringBuffer.appendlong(timeFirst)
                stringBuffer.append(" > ")
                stringBuffer.appendlong(inactivityAllowed)
                this.logUtil.putF(stringBuffer.toString(), this, "isRarelyUsedSession()")
            }
        } else {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATION)) {
                this.logUtil.putF("Role Is Not In Session", this, "isRarelyUsedSession()")
            }
        }
        return _root_.java.lang.Boolean.FALSE
    }

    def validRole() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            //pageContext.getOut().print("Removing POST UserName and Password");
            stringBuffer.append("Trying New login<p/>")
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                var error : String = "Failed to set valid role"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATIONERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "validRole()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def invalidRole() : String = {
        try {
            this.weblisketSession.setAuthenticated(false)
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Sorry your username and password is invalid on this page. ")
            stringBuffer.append("Trying New login<p/>")
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                var error : String = "Failed to set role invalid"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATIONERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "invalidRole()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def isAuthenticated() : Boolean = {
        if (BooleanUtil.getInstance().getFromString(this.authenticated)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def isAuthenticationSessionValid(roles : BasicArrayList) : _root_.java.lang.Boolean = {
        try {
            if (this.role != null) {
                if (this.isAuthenticated()) {
                    //Returning with existing authenticated session
                    if (this.sessionUserName != null) {
                        var basicUserRole : BasicUserRole = this.role.getBasicUserRole()
                        val basicUserRoleArray : Array[Object] = roles.toArray()
                        val size : Int = basicUserRoleArray.length

                        {
                            var index : Int = 0
                            while (index < size) {
                                var mustBeOfRole : BasicUserRole = basicUserRoleArray(index).asInstanceOf[BasicUserRole]
                                if (basicUserRole.equals(mustBeOfRole)) {
                                    if (basicUserRole.equals(UserRoleFactory.getInstance().CUSTOMER)) {
                                        var userEntityInterface : UserEntityInterface = UserEntityFactory.getInstance()
                                        var userInterface : UserInterface = userEntityInterface.getUser(this.sessionUserName)
                                        if (!userInterface.isSessionValid().booleanValue()) {
                                            return _root_.java.lang.Boolean.FALSE
                                        }
                                    }
                                    return _root_.java.lang.Boolean.TRUE
                                }
                                index += 1
                            }
                        }
                    }
                    return _root_.java.lang.Boolean.FALSE
                }
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATION)) {
                    this.logUtil.putF("Role Is Not In Session", this, "isAuthenticationSessionValid()")
                }
            }
            return _root_.java.lang.Boolean.FALSE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATIONERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "isAuthenticatedSessionValid()", e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def nextAttempt() : Unit = {
        if ((this.attemptsInteger != null) && (this.attemptsInteger.intValue() > 0)) {
            this.weblisketSession.setAttempts(new Integer(this.attemptsInteger.intValue() + 1))
        } else {
            this.weblisketSession.setAttempts(new Integer(1))
        }
    }

    def processIfNewLogin(userName : String, password : String) : _root_.java.lang.Boolean = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATIONERROR)) {
                this.logUtil.putF("Starting: " + userName, this, "processIfNewLogin()")
            }
            if ((((userName != null) && (userName.compareTo(StringUtil.getInstance().EMPTY_STRING) != 0)) && (password != null)) && (password.compareTo(StringUtil.getInstance().EMPTY_STRING) != 0)) {
                var login : String = null
                /*                 if(this.role.compareTo(UserRoleData.INSTALLER)!=0)                 {                  */
                var userEntityInterface : UserEntityInterface = UserEntityFactory.getInstance()
                login = userEntityInterface.login(userName, password)
                /*                 }                 else                 {                 //If client user is claiming to be an installer                 //check file instead of db                 InstallerInfo installerInfo = new InstallerInfo();                 if(installerInfo.isValid(userName, password))                 {                 login = allbinary.globals.GLOBALS2.LOGINSUCCESS;                 }                 else                 {                 login = allbinary.globals.GLOBALS2.LOGINFAILED;                 }                 }                  */
                if (login.compareTo(GLOBALS2.LOGINSUCCESS) == 0) {
                    var userInterface : UserInterface = userEntityInterface.getUser(userName)
                    if (userInterface.isSessionValid().booleanValue()) {
                        this.weblisketSession.setAttempts(new Integer(0))
                        return _root_.java.lang.Boolean.TRUE
                    }
                }
                this.nextAttempt()
                return _root_.java.lang.Boolean.FALSE
            }
            this.nextAttempt()
            return _root_.java.lang.Boolean.FALSE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATIONERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "processIfNewLogin()", e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def processInvalidation() : _root_.java.lang.Boolean = {
        try {
            if (BooleanUtil.getInstance().getFromString(this.timeout)) {
                this.invalidateSession()
                return _root_.java.lang.Boolean.TRUE
            }

            {
                this.weblisketSession.setTimeout(BooleanFactory.getInstance().TRUE_STRING)
                return _root_.java.lang.Boolean.FALSE
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATIONERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "processInvalidation()", e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    //used for debugging
    def outputSessionInfo() : String = {
        try {
            var calendar : Calendar = Calendar.getInstance()
            var timeCreated : Long = this.weblisketSession.getCreationTime()
            var stringBuffer : StringMaker = new StringMaker()
            var lastAccess : Long = this.weblisketSession.getLastAccessedTime()
            stringBuffer.append(("Time Since Last Access: " + (calendar.getTimeInMillis() - lastAccess)) + "<br/>\n")
            if (this.role != null) {
                stringBuffer.append("Auth: ")
                stringBuffer.append(this.authenticated)
                stringBuffer.append(" UserName: ")
                stringBuffer.append(this.sessionUserName)
                stringBuffer.append(" Role: ")
                stringBuffer.append(this.role.toString())
                //Remarked code shows user time left in session and last use
                stringBuffer.append("<br/>\n")
                stringBuffer.append("Time Left: ")
                stringBuffer.appendlong((this.role.getSessionTimeout() - (calendar.getTimeInMillis() - timeCreated)))
                stringBuffer.append("<br/>\n")
                stringBuffer.append("Inactivity Time Allowed: ")
                stringBuffer.appendlong(this.role.getSessionTimeout())
                stringBuffer.append("<br/>\n")
                stringBuffer.append("Inactivity Time Allowed: ")
                stringBuffer.appendlong(this.role.getSessionInactivityTimeout())
                stringBuffer.append("<br/>\n")
            } else {
                stringBuffer.append("Role Is Not Set<br/>\n")
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                return "Error"
            }
        }
        throw new IllegalStateException()
    }

    /**      * @return the role      */
    def getRole() : UserRole = {
        return this.role
    }

}


