/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file

import _root_.java.io.File

class FilePathData private() {
    import _root_.org.allbinary.logic.io.file.FilePathData.{*}

    //final
    val SEPARATORCHAR : Char = File.separatorChar

    var PATH_START : String = File.separator

    //Constructor
    {
        if (File.separatorChar == '\\') {
            this.PATH_START = File.separator + File.separator
        }
    }

}

object FilePathData {
    private val instance : FilePathData = new FilePathData()

    /**      * @return the instance      */
    def getInstance() : FilePathData = {
        return FilePathData.instance
    }

}


