/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.path.AbPath

class FileStreamFactory private() {
    import _root_.org.allbinary.logic.io.FileStreamFactory.{*}

    def getFileInputStreamInstance(path : String, fileName : String) : AbFileInputStream = {
        val FILEABPATH : AbPath = new AbPath(path, fileName)
        val file : AbFile = AbFile.createAbFileFromAbPath(FILEABPATH)
        return AbFileInputStream.createFromAbFile(file)
    }

    def getFileOutputStreamInstance(path : String, fileName : String) : AbFileOutputStream = {
        val FILEABPATH : AbPath = new AbPath(path, fileName)
        val file : AbFile = AbFile.createAbFileFromAbPath(FILEABPATH)
        if (file.exists()) {
            file.delete()
            file.createNewFile()
        }
        return AbFileOutputStream.createFromAbFile(file)
    }

    def delete(path : String, fileName : String) : Unit = {
        val FILEABPATH : AbPath = new AbPath(path, fileName)
        val file : AbFile = AbFile.createAbFileFromAbPath(FILEABPATH)
        file.delete()
    }

}

object FileStreamFactory {
    private var SINGLETON : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : FileStreamFactory = {
        if (FileStreamFactory.SINGLETON eq NullUtil.getInstance().NULL_OBJECT) {
            FileStreamFactory.SINGLETON = new FileStreamFactory()
        }
        return FileStreamFactory.SINGLETON.asInstanceOf[FileStreamFactory]
    }

}


