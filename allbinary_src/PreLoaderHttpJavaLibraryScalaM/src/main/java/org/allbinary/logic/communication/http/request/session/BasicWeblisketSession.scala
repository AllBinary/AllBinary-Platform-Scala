/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.request.session

import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.http.HttpSession
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData
import _root_.org.allbinary.business.user.role.BasicUserRole
import _root_.org.allbinary.business.user.role.BasicUserRoleData
import _root_.org.allbinary.logic.java.bool.BooleanFactory

class BasicWeblisketSession(param_pageContext : PageContext) {

    private var session : HttpSession = null

    //private HashMap propertiesHashMap;
    private var pageContext : PageContext = null

    /*    public WeblisketSession(PageContext pageContext)    {       this.pageContext = pageContext;                    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();       this.session = request.getSession(true);    }    */
    //Constructor
    {
        val pageContext : PageContext = param_pageContext
        this.pageContext = pageContext
        var request : HttpServletRequest = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        //Might use this instead for Google App Engine - this.getThreadLocalRequest().getSession();
        this.session = request.getSession(true)
    }

    def setRole(aRole : BasicUserRole) : Unit = {
        this.session.setAttribute(BasicUserRoleData.NAME.toString(), aRole)
    }

    def getRole() : BasicUserRole = {
        return this.session.getAttribute(BasicUserRoleData.NAME.toString()).asInstanceOf[BasicUserRole]
    }

    def setPassword(password : String) : Unit = {
        this.session.setAttribute(UserData.PASSWORD, password)
    }

    def setUserName(userName : String) : Unit = {
        this.session.setAttribute(UserData.USERNAME, userName)
    }

    def setPaymentMethod(value : String) : Unit = {
        this.session.setAttribute(PaymentGatewayData.NAME.toString(), value)
    }

    def setAuthenticated() : Unit = {
        this.session.setAttribute(WeblisketSessionData.AUTHENTICATED, BooleanFactory.getInstance().TRUE_STRING)
    }

    def setAttempts(value : Integer) : Unit = {
        this.session.setAttribute(WeblisketSessionData.ATTEMPTS, value)
    }

    def setTimeout(value : String) : Unit = {
        this.session.setAttribute(WeblisketSessionData.TIMEOUT, value)
    }

    def setStoreName(value : String) : Unit = {
        this.session.setAttribute(StoreFrontData.getInstance().NAME, value)
    }

    def getWebAppPath() : String = {
        return this.session.getAttribute(_root_.org.allbinary.globals.GLOBALS2.WEBAPPPATH).asInstanceOf[String]
    }

    def getUserName() : String = {
        return this.session.getAttribute(UserData.USERNAME).asInstanceOf[String]
    }

    def getPassword() : String = {
        return this.session.getAttribute(UserData.PASSWORD).asInstanceOf[String]
    }

    def getPaymentMethod() : String = {
        return this.session.getAttribute(PaymentGatewayData.NAME.toString()).asInstanceOf[String]
    }

    def getAuthentication() : String = {
        return this.session.getAttribute(WeblisketSessionData.AUTHENTICATED).asInstanceOf[String]
    }

    def getAttempts() : Integer = {
        return this.session.getAttribute(WeblisketSessionData.ATTEMPTS).asInstanceOf[Integer]
    }

    def getTimeout() : String = {
        return this.session.getAttribute(WeblisketSessionData.TIMEOUT).asInstanceOf[String]
    }

    def getStoreName() : String = {
        return this.session.getAttribute(StoreFrontData.getInstance().NAME).asInstanceOf[String]
    }

    def setAuthenticated(value : Boolean) : Unit = {
        this.session.setAttribute(WeblisketSessionData.AUTHENTICATED, BooleanFactory.getInstance().FALSE_STRING)
    }

    def clear() : Unit = {
        this.session.removeAttribute(WeblisketSessionData.AUTHENTICATED)
        this.session.removeAttribute(WeblisketSessionData.TIMEOUT)
        this.session.removeAttribute(BasicUserRoleData.NAME.toString())
        this.session.removeAttribute(UserData.USERNAME)
    }

    /*    public void invalidate()    {       this.clear();       this.session.invalidate();    }    */
    def getCreationTime() : Long = {
        return this.session.getCreationTime()
    }

    def getLastAccessedTime() : Long = {
        var lastAccessedTime : Long = this.session.getLastAccessedTime()
        //}
        return lastAccessedTime
    }

}


