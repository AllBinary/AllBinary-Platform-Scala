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
import _root_.org.allbinary.logic.communication.http.file.upload.FileUploadData
import _root_.org.allbinary.logic.communication.http.file.upload.HttpFileUploadUtil
import _root_.org.allbinary.logic.communication.http.request.HttpRequestUtil
import _root_.org.allbinary.logic.communication.http.request.MultipartRequestParams
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.AbFileOutputStream
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.servlet.BlisketServletUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.apache.commons.fileupload.FileItem

/**  *  * @author user  *  */
class UploadFileServlet extends HttpServlet {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    //private final int DEFAULT_BUFFER_SIZE = 16384;
    var requestHashMap : HashMap[Object, Object] = null

    private var fileName : String = null

    def processRequest(request : HttpServletRequest, response : HttpServletResponse) : Unit = {
        var isError : Boolean = false
        var inputStream : InputStream = null
        try {
            //response.getOutputStream().write("OK!".getBytes());
            BlisketServletUtil.getInstance().init(request)
            this.requestHashMap = new MultipartRequestParams(request).toHashMap().asInstanceOf[HashMap[Object, Object]]
            var filePath : String = this.requestHashMap.get(FileUploadData.getInstance().UPLOAD_TO_FILE_PATH).asInstanceOf[String]
            if (filePath == null) {
                isError = true
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
                    //Save File
                    this.saveFile(filePath)
                    response.setContentType("text/plain")
                    response.getOutputStream().write("OK!".getBytes())
                } else {
                    isError = true
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are not Authorized")
                }
            } else {
                isError = true
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Please Login")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "processRequest()", e)
                }
                isError = true
                response.sendError(HttpServletResponse.SC_NOT_FOUND)
            }
        } finally {
            if (!isError) {
                StreamUtil.getInstance().close(response.getOutputStream())
            }
            if (!StreamUtil.getInstance().close(inputStream)) {
            }
        }
    }

    private def saveFile(param_filePath : String) : Unit = {
        var filePath : String = param_filePath
        var fileOutputStream : AbFileOutputStream = null
        try {
            var fileItem : FileItem = this.requestHashMap.get(FileUploadData.getInstance().FILE_DATA).asInstanceOf[FileItem]
            if ((fileItem != null) && (fileItem.getSize() > 1)) {
                this.fileName = HttpRequestUtil.getInstance().generateFileName(fileItem.getName())
                if (filePath.endsWith("/") || filePath.endsWith("\\")) {
                    filePath = filePath + this.fileName
                }
                val file : AbFile = AbFile.createAbFile(URLGLOBALS.getWebappPath() + filePath)
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                    val stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Uploaded File: ")
                    stringBuffer.append(this.fileName)
                    stringBuffer.append(" New File: ")
                    stringBuffer.append(file.getPath())
                    this.logUtil.putF(stringBuffer.toString(), this, "saveFile()")
                }
                HttpFileUploadUtil.log(fileItem)
                //Now that file checks out write it to file
                val byteArray : Array[Byte] = fileItem.get()
                if (file.isFile()) {
                    file.delete()
                    file.createNewFile()
                }
                fileOutputStream = AbFileOutputStream.createFromAbFile(file)
                fileOutputStream.write(byteArray)
            }
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close()
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
        return "Upload Cloud Files"
    }

}


