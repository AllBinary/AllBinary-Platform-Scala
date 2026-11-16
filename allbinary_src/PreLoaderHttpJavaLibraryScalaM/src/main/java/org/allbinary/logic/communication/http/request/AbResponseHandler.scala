/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.request

import _root_.javax.servlet.RequestDispatcher
import _root_.javax.servlet.ServletException
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.http.HttpServletResponse
import _root_.javax.servlet.jsp.JspTagException
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes

class AbResponseHandler private() {
    import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

}

object AbResponseHandler {
    def sendJspTagRedirect(pageContext : PageContext, e : Exception) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                logUtil.put("Jsp Tag Exception", "AbResponseHandler", "sendJspRedirect()", e)
            }
            AbResponseHandler.sendRedirect(pageContext, FREEBLISKET_PATH_GLOBALS.getInstance().ERRORPAGE)
        } catch {
            case e2 : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().LICENSINGERROR)) {
                    logUtil.put("Exception in Redirect Handling", "AbResponseHandler", "sendJspRedirect", e)
                }
                throw new JspTagException()
            }
        }
    }

    def sendServletRedirect(pageContext : PageContext, e : Exception) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                logUtil.put("Jsp Tag Exception", "AbResponseHandler", "sendJspRedirect()", e)
            }
            AbResponseHandler.sendRedirect(pageContext, FREEBLISKET_PATH_GLOBALS.getInstance().ERRORPAGE)
        } catch {
            case e2 : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().LICENSINGERROR)) {
                    logUtil.put("Exception in Redirect Handling", "AbResponseHandler", "sendJspRedirect", e)
                }
                throw new ServletException()
            }
        }
    }

    def sendJspTagLicensingRedirect(pageContext : PageContext, e : Exception) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                logUtil.put("Licensing Exception", "AbResponseHandler", "sendJspTagLicensingRedirect()", e)
            }
            AbResponseHandler.sendRedirect(pageContext, FREEBLISKET_PATH_GLOBALS.getInstance().LICENSEERRORPAGE)
        } catch {
            case e2 : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().LICENSINGERROR)) {
                    logUtil.put("Exception in Redirect Handling", "AbResponseHandler", "sendJspTagLicensingRedirect", e)
                }
                throw new JspTagException()
            }
        }
    }

    def sendServletLicensingRedirect(pageContext : PageContext, e : Exception) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                logUtil.put("Licensing Exception", "AbResponseHandler", "sendServletLicensingRedirect()", e)
            }
            AbResponseHandler.sendRedirect(pageContext, FREEBLISKET_PATH_GLOBALS.getInstance().LICENSEERRORPAGE)
        } catch {
            case e2 : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().LICENSINGERROR)) {
                    logUtil.put("Exception in Redirect Handling", "AbResponseHandler", "sendServletLicensingRedirect", e)
                }
                throw new ServletException()
            }
        }
    }

    def sendRedirect(pageContext : PageContext, page : String) : Unit = {
        val request : HttpServletRequest = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        val response : HttpServletResponse = pageContext.getResponse().asInstanceOf[HttpServletResponse]
        val requestDispatcher : RequestDispatcher = request.getRequestDispatcher(page)
        if (response.isCommitted()) {
            response.sendRedirect(page)
        } else {
            try {
                requestDispatcher.forward(request, response)
            } catch {
                case e : Exception => {
                    pageContext.getOut().print("Error: " + page)
                }
            }
        }
    }

}


