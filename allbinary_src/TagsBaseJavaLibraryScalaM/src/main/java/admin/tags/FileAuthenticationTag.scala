/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.util.Calendar
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.JspTagException
import _root_.javax.servlet.jsp.tagext.TagSupport
import _root_.org.allbinary.business.init.InstallerInfo
import _root_.org.allbinary.business.user.role.BasicUserRole
import _root_.org.allbinary.business.user.role.BasicUserRoleFactory
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.http.request.session.BasicWeblisketSession
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSessionData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.java.bool.BooleanUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.tags.CustomTagSupport

class FileAuthenticationTag() extends CustomTagSupport {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var attemptsInteger : Integer = null

    //private final int MAXSESSIONTIME = 360000000;
    private var weblisketSession : BasicWeblisketSession = null

    private var request : HttpServletRequest = null

    //private String storeName;
    private var command : String = null

    private var userName : String = null

    private var password : String = null

    private var newPassword : String = null

    private var authenticated : String = null

    private var sessionUserName : String = null

    private var role : BasicUserRole = null

    private var timeout : String = null

    private var roles : BasicArrayList = null

    def setCommand(command : String) : Unit = {
        this.command = command
    }

    def setUserName(userName : String) : Unit = {
        this.userName = userName
    }

    def setPassword(value : String) : Unit = {
        this.password = value
    }

    def setNewPassword(value : String) : Unit = {
        this.newPassword = value
    }

    def setRoles(values : BasicArrayList) : Unit = {
        this.roles = values
    }

    private def makeSessionValid(storedRole : BasicUserRole, userName : String) : Unit = {
        this.weblisketSession.setAuthenticated()
        this.weblisketSession.setRole(storedRole)
        this.weblisketSession.setUserName(userName)
        this.request.removeAttribute(WeblisketSessionData.REMOVABLEUSERNAME)
        this.request.removeAttribute(WeblisketSessionData.REMOVABLEPASSWORD)
    }

    private def getFormData() : Unit = {
        this.authenticated = this.weblisketSession.getAuthentication()
        this.sessionUserName = this.weblisketSession.getUserName()
        this.role = this.weblisketSession.getRole()
        this.attemptsInteger = this.weblisketSession.getAttempts()
        this.timeout = this.weblisketSession.getTimeout()
    }

    def nextAttempt() : Unit = {
        if ((this.attemptsInteger != null) && (this.attemptsInteger.intValue() > 0)) {
            this.weblisketSession.setAttempts(new Integer(this.attemptsInteger.intValue() + 1))
        } else {
            this.weblisketSession.setAttempts(new Integer(1))
        }
    }

