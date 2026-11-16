/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.File
import _root_.java.io.FileInputStream
import _root_.java.io.FileNotFoundException
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.AbFileNativeUtil

class AbFileInputStream(param_name : String) extends FileInputStream(param_name) {
    import _root_.org.allbinary.logic.io.AbFileInputStream.{*}

    //Constructor
    {
        val name : String = param_name
    }

}

object AbFileInputStream {
    //An AbFile or File is opened by its path like FileInputStream(File) does.
    def createFromAbFile(file : AbFile) : AbFileInputStream = {
        return new AbFileInputStream(AbFileNativeUtil.get(file).getPath())
    }

    def createFromFile(file : File) : AbFileInputStream = {
        return new AbFileInputStream(file.getPath())
    }

}


