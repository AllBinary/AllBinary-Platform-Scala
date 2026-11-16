/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.org.allbinary.logic.io.file.AbFile

class DataOutputStreamFactory {
    import _root_.org.allbinary.logic.io.DataOutputStreamFactory.{*}

    def getInstanceForAbFile(file : AbFile) : AbDataOutputStream = {
        val idFileOutputStream : AbFileOutputStream = AbFileOutputStream.createFromAbFile(file)
        val idOutData : AbDataOutputStream = new AbDataOutputStream(idFileOutputStream)
        return idOutData
    }

    def getInstance(filePath : String, fileName : String) : AbDataOutputStream = {
        val fileStreamFactory : FileStreamFactory = FileStreamFactory.getInstance()
        val fileOutputStream : AbFileOutputStream = fileStreamFactory.getFileOutputStreamInstance(filePath, fileName)
        var idOutData : AbDataOutputStream = new AbDataOutputStream(fileOutputStream)
        return idOutData
    }

}

object DataOutputStreamFactory {
    private val instance : DataOutputStreamFactory = new DataOutputStreamFactory()

    /**      * @return the instance      */
    def getInstance() : DataOutputStreamFactory = {
        return DataOutputStreamFactory.instance
    }

}


