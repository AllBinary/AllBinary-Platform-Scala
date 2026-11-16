/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.request

import _root_.java.util.HashMap
import _root_.java.util.List
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.file.upload.AbFileUploadFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.apache.commons.fileupload.FileItem
import _root_.org.apache.commons.fileupload.FileUploadBase.InvalidContentTypeException

class MultipartRequestParams private () extends RequestParams {

    val logUtil_MultipartRequestParams : LogUtil = LogUtil.getInstance()

    private var special : Boolean = false

    def this(request : HttpServletRequest) = {
        this()
        this.processMultipartRequest(request)
    }

    def this(pageContext : PageContext) = {
        this()
        this.processMultipartRequest(pageContext.getRequest().asInstanceOf[HttpServletRequest])
    }

    def setSpecial() : Unit = {
        this.special = true
    }

    private def processMultipartRequest(request : HttpServletRequest) : Unit = {
        try {
            var specialRequest : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            var multipartRequestList : List[Object] = AbFileUploadFactory.getInstance().getFileItemStreamList(request).asInstanceOf[List[Object]]
            //List multipartRequestList = AbFileUploadFactory.getFileItemList(request);
            if (multipartRequestList != null) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                    this.logUtil_MultipartRequestParams.putF("FileItem List Size: " + multipartRequestList.size(), this, "processMultipartRequest()")
                }
                val fileItemArray : Array[Object] = multipartRequestList.toArray()
                val size : Int = fileItemArray.length

                {
                    var index : Int = 0
                    while (index < size) {
                        var fileItem : FileItem = fileItemArray(index).asInstanceOf[FileItem]
                        //Save normal input fields and ignore file since file size may may be too long
                        var name : String = fileItem.getName()
                        if (StringValidationUtil.getInstance().isEmpty(name)) {
                            specialRequest.put(fileItem.getFieldName(), fileItem.getString())
                        } else {
                            specialRequest.put(fileItem.getFieldName(), fileItem)
                        }
                        index += 1
                    }
                }
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                    this.logUtil_MultipartRequestParams.putF("Special Request Data: " + specialRequest.toString(), this, "processMultipartRequest()")
                }
                this.setSpecial()
                this.setMap(specialRequest)
            }
        } catch {
            case e : InvalidContentTypeException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                    this.logUtil_MultipartRequestParams.putF("Using Normal RequestParams", this, "processMultipartRequest()")
                }
                super.setMap(request.getParameterMap())
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUESTERROR)) {
                    this.logUtil_MultipartRequestParams.putF("Should Not Occur", this, "processMultipartRequest()")
                }
                super.setMap(request.getParameterMap())
            }
        }
    }

    override def toHashMap() : HashMap[Object, Object] = {
        if (this.special) {
            return this.getMap().asInstanceOf[HashMap[Object, Object]]
        } else {
            return super.toHashMap()
        }
        throw new IllegalStateException()
    }

}


