/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file

import _root_.java.io.File
import _root_.org.allbinary.logic.communication.log.PreLogUtil

class FileWrapperUtil {
    import _root_.org.allbinary.logic.io.file.FileWrapperUtil.{*}

}

object FileWrapperUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    def wrapFiles(files : Array[Object]) : Array[AbFile] = {
        try {
            val abFileArray : Array[AbFile] = new Array[AbFile](files.length)

            {
                var index : Int = files.length - 1
                while (index >= 0) {
                    abFileArray(index) = new AbFile(files(index).asInstanceOf[File])
                    index -= 1
                }
            }
            return abFileArray
        } catch {
            case e : Exception => {
                PreLogUtil.putSE("Exception Wrapping Files", "FileWrapperUtil", "wrapFiles", e)
                return new Array[AbFile](0)
            }
        }
        throw new IllegalStateException()
    }

    def wrapFile(file : File) : AbFile = {
        try {
            return new AbFile(file)
        } catch {
            case e : Exception => {
                PreLogUtil.putSE("Exception Wrapping File", "FileWrapperUtil", "wrapFile", e)
                return AbFile.NULL_FILE
            }
        }
        throw new IllegalStateException()
    }

}


