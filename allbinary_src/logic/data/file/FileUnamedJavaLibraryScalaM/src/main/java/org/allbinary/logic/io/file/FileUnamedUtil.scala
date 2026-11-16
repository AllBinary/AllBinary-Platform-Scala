/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file

import _root_.org.allbinary.string.CommonSeps

/**  *  * @author User  */
class FileUnamedUtil {
    import _root_.org.allbinary.logic.io.file.FileUnamedUtil.{*}

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    def process(string : String) : String = {
        var simplifiedString : String = string.toLowerCase()
        simplifiedString = simplifiedString.replace(this.commonSeps.SPACE, this.commonSeps.UNDERSCORE)
        simplifiedString = simplifiedString.replace(this.commonSeps.DASH, this.commonSeps.UNDERSCORE)
        return simplifiedString
    }

}

object FileUnamedUtil {
    private val instance : FileUnamedUtil = new FileUnamedUtil()

    /**      * @return the instance      */
    def getInstance() : FileUnamedUtil = {
        return FileUnamedUtil.instance
    }

}


