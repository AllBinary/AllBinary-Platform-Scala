/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.file.upload

import _root_.java.io.IOException
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.apache.commons.fileupload.FileItemFactory
import _root_.org.apache.commons.fileupload.FileItemIterator
import _root_.org.apache.commons.fileupload.FileUpload
import _root_.org.apache.commons.fileupload.FileUploadException
import _root_.org.apache.commons.fileupload.servlet.ServletRequestContext

class AbFileUpload(param_fileItemFactory : FileItemFactory) extends FileUpload(param_fileItemFactory) {

    //Constructor
    {
        val fileItemFactory : FileItemFactory = param_fileItemFactory
    }

    def getItemIterator(request : HttpServletRequest) : FileItemIterator = {
        return super.getItemIterator(new ServletRequestContext(request))
    }

}


