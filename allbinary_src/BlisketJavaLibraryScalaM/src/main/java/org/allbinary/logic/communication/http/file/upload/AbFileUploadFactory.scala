/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.file.upload

import _root_.java.util.ArrayList
import _root_.java.util.List
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.logic.communication.http.AbFileItemFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.apache.commons.fileupload.FileItemIterator
import _root_.org.apache.commons.fileupload.FileItemStream
import _root_.org.apache.commons.fileupload.FileItemUtil

class AbFileUploadFactory private() {
    import _root_.org.allbinary.logic.communication.http.file.upload.AbFileUploadFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getFileItemStreamList(httpServletRequest : HttpServletRequest) : List[Object] = {
        try {
            var fileUpload : AbFileUpload = new AbFileUpload(new AbFileItemFactory())
            var iterator : FileItemIterator = fileUpload.getItemIterator(httpServletRequest)
            var items : List[Object] = new ArrayList[Object]()

            {
                while (iterator.hasNext()) {
                    var fileItemStream : FileItemStream = iterator.next()
                    HttpFileUploadUtil.log(fileItemStream)
                    var fileItem : AbFileItem = new AbFileItem(fileItemStream.getName(), fileItemStream.getFieldName(), FileItemUtil.getInstance().getBytes(fileItemStream))
                    items.add(fileItem)
                }
            }
            return items
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, "get()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    //Returns a list of FileItems
    def getFileItemList(httpServletRequest : HttpServletRequest) : List[Object] = {
        try {
            var abFileUpload : AbFileUpload = new AbFileUpload(new AbFileItemFactory())
            return abFileUpload.parseRequest(httpServletRequest)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "get()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object AbFileUploadFactory {
    private val instance : AbFileUploadFactory = new AbFileUploadFactory()

    def getInstance() : AbFileUploadFactory = {
        return AbFileUploadFactory.instance
    }

}


