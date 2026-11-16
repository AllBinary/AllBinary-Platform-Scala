/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.globals

import _root_.org.allbinary.logic.string.StringUtil

//implements
class AppUrlGlobals extends UrlGlobalsInterface {
    import _root_.org.allbinary.globals.AppUrlGlobals.{NULL_APP_URL_GLOBALS as _, *}
    def NULL_APP_URL_GLOBALS : AppUrlGlobals = _root_.org.allbinary.globals.AppUrlGlobals.NULL_APP_URL_GLOBALS

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var path : String = StringUtil.getInstance().EMPTY_STRING

    override def isTestingMode() : Boolean = {
        return false
    }

    override def getWebappPath() : String = {
        return this.path
    }

    def setWebappPath(path : String) : Unit = this.synchronized {
        this.path = path
        if (!(this.path.endsWith("\\") || this.path.endsWith("/"))) {
            this.path = this.path + "\\"
        }
    }

    override def getTestHtmlPath() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    override def getMainPath() : String = {
        return this.path
    }

}

object AppUrlGlobals {
    val NULL_APP_URL_GLOBALS : AppUrlGlobals = new AppUrlGlobals()

}


