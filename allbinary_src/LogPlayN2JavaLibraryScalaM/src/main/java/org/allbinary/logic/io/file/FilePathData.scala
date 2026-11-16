/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file

import _root_.jsinterop.annotations.JsType

@JsType
class FilePathData private() {
    import _root_.org.allbinary.logic.io.file.FilePathData.{*}

    //final
    val SEPARATORCHAR : Char = '\\'

    var PATH_START : String = "\\\\"

}

object FilePathData {
    private val instance : FilePathData = new FilePathData()

    /**      * @return the instance      */
    def getInstance() : FilePathData = {
        return FilePathData.instance
    }

}


