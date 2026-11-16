/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.file.upload

import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.path.AbPath

class HttpFilePermissionsUtil {
    import _root_.org.allbinary.logic.communication.http.file.upload.HttpFilePermissionsUtil.{*}

    def create(path : AbPath) : Unit = {
        var file : AbFile = AbFile.createAbFileFromAbPath(path)
        if (!file.isFile()) {
            file.createNewFile()
        }
    }

}

object HttpFilePermissionsUtil {
    private val instance : HttpFilePermissionsUtil = new HttpFilePermissionsUtil()

    /**      * @return the instance      */
    def getInstance() : HttpFilePermissionsUtil = {
        return HttpFilePermissionsUtil.instance
    }

}


