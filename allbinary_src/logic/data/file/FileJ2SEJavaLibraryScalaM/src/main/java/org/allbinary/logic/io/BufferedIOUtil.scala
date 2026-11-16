/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.BufferedReader
import _root_.java.io.BufferedWriter
import _root_.java.io.FileReader
import _root_.java.io.FileWriter
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.AbFileNativeUtil
import _root_.org.allbinary.logic.string.StringUtil

/**  *  * @author user  */
class BufferedIOUtil {
    import _root_.org.allbinary.logic.io.BufferedIOUtil.{*}

}

object BufferedIOUtil {
    def copy(backupFile : AbFile, backupFileBak : AbFile) : Unit = {
        var line : String = StringUtil.getInstance().EMPTY_STRING
        val tmpOut : BufferedWriter = new BufferedWriter(new FileWriter(AbFileNativeUtil.get(backupFileBak)))
        val tmpIn : BufferedReader = new BufferedReader(new FileReader(AbFileNativeUtil.get(backupFile)))
        //ready instead of a null readLine so languages without null strings stop at the end of the file and not at an empty line

        {
            while (tmpIn.ready()) {
                line = tmpIn.readLine()
                tmpOut.write(line, 0, line.length())
                tmpOut.newLine()
            }
        }
        tmpOut.flush()
    }

}


