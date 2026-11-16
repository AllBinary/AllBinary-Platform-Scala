/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.path

import _root_.org.allbinary.logic.io.file.FilePathData
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps

class AbPathData private() {
    import _root_.org.allbinary.logic.io.path.AbPathData.{*}

    val EXTENSION_SEP : String = CommonSeps.getInstance().PERIOD

    val SEPARATORCHAR : Char = '/'

    val SEPARATOR : String = CommonSeps.getInstance().FORWARD_SLASH

}

object AbPathData {
    private val instance : AbPathData = new AbPathData()

    def getInstance() : AbPathData = {
        return AbPathData.instance
    }

}


