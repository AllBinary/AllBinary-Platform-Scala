/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.globals

import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker

class FREEBLISKET_PATH_GLOBALS private() {
    import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS.{*}

    //public static final String SERIALPATH = "serializeddata" + PathData.SEPARATOR;
    var INSTALLPATH : String = null

    var XSLPATH : String = null

    val TEMPLATEPATH : String = "template" + AbPathData.getInstance().SEPARATOR

    val STYLEPATH : String = (this.TEMPLATEPATH + "style") + AbPathData.getInstance().SEPARATOR

    val THEMEPATH : String = (this.STYLEPATH + "theme") + AbPathData.getInstance().SEPARATOR

    val DBINITPATH : String = (PATH_GLOBALS.getInstance().INIT_PATH + "db") + AbPathData.getInstance().SEPARATOR

    val LINEDATAPATH : String = (PATH_GLOBALS.getInstance().INIT_PATH + "lineData") + AbPathData.getInstance().SEPARATOR

    var CONFIGURATIONPATH : String = null

    var USERCONFIGURATIONPATH : String = null

    var CONTEXTCONFIGURATIONPATH : String = null

    val LICENSEERRORPAGE : String = "LicensingError.jsp"

    val ERRORPAGE : String = "Error.jsp"

    //Constructor
    {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("install")
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        this.INSTALLPATH = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(PATH_GLOBALS.getInstance().INIT_PATH)
        stringBuffer.append("views")
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        this.XSLPATH = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(this.XSLPATH)
        stringBuffer.append("configuration")
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        this.CONFIGURATIONPATH = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(this.CONFIGURATIONPATH)
        stringBuffer.append("user")
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        this.USERCONFIGURATIONPATH = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(this.CONFIGURATIONPATH)
        stringBuffer.append("context")
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        this.CONTEXTCONFIGURATIONPATH = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
    }

}

object FREEBLISKET_PATH_GLOBALS {
    private val instance : FREEBLISKET_PATH_GLOBALS = new FREEBLISKET_PATH_GLOBALS()

    def getInstance() : FREEBLISKET_PATH_GLOBALS = {
        return FREEBLISKET_PATH_GLOBALS.instance
    }

}


