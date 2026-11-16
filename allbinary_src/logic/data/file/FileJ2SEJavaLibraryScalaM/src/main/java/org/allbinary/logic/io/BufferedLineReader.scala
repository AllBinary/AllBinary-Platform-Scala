/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.BufferedReader
import _root_.java.io.FileReader
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.AbFileNativeUtil

class BufferedLineReader(param_file : AbFile) {

    private var tmpIn : BufferedReader = null

    //Constructor
    {
        val file : AbFile = param_file
        this.tmpIn = new BufferedReader(new FileReader(AbFileNativeUtil.get(file)))
    }

    //If the readahead is less than 2 lines then this will only work some of the time
    def readUpToLines(readAheadIndex : Long) : Unit = {
    }

    def readLine() : String = {
        return this.tmpIn.readLine()
    }

    //True while the file has more lines so callers do not need a null readLine
    def ready() : Boolean = {
        return this.tmpIn.ready()
    }

    def getSize() : Long = {
        return 0
    }

    def getCurrent() : Int = {
        return 0
    }

}


