/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.globals

import _root_.org.allbinary.logic.string.StringUtil

class UrlGlobalsInterface {

    def getMainPath() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    def getTestHtmlPath() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    def getWebappPath() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    def isTestingMode() : Boolean = {
        return false
    }

}


