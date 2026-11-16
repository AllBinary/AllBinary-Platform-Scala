/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.path


/**  *  * @author User  */
class AbPathUtil {
    import _root_.org.allbinary.logic.io.path.AbPathUtil.{*}

    val NO_ABPATH : AbPath = AbPath.createAbPath()

}

object AbPathUtil {
    private val instance : AbPathUtil = new AbPathUtil()

    /**      * @return the instance      */
    def getInstance() : AbPathUtil = {
        return AbPathUtil.instance
    }

}


