/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.servlet.file

import _root_.java.io.IOException
import _root_.java.io.InputStream
import _root_.java.util.HashMap
import _root_.javax.servlet.ServletException
import _root_.javax.servlet.http.HttpServlet
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.http.HttpServletResponse
import _root_.admin.taghelpers.AuthenticationHelper
import _root_.admin.taghelpers.AuthenticationHelperFactory
import _root_.admin.taghelpers.AuthenticationHelperUtil
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.CloudStreamUtil
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.servlet.BlisketServletUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author user  *  */
class DownloadFileServlet extends HttpServlet {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val DOWNLOAD : String = "download"

    private val DEFAULT_BUFFER_SIZE : Int = 16384

    def processRequest(request : HttpServletRequest, response : HttpServletResponse) : Unit = {
        var inputStream : InputStream = null
        try {
            //response.getOutputStream().write("OK!".getBytes());
            BlisketServletUtil.getInstance().init(request)
            var requestPath : String = request.getRequestURI()
            if (requestPath == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND)
                return
            }
            var beginIndex : Int = requestPath.indexOf(this.DOWNLOAD)
            var filePath : String = StringUtil.getInstance().EMPTY_STRING
            if (beginIndex >= 0) {
                filePath = requestPath.substring(beginIndex + this.DOWNLOAD.length())
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND)
            }
            var file : AbFile = AbFile.createAbFile(URLGLOBALS.getWebappPath() + filePath)
            if (!file.exists()) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND)
                return
            }
            //HashMap should have storename added
            var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            //BasicArrayList roleVector = new BasicArrayListD();
            var authenticationHelper : AuthenticationHelper = new AuthenticationHelperFactory().getInstance(hashMap, request).asInstanceOf[AuthenticationHelper]
            //if (authenticationHelper.isAuthenticationSessionValid(roleVector) == Boolean.TRUE)
            if (authenticationHelper.isAuthenticated()) {
                if (AuthenticationHelperUtil.getInstance().isAuthorized(authenticationHelper, filePath)) {
                    inputStream = CloudStreamUtil.getInstance().getFile(file)
                    var contentType : String = getServletContext().getMimeType(file.getName())
                    //application/x-www-form-urlencoded
                    if (contentType == null) {
                        contentType = "application/octet-stream"
                    }
                    response.reset()
                    response.setBufferSize(this.DEFAULT_BUFFER_SIZE)
                    response.setContentType(contentType)
                    response.setHeader("Content-Length", String.valueOf(file.length()))
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("attachment; filename=\"")
                    stringBuffer.append(file.getName())
                    stringBuffer.append(CommonSeps.getInstance().QUOTE)
                    response.setHeader("Content-Disposition", stringBuffer.toString())
                    StreamUtil.getInstance().get(inputStream, response.getOutputStream(), new Array[Byte](16348))
                } else {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are not Authorized")
                }
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Please Login")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "processRequest()", e)
                }
                response.sendError(HttpServletResponse.SC_NOT_FOUND)
            }
        } finally {
            StreamUtil.getInstance().close(response.getOutputStream())
            if (!StreamUtil.getInstance().close(inputStream)) {
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
        return "Serves Up Cloud Files"
    }

}


