/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.globals

import _root_.org.allbinary.business.init.InitInfo
import _root_.org.allbinary.logic.string.StringValidationUtil

class WebAppUrlGlobals extends UrlGlobalsInterface {

    private var path : String = null

    private var isWebappPathSet : Boolean = false

    override def isTestingMode() : Boolean = {
        return InitInfo.getInstance().isTesting()
    }

    override def getWebappPath() : String = {
        return this.path
    }

    def setWebappPath(param_path : String) : Unit = this.synchronized {
        var path : String = param_path
        path = path
        this.isWebappPathSet = true
    }

    override def getTestHtmlPath() : String = {
        return InitInfo.getInstance().getTestHtmlPath()
    }

    override def getMainPath() : String = {
        var mainPath : String = InitInfo.getInstance().getMainPath()
        if (!StringValidationUtil.getInstance().isEmpty(mainPath)) {
            return mainPath
        } else if (this.isWebappPathSet) {
            return this.getWebappPath()
        } else {
            throw new Exception("Webapp Path is not set")
        }
        throw new IllegalStateException()
    }

}


