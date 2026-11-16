/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation

import _root_.org.allbinary.logic.io.file.FilePathData
import _root_.org.allbinary.logic.string.StringMaker

class ImageOutputData private() {
    import _root_.org.allbinary.input.automation.ImageOutputData.{SAVE_PATH as _, *}
    def SAVE_PATH : String = _root_.org.allbinary.input.automation.ImageOutputData.SAVE_PATH

}

object ImageOutputData {
    val SAVE_PATH : String = new StringMaker().append(System.getProperty("user.dir")).appendchar(FilePathData.getInstance().SEPARATORCHAR).append("saves").appendchar(FilePathData.getInstance().SEPARATORCHAR).toString()

}


