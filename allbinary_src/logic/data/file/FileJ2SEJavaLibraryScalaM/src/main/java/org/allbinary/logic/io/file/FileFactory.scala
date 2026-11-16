/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file


class FileFactory {
    import _root_.org.allbinary.logic.io.file.FileFactory.{*}

    def getInstance(filePath : String) : AbFile = {
        return AbFile.createAbFileFromRawPath(filePath)
    }

    def getInstance(file : AbFile, childFilePath : String) : AbFile = {
        return AbFile.createAbFileWithChild(file, childFilePath)
    }

    def isFile(path : String) : Boolean = {
        var file : AbFile = AbFile.createAbFile(path)
        if (file.exists()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}

object FileFactory {
    private val instance : FileFactory = new FileFactory()

    /**      * @return the instance      */
    def getInstance() : FileFactory = {
        return FileFactory.instance
    }

}


