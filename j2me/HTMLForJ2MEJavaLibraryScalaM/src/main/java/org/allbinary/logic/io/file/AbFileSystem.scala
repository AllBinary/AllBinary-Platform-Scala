/*  * AllBinary Open License Version 1  * Copyright (c) 2026 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file

import _root_.java.io.InputStream
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

//HTMLForJ2ME
class AbFileSystem {
    import _root_.org.allbinary.logic.io.file.AbFileSystem.{*}

    private val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    def isDirectoryOrFile(path : String) : Boolean = {
        //For HTML Use FileReader API
        return false
    }

    def isDirectory(path : String) : Boolean = {
        //For HTML Use FileReader API
        return false
    }

    def getFilesAsStringArrayForPath(currentDirPath : String) : Array[String] = {
        //For HTML Use FileReader API
        return StringUtil.getInstance().getArrayInstance()
    }

    def readAsString(fileName : String) : String = {
        val bytes : Array[Byte] = new Array[Byte](1000000)
        return this.readAsString(fileName, bytes)
    }

    def readAsString(fileName : String, bytes : Array[Byte]) : String = {
        //TODO - Use JSR 75 here
        return StringUtil.getInstance().EMPTY_STRING
    }

    def close(closeable : Object) : Boolean = {
        try {
            if (closeable != null) {
                //this.logUtil.putF("Closing: " + closeable, this, CLOSE);
                val inputStream : InputStream = (closeable.asInstanceOf[InputStream])
                inputStream.close()
            }
            return true
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CLOSE, e)
                return false
            }
        }
        throw new IllegalStateException()
    }

}

object AbFileSystem {
    private val instance : AbFileSystem = new AbFileSystem()

    def getInstance() : AbFileSystem = {
        return AbFileSystem.instance
    }

}


