/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.servlet

import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.IOException
import _root_.java.io.InputStream
import _root_.javax.servlet.ServletException
import _root_.javax.servlet.http.HttpServlet
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.http.HttpServletResponse
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.CloudStreamUtil
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author user  */
class MagicalImageServlet extends HttpServlet {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    def processRequest(request : HttpServletRequest, response : HttpServletResponse) : Unit = {
        var inputStream : InputStream = null
        try {
            //response.getOutputStream().write("OK!".getBytes());
            BlisketServletUtil.getInstance().init(request)
            val requestURI : String = request.getRequestURI()
            val file : AbFile = AbFile.createAbFile(URLGLOBALS.getWebappPath() + requestURI)
            inputStream = CloudStreamUtil.getInstance().getFileAnyWhere(file)
            val outputStream : ByteArrayOutputStream = new ByteArrayOutputStream(8000)
            val byteArray : Array[Byte] = StreamUtil.getInstance().getByteArray(inputStream, outputStream, new Array[Byte](16384))
            response.setContentType("image/jpeg;charset=utf-8")
            response.getOutputStream().write(byteArray)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "processRequest()", e)
                }
            }
        } finally {
            StreamUtil.getInstance().close(response.getOutputStream())
            if (!StreamUtil.getInstance().close(inputStream)) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND)
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
        return "Serves Up Image From Local or Cloud"
    }

}


