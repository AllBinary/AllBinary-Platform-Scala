/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.android.content.Context
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.logic.NullUtil

class FileStreamFactory private(param_context : Context) {
    import _root_.org.allbinary.logic.io.FileStreamFactory.{*}

    private var context : Object = null

    //Constructor
    {
        val context : Context = param_context
        this.context = context
    }

    def getFileInputStreamInstance(path : String, fileName : String) : AbFileInputStream = {
        return new AbFileInputStream(this.getContext().openFileInput(fileName))
    }

    def getFileOutputStreamInstance(path : String, fileName : String) : AbFileOutputStream = {
        val context : Context = this.getContext()
        context.deleteFile(fileName)
        return new AbFileOutputStream(context.openFileOutput(fileName, 0))
    }

    def delete(path : String, fileName : String) : Unit = {
        this.getContext().deleteFile(fileName)
    }

    private def getContext() : Context = {
        return this.context.asInstanceOf[Context]
    }

}

object FileStreamFactory {
    private var SINGLETON : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : FileStreamFactory = {
        if (FileStreamFactory.SINGLETON eq NullUtil.getInstance().NULL_OBJECT) {
            FileStreamFactory.SINGLETON = new FileStreamFactory(ResourceUtil.getInstance().getContext())
        }
        return FileStreamFactory.SINGLETON.asInstanceOf[FileStreamFactory]
    }

}


