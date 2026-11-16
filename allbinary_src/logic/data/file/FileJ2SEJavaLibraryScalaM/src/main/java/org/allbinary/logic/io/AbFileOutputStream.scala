/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.FileNotFoundException
import _root_.java.io.FileOutputStream
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.AbFileNativeUtil

class AbFileOutputStream(param_name : String, param_append : Boolean) extends FileOutputStream(param_name, param_append) {
    import _root_.org.allbinary.logic.io.AbFileOutputStream.{*}

    //    }
    //Constructor
    {
        val name : String = param_name
        val append : Boolean = param_append
    }

}

object AbFileOutputStream {
    def createFromAbFile(file : AbFile) : AbFileOutputStream = {
        return new AbFileOutputStream(file.getPath(), false)
    }

    def createFromAbFileAppend(file : AbFile, append : Boolean) : AbFileOutputStream = {
        return new AbFileOutputStream(file.getPath(), append)
    }

    def createFromFilePath(name : String) : AbFileOutputStream = {
        return new AbFileOutputStream(name, false)
    }

    def createFromFilePathAppend(name : String, append : Boolean) : AbFileOutputStream = {
        return new AbFileOutputStream(name, append)
    }

}


