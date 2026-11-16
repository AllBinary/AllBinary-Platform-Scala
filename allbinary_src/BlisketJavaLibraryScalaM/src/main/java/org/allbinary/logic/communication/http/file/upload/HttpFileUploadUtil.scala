/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.file.upload

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.anyType.clazz.ClassUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps
import _root_.org.apache.commons.fileupload.FileItem
import _root_.org.apache.commons.fileupload.FileItemStream

class HttpFileUploadUtil private() {
    import _root_.org.allbinary.logic.communication.http.file.upload.HttpFileUploadUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def isValid(anyType : Object) : Boolean = {
        if ((anyType != null) && !(anyType.isInstanceOf[String])) {
            if (anyType.isInstanceOf[FileItem]) {
                return true
            } else {
                throw new Exception("Object Not Instance Of FileItem but is: " + ClassUtil.viewAll(anyType, CommonSeps.getInstance().NEW_LINE))
            }
        }
        return false
    }

}

object HttpFileUploadUtil {
    private val instance : HttpFileUploadUtil = new HttpFileUploadUtil()

    /**      * @return the instance      */
    def getInstance() : HttpFileUploadUtil = {
        return HttpFileUploadUtil.instance
    }

    def log(fileItem : FileItemStream) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        stringBuffer.append("FileItem Log:")
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append("Content Type:")
        stringBuffer.append(fileItem.getContentType())
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append("Field Name:")
        stringBuffer.append(fileItem.getFieldName())
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append("Name:")
        stringBuffer.append(fileItem.getName())
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append("Size:")
        //result.append(fileItem.openStream().available());
        stringBuffer.append(" Not Calculated Yet")
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTP)) {
            logUtil.putF(stringBuffer.toString(), getInstance(), "log()")
        }
    }

    def log(fileItem : FileItem) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        stringBuffer.append("FileItem Log:")
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append("Content Type:")
        stringBuffer.append(fileItem.getContentType())
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append("Field Name:")
        stringBuffer.append(fileItem.getFieldName())
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append("Name:")
        stringBuffer.append(fileItem.getName())
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append("Size:")
        stringBuffer.appendlong(fileItem.getSize())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            logUtil.putF(stringBuffer.toString(), getInstance(), "log()")
        }
    }

}


