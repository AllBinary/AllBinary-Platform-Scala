/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.file.upload

import _root_.java.io.File
import _root_.java.io.IOException
import _root_.java.io.InputStream
import _root_.java.io.OutputStream
import _root_.java.io.UnsupportedEncodingException
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.apache.commons.fileupload.FileItem
import _root_.org.apache.commons.fileupload.FileItemHeaders
import _root_.org.apache.commons.fileupload.FileItemUtil

/**  *  * @author user  */
class AbFileItem(param_name : String, param_fieldName : String, param_byteArray : Array[Byte]) extends FileItem {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var name : String = null

    private var fieldName : String = null

    private var byteArray : Array[Byte] = null

    //Constructor
    {
        val name : String = param_name
        val fieldName : String = param_fieldName
        val byteArray : Array[Byte] = param_byteArray
        this.name = name
        this.fieldName = fieldName
        this.byteArray = byteArray
    }

    def getInputStream() : InputStream = {
        throw new IOException(this.commonStrings.NOT_IMPLEMENTED)
    }

    def getContentType() : String = {
        return null
    }

    def getName() : String = {
        return this.name
    }

    def isInMemory() : Boolean = {
        return true
    }

    def getSize() : Long = {
        return this.byteArray.length
    }

    def get() : Array[Byte] = {
        return this.byteArray
    }

    def getString(encoding : String) : String = {
        return new String(this.byteArray, encoding)
    }

    def getString() : String = {
        try {
            return FileItemUtil.getInstance().getString(this.byteArray)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getString", e)
                }
                return StringUtil.getInstance().EMPTY_STRING
            }
        }
        throw new IllegalStateException()
    }

    def write(file : File) : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def write(file : AbFile) : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def delete() : Unit = {
        ForcedLogUtil.log(this.commonStrings.NOT_IMPLEMENTED, "delete()")
    }

    def getFieldName() : String = {
        return this.fieldName
    }

    def setFieldName(name : String) : Unit = {
        this.fieldName = name
    }

    def isFormField() : Boolean = {
        if (StringValidationUtil.getInstance().isEmpty(this.fieldName)) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    def setFormField(state : Boolean) : Unit = {
    }

    def getOutputStream() : OutputStream = {
        throw new IOException(this.commonStrings.NOT_IMPLEMENTED)
    }

    def getHeaders() : FileItemHeaders = {
        throw new RuntimeException(this.commonStrings.NOT_IMPLEMENTED)
    }

    def setHeaders(fih : FileItemHeaders) : Unit = {
        throw new RuntimeException(this.commonStrings.NOT_IMPLEMENTED)
    }

}


