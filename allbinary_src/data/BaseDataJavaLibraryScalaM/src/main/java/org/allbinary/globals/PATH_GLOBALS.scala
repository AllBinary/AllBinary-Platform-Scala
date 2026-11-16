/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.globals

import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings

class PATH_GLOBALS private() {
    import _root_.org.allbinary.globals.PATH_GLOBALS.{*}

    var DATA_PATH : String = null

    var INIT_PATH : String = null

    var VIEWS_PATH : String = null

    var LOG_PATH : String = null

    var BACKUP_PATH : String = null

    //Constructor
    {
        val stringBuffer : StringMaker = new StringMaker()
        val abPathData : AbPathData = AbPathData.getInstance()
        stringBuffer.append("data")
        stringBuffer.append(abPathData.SEPARATOR)
        this.DATA_PATH = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(this.DATA_PATH)
        stringBuffer.append(CommonStrings.getInstance().INIT)
        stringBuffer.append(abPathData.SEPARATOR)
        this.INIT_PATH = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(this.DATA_PATH)
        stringBuffer.append("log")
        stringBuffer.append(abPathData.SEPARATOR)
        this.LOG_PATH = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(this.DATA_PATH)
        stringBuffer.append("backup")
        stringBuffer.append(abPathData.SEPARATOR)
        this.BACKUP_PATH = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(this.INIT_PATH)
        stringBuffer.append("views")
        stringBuffer.append(abPathData.SEPARATOR)
        this.VIEWS_PATH = stringBuffer.toString()
    }

}

object PATH_GLOBALS {
    private val instance : PATH_GLOBALS = new PATH_GLOBALS()

    def getInstance() : PATH_GLOBALS = {
        return PATH_GLOBALS.instance
    }

}