    private def changePassword() : Boolean = {
        try {
            //BasicUserRole role = this.weblisketSession.getRole();
            var userName : String = this.request.getParameter(WeblisketSessionData.REMOVABLEUSERNAME)
            var password : String = this.request.getParameter(WeblisketSessionData.REMOVABLEPASSWORD)
            var newPassword : String = this.request.getParameter(WeblisketSessionData.REMOVABLENEWPASSWORD)
            //String sessionPassword = this.weblisketSession.getPassword();
            var newReenteredPassword : String = this.request.getParameter(WeblisketSessionData.REMOVABLEREENTERNEWPASSWORD)
            if (newPassword.compareTo(newReenteredPassword) != 0) {
                return false
            }
            var installerInfo : InstallerInfo = new InstallerInfo()
            if (installerInfo.isValid(userName, password)) {
                installerInfo.setPassword(newPassword)
                installerInfo.write()
                this.weblisketSession.setUserName(userName)
                this.weblisketSession.setPassword(newPassword)
                return true
            }
            return false
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "invalidateSession()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    private def invalidateSession() : Int = {
        try {
            this.weblisketSession.clear()
            return new Integer(TagSupport.EVAL_BODY_INCLUDE).intValue()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "invalidateSession()", e)
                }
                return TagSupport.SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

    private def isSessionOld() : Boolean = {
        try {
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
                    return _root_.java.lang.Boolean.TRUE.booleanValue()
                }
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATION)) {
                    this.logUtil.putF("Role Is Not In Session", this, "isSessionOld()")
                }
            }
            return this.isRarelyUsedSession().booleanValue()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "isSessionOld()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    private def isRarelyUsedSession() : _root_.java.lang.Boolean = {
        if (this.role != null) {
            var timeCreated : Long = this.weblisketSession.getCreationTime()
            var lastAccess : Long = this.weblisketSession.getLastAccessedTime()
            var timePassed : Long = this.role.getSessionInactivityTimeout()
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
                stringBuffer.appendlong(timePassed)
                this.logUtil.putF(stringBuffer.toString(), this, "isRarelyUsedSession()")
            }
        } else {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().AUTHENTICATION)) {
                this.logUtil.putF("Role Is Not In Session", this, "isRarelyUsedSession()")
            }
        }
        return _root_.java.lang.Boolean.FALSE
    }

    private def isRoleValid() : Boolean = {
        try {
            this.makeSessionValid(BasicUserRoleFactory.getInstance().INSTALLER, userName)
            return _root_.java.lang.Boolean.TRUE.booleanValue()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "isRoleValid()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    private def validRole() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            //pageContext.getOut().print("Removing POST UserName and Password");
            stringBuffer.append("Trying New login<p>")
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                var error : String = "Failed to set valid role"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "validRole()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    private def invalidRole() : String = {
        try {
            this.weblisketSession.setAuthenticated(false)
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Sorry your username and password is invalid on this page.")
            stringBuffer.append("Trying New login<p>")
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                var error : String = "Failed to set role invalid"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "invalidRole()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    private def isAuthenticationSessionValid() : Boolean = {
        try {
            if (BooleanUtil.getInstance().getFromString(this.authenticated)) {
                //Returning with existing authenticated session
                val size : Int = this.roles.size()

                {
                    var index : Int = 0
                    while (index < size) {
                        var mustBeOfRole : BasicUserRole = this.roles.get(index).asInstanceOf[BasicUserRole]
                        if ((this.sessionUserName != null) && this.role.equals(mustBeOfRole)) {
                            return _root_.java.lang.Boolean.TRUE.booleanValue()
                        }
                        index += 1
                    }
                }
                return _root_.java.lang.Boolean.FALSE.booleanValue()
            }
            return _root_.java.lang.Boolean.FALSE.booleanValue()
        } catch {
            case e : Exception => {
                //String error = "Failed to validate previously authenticated Session";
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "isAuthenticationSessionValid()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    private def processIfNewLogin() : Boolean = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                this.logUtil.putF((("Starting for User: " + this.userName) + " Attempt: ") + this.weblisketSession.getAttempts(), this, "processIfNewLogin()")
            }
            if ((((this.userName != null) && (this.userName.compareTo(StringUtil.getInstance().EMPTY_STRING) != 0)) && (this.password != null)) && (this.password.compareTo(StringUtil.getInstance().EMPTY_STRING) != 0)) {
                var login : String = null
                //check file instead of db
                var installerInfo : InstallerInfo = new InstallerInfo()
                if (installerInfo.isValid(this.userName, this.password)) {
                    login = _root_.org.allbinary.globals.GLOBALS2.LOGINSUCCESS
                } else {
                    login = _root_.org.allbinary.globals.GLOBALS2.LOGINFAILED
                }
                if (login.compareTo(_root_.org.allbinary.globals.GLOBALS2.LOGINSUCCESS) == 0) {
                    this.weblisketSession.setAttempts(new Integer(0))
                    return _root_.java.lang.Boolean.TRUE.booleanValue()
                }
                this.nextAttempt()
                return _root_.java.lang.Boolean.FALSE.booleanValue()
            }
            this.nextAttempt()
            return _root_.java.lang.Boolean.FALSE.booleanValue()
        } catch {
            case e : Exception => {
                //String error = "Failed to validate new login";
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "processIfNewLogin()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    private def processInvalidation() : Boolean = {
        try {
            if (BooleanUtil.getInstance().getFromString(this.timeout)) {
                this.invalidateSession()
                return _root_.java.lang.Boolean.TRUE.booleanValue()
            }

            {
                this.weblisketSession.setTimeout(BooleanFactory.getInstance().TRUE_STRING)
                return _root_.java.lang.Boolean.FALSE.booleanValue()
            }
        } catch {
            case e : Exception => {
                //String error = "Failed check if already set to invalidate";
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "isSetToInvalidate()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            val stringUtil : StringUtil = StringUtil.getInstance()
            this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
            this.weblisketSession = new BasicWeblisketSession(pageContext)
            this.getFormData()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                this.logUtil.putF("Started", this, this.tagStrings.DO_START_TAG)
            }
            if (this.command != null) {
                //if(command!=null) throw new LicensingException();
                if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.CHANGEPASSWORD) == 0) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                        this.logUtil.putF("Change Password", this, this.tagStrings.DO_START_TAG)
                    }
                    if (!this.changePassword()) {
                        pageContext.getOut().print("Password Change Attempt Failed.<p>")
                        return _root_.javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE
                    } else {
                        pageContext.getOut().print("Password Changed Successfully.<p>")
                        return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
                    }
                } else if (this.command.compareTo(WeblisketSessionData.INVALIDATESESSION) == 0) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                        this.logUtil.putF("INVALIDATESESSION", this, this.tagStrings.DO_START_TAG)
                    }
                    return this.invalidateSession()
                } else {
                    /*                     pageContext.getOut().print("UserName: " + this.userName + "<br>");                     pageContext.getOut().print("Password: " + this.password + "<br>");                     pageContext.getOut().print("UserName: " + this.sessionUserName + "<br>");                     pageContext.getOut().print("Role: " + this.role + "<br>");                     pageContext.getOut().print("Auth: " + this.authenticated + "<p>");                     this.outputSessionInfo(session);                      */
                    if (this.isSessionOld()) {
                        //}
                        if (this.processInvalidation()) {
                            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                                this.logUtil.putF("Processing Invalidation", this, this.tagStrings.DO_START_TAG)
                            }
                            //invalidates session based on a timeout
                            pageContext.getOut().print("Please login again.<p>")
                            if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.PROCESSBODYIFAUTHENTICATED) == 0) {
                                return TagSupport.SKIP_BODY
                            } else {
                                return TagSupport.EVAL_BODY_INCLUDE
                            }
                        } else {
                            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                                this.logUtil.putF("Preparing session for invalidation", this, this.tagStrings.DO_START_TAG)
                            }
                            //prepares session for timeout
                            if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.PROCESSBODYIFAUTHENTICATED) == 0) {
                                return TagSupport.SKIP_BODY
                            } else {
                                return TagSupport.EVAL_BODY_INCLUDE
                            }
                        }
                    }
                    /*                     if(this.userName==null || this.userName.compareTo(stringUtil.EMPTY_STRING)==0)                     pageContext.getOut().print("UserName Empty<br>");                     if(this.password==null  || this.password.compareTo(stringUtil.EMPTY_STRING)==0)                     pageContext.getOut().print("Password Empty<br>");                     if(this.sessionUserName==null || this.sessionUserName.compareTo(stringUtil.EMPTY_STRING)==0)                     pageContext.getOut().print("Session UserName Null or Empty<br>");                     if(this.authenticated!=null)                     {                     pageContext.getOut().print("Auth Not Empty<br>");                     if(this.authenticated.compareTo("true")==0)                     pageContext.getOut().print("Auth==true<br>");                     }                      */
                    if (((((this.userName == null) || (this.userName.compareTo(stringUtil.EMPTY_STRING) == 0)) && ((this.password == null) || (this.password.compareTo(stringUtil.EMPTY_STRING) == 0))) && (this.roles != null)) && this.isAuthenticationSessionValid()) {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                            this.logUtil.putF("Authenticated session is valid", this, this.tagStrings.DO_START_TAG)
                        }
                        if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.PROCESSBODYIFAUTHENTICATED) == 0) {
                            return TagSupport.EVAL_BODY_INCLUDE
                        } else {
                            return TagSupport.SKIP_BODY
                        }
                    }
                    if (((this.userName != null) && (this.password != null)) && this.processIfNewLogin()) {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                            this.logUtil.putF("Processing new login.", this, this.tagStrings.DO_START_TAG)
                        }
                        if (this.isRoleValid()) {
                            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                                this.logUtil.putF("Role is valid - Processing new login", this, this.tagStrings.DO_START_TAG)
                            }
                            pageContext.getOut().print(validRole())
                            if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.PROCESSBODYIFAUTHENTICATED) == 0) {
                                return _root_.javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE
                            } else {
                                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
                            }
                        } else {
                            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                                this.logUtil.putF("Role is not valid - Processing new login", this, this.tagStrings.DO_START_TAG)
                            }
                            pageContext.getOut().print(invalidRole())
                            if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.PROCESSBODYIFAUTHENTICATED) == 0) {
                                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
                            } else {
                                return _root_.javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE
                            }
                        }
                    } else {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                            this.logUtil.putF("Invalid Login", this, this.tagStrings.DO_START_TAG)
                        }
                        if ((((this.userName != null) && (this.userName.compareTo(StringUtil.getInstance().EMPTY_STRING) != 0)) && (this.password != null)) && (this.password.compareTo(StringUtil.getInstance().EMPTY_STRING) != 0)) {
                            pageContext.getOut().print("Sorry your username and/or password is invalid.<p>")
                        }
                    }
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                        var stringBuffer : StringMaker = new StringMaker()
                        stringBuffer.append("Major authentication error - userName: ")
                        stringBuffer.append(this.userName)
                        stringBuffer.append(" Password: ")
                        stringBuffer.append(this.password)
                        stringBuffer.append(" Command: ")
                        stringBuffer.append(this.command)
                        this.logUtil.putF(stringBuffer.toString(), this, this.tagStrings.DO_START_TAG)
                    }
                    //I hope this never occurs - I may add an exception for this case in the future
                    if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.PROCESSBODYIFAUTHENTICATED) == 0) {
                        return TagSupport.SKIP_BODY
                    } else {
                        return TagSupport.EVAL_BODY_INCLUDE
                    }
                }
            }
            return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
        } catch {
            case e : LicensingException => {
                AbResponseHandler.sendJspTagLicensingRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


