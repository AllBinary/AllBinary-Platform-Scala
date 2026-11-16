/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.JspTagException
import _root_.javax.servlet.jsp.tagext.TagSupport
import _root_.admin.taghelpers.AuthenticationHelperFactory
import _root_.admin.taghelpers.AuthenticationRequestHelperFactory
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSessionData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.tags.CustomTagSupport

class AuthenticationTag() extends CustomTagSupport {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var command : String = null

    private var userName : String = null

    private var password : String = null

    private var newPassword_AuthenticationTag : String = null

    private var roles : BasicArrayList = null

    private var propertiesHashMap : HashMap[Object, Object] = null

    //Constructor
    {
        val stringUtil : StringUtil = StringUtil.getInstance()
        this.userName = stringUtil.EMPTY_STRING
        this.password = stringUtil.EMPTY_STRING
    }

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
        this.newPassword_AuthenticationTag = value
    }

    def setRoles(values : BasicArrayList) : Unit = {
        this.roles = values
    }

    private def changePassword() : Boolean = {
        try {
            var anyType : Object = new AuthenticationRequestHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("changePassword", null)
            var result : _root_.java.lang.Boolean = method.invoke(anyType, null).asInstanceOf[_root_.java.lang.Boolean]
            return result.booleanValue()
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "changePassword()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    private def newPassword() : Boolean = {
        try {
            var anyType : Object = new AuthenticationRequestHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("newPassword", null)
            var result : _root_.java.lang.Boolean = method.invoke(anyType, null).asInstanceOf[_root_.java.lang.Boolean]
            return result.booleanValue()
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "newPassword()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    private def invalidateSession() : Int = {
        try {
            var anyType : Object = new AuthenticationHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("invalidateSession", null)
            var resultInteger : Integer = method.invoke(anyType, null).asInstanceOf[Integer]
            return resultInteger.intValue()
        } catch {
            case e : LicensingException => {
                throw e
            }
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
            var anyType : Object = new AuthenticationHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var helperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("isSessionOld", null)
            var resultBoolean : _root_.java.lang.Boolean = method.invoke(anyType, null).asInstanceOf[_root_.java.lang.Boolean]
            return resultBoolean.booleanValue()
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "isSessionOld()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    private def isRoleValid() : Boolean = {
        try {
            var anyType : Object = new AuthenticationRequestHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var methodParams : Array[Class[?]] = Array[Class[?]](this.userName.getClass(), this.password.getClass(), this.roles.getClass())
            var method : Method = addressHelperClass.getMethod("isRoleValid", methodParams*)
            var methodArgs : Array[Object] = Array[Object](this.userName, this.password, this.roles)
            var resultBoolean : _root_.java.lang.Boolean = method.invoke(anyType, methodArgs*).asInstanceOf[_root_.java.lang.Boolean]
            return resultBoolean.booleanValue()
        } catch {
            case e : LicensingException => {
                throw e
            }
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
            var anyType : Object = new AuthenticationHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("validRole", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
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
            var anyType : Object = new AuthenticationHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("invalidRole", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
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
            var anyType : Object = new AuthenticationHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var methodParams : Array[Class[?]] = Array[Class[?]](this.roles.getClass())
            var method : Method = addressHelperClass.getMethod("isAuthenticationSessionValid", methodParams*)
            var methodArgs : Array[Object] = Array[Object](this.roles)
            var resultBoolean : _root_.java.lang.Boolean = method.invoke(anyType, methodArgs*).asInstanceOf[_root_.java.lang.Boolean]
            return resultBoolean.booleanValue()
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
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
            var anyType : Object = new AuthenticationHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var helperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var methodParams : Array[Class[?]] = Array[Class[?]](this.userName.getClass(), this.password.getClass())
            var method : Method = helperClass.getMethod("processIfNewLogin", methodParams*)
            var methodArgs : Array[Object] = Array[Object](this.userName, this.password)
            var resultBoolean : _root_.java.lang.Boolean = method.invoke(anyType, methodArgs*).asInstanceOf[_root_.java.lang.Boolean]
            return resultBoolean.booleanValue()
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
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
            var anyType : Object = new AuthenticationHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("processInvalidation", null)
            var resultBoolean : _root_.java.lang.Boolean = method.invoke(anyType, null).asInstanceOf[_root_.java.lang.Boolean]
            return resultBoolean.booleanValue()
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
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
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                var request : HttpServletRequest = this.pageContext.getRequest().asInstanceOf[HttpServletRequest]
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append(" Request URI: ")
                stringBuffer.append(request.getRequestURI())
                this.logUtil.putF(stringBuffer.toString(), this, tagStrings.DO_START_TAG)
            }
            if (this.command != null) {
                //if(command!=null) throw new LicensingException();
                this.propertiesHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
                if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.NEWPASSWORD) == 0) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                        this.logUtil.putF("New Password", this, tagStrings.DO_START_TAG)
                    }
                    if (!this.newPassword()) {
                        pageContext.getOut().print("New Password Request Failed.<p/>")
                        return _root_.javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE
                    } else {
                        pageContext.getOut().print("New Password Was Sent.<p/>")
                        return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
                    }
                } else if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.CHANGEPASSWORD) == 0) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                        this.logUtil.putF("Change Password", this, tagStrings.DO_START_TAG)
                    }
                    if (!this.changePassword()) {
                        pageContext.getOut().print("Password Change Attempt Failed.<p/>")
                        return _root_.javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE
                    } else {
                        pageContext.getOut().print("Password Changed Successfully.<p/>")
                        return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
                    }
                } else if (this.command.compareTo(WeblisketSessionData.INVALIDATESESSION) == 0) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                        this.logUtil.putF("INVALIDATESESSION", this, tagStrings.DO_START_TAG)
                    }
                    return this.invalidateSession()
                } else {
                    /*                     pageContext.getOut().print("UserName: " + this.userName + "<br>");                     pageContext.getOut().print("Password: " + this.password + "<br>");                     pageContext.getOut().print("UserName: " + sessionUserName + "<br>");                     pageContext.getOut().print("Role: " + role + "<br>");                     pageContext.getOut().print("Auth: " + authenticated + "<p>");                     this.outputSessionInfo(session);                      */
                    if (this.isSessionOld()) {
                        //}
                        if (this.processInvalidation()) {
                            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                                this.logUtil.putF("Processing Invalidation", this, tagStrings.DO_START_TAG)
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
                                this.logUtil.putF("Preparing session for invalidation", this, tagStrings.DO_START_TAG)
                            }
                            //prepares session for timeout
                            if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.PROCESSBODYIFAUTHENTICATED) == 0) {
                                return TagSupport.SKIP_BODY
                            } else {
                                return TagSupport.EVAL_BODY_INCLUDE
                            }
                        }
                    }
                    /*                     if(this.userName==null || this.userName.compareTo(stringUtil.EMPTY_STRING)==0)                     pageContext.getOut().print("UserName Empty<br>");                     if(this.password==null  || this.password.compareTo(stringUtil.EMPTY_STRING)==0)                     pageContext.getOut().print("Password Empty<br>");                     if(sessionUserName==null || sessionUserName.compareTo(stringUtil.EMPTY_STRING)==0)                     pageContext.getOut().print("Session UserName Null or Empty<br>");                     if(authenticated!=null)                     {                     pageContext.getOut().print("Auth Not Empty<br>");                     if(authenticated.compareTo("true")==0)                     pageContext.getOut().print("Auth==true<br>");                     }                      */
                    if (((((this.userName == null) || (this.userName.compareTo(stringUtil.EMPTY_STRING) == 0)) && ((this.password == null) || (this.password.compareTo(stringUtil.EMPTY_STRING) == 0))) && (this.roles != null)) && this.isAuthenticationSessionValid()) {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                            this.logUtil.putF("Authenticated session is valid", this, tagStrings.DO_START_TAG)
                        }
                        if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.PROCESSBODYIFAUTHENTICATED) == 0) {
                            return TagSupport.EVAL_BODY_INCLUDE
                        } else {
                            return TagSupport.SKIP_BODY
                        }
                    }
                    if (((this.userName != null) && (this.password != null)) && this.processIfNewLogin()) {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                            this.logUtil.putF("Processing new login.", this, tagStrings.DO_START_TAG)
                        }
                        if (this.isRoleValid()) {
                            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                                this.logUtil.putF("Role is valid - Processing new login", this, tagStrings.DO_START_TAG)
                            }
                            pageContext.getOut().print(validRole())
                            if (this.command.compareTo(_root_.org.allbinary.globals.GLOBALS2.PROCESSBODYIFAUTHENTICATED) == 0) {
                                return _root_.javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE
                            } else {
                                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
                            }
                        } else {
                            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                                this.logUtil.putF("Role is not valid - Processing new login", this, tagStrings.DO_START_TAG)
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
                            this.logUtil.putF("Invalid Login", this, tagStrings.DO_START_TAG)
                        }
                        if ((((this.userName != null) && (this.userName.compareTo(stringUtil.EMPTY_STRING) != 0)) && (this.password != null)) && (this.password.compareTo(stringUtil.EMPTY_STRING) != 0)) {
                            pageContext.getOut().print("Sorry your username and/or password is invalid.<p/>")
                        }
                    }
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                        this.logUtil.putF(new StringMaker().append("Major authentication error - userName: ").append(this.userName).append(" Password: ").append(this.password).append(" Command: ").append(this.command).toString(), this, tagStrings.DO_START_TAG)
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


