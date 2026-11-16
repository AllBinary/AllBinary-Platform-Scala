/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package servlet.request

import _root_.java.io.*
import _root_.java.net.*
import _root_.javax.servlet.*
import _root_.javax.servlet.http.*
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.workflow.WorkFlowInterface
import _root_.org.allbinary.logic.control.workflow.RequestWorkFlowFactory

class RequestHandler extends HttpServlet {

    val logUtil : LogUtil = LogUtil.getInstance()

    override def init(config : ServletConfig) : Unit = {
        super.init(config)
    }

    override def destroy() : Unit = {
    }

    def processRequest(request : HttpServletRequest, response : HttpServletResponse) : Unit = {
        try {
            response.setContentType("text/html")
            var out : PrintWriter = response.getWriter()
            var workflowInterface : WorkFlowInterface = RequestWorkFlowFactory.getInstance(request.asInstanceOf[ServletRequest], response.asInstanceOf[ServletResponse], this.getServletConfig(), this.getServletContext())
            if (workflowInterface != null) {
                out.print(workflowInterface.process())
            }
            out.flush()
            out.close()
        } catch {
            case e : LicensingException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SERVLETERROR)) {
                    this.logUtil.put("Servlet LicensingException", this, "processRequest()", e)
                }
                response.sendRedirect(abcs.globals.URLGLOBALS.LICENSEERRORPAGE)
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SERVLETERROR)) {
                    this.logUtil.put("Servlet Exception", this, "processRequest()", e)
                }
                response.sendRedirect(abcs.globals.URLGLOBALS.ERRORPAGE)
            }
        }
    }

    override def doGet(request : HttpServletRequest, response : HttpServletResponse) : Unit = {
        this.processRequest(request, response)
    }

    override def doPost(request : HttpServletRequest, response : HttpServletResponse) : Unit = {
        this.processRequest(request, response)
    }

    override def getServletInfo() : String = {
        return "WorkFlow Request Handler"
    }

}


