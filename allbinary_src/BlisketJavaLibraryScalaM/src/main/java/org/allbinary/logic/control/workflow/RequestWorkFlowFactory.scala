/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.workflow

import _root_.java.util.HashMap
import _root_.javax.servlet.ServletConfig
import _root_.javax.servlet.ServletContext
import _root_.javax.servlet.ServletRequest
import _root_.javax.servlet.ServletResponse
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.data.tables.workflow.WorkFlowEntityFactory
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

class RequestWorkFlowFactory private() {
    import _root_.org.allbinary.logic.control.workflow.RequestWorkFlowFactory.{*}

}

object RequestWorkFlowFactory {
    //i.e. getting a workflow from the db for processing the workflow
    def getInstance(request : ServletRequest, response : ServletResponse, servletConfig : ServletConfig, servletContext : ServletContext) : WorkFlowInterface = {
        var httpRequest : HttpServletRequest = request.asInstanceOf[HttpServletRequest]
        var requestCommand : String = httpRequest.getPathInfo()
        var index : Int = requestCommand.indexOf(AbPathData.getInstance().SEPARATOR)
        var storeName : String = requestCommand.substring(0, index)
        var requestName : String = requestCommand.substring(index, requestCommand.length())
        //The entity factory uses the WorkFlowFactory.getInstance(HashMap hashMap)
        return WorkFlowEntityFactory.getInstance().create2().get(requestName, storeName)
    }

    //Used to validate, delete, edit, and/or view
    def getInstance(hashMap : HashMap[Object, Object], pageContext : PageContext) : WorkFlowInterface = {
        var workFlowName : String = pageContext.getRequest().getParameter(WorkFlowData.getInstance().NAME).asInstanceOf[String]
        var weblisketSession : WeblisketSession = new WeblisketSession(hashMap, pageContext)
        var storeName : String = weblisketSession.getStoreName()
        //The entity factory uses the WorkFlowFactory.getInstance(HashMap hashMap)
        return WorkFlowEntityFactory.getInstance().create2().get(workFlowName, storeName)
    }

}


