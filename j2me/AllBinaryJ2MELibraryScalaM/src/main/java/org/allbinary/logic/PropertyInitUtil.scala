/*  * AllBinary Open License Version 1  * Copyright (c) 2026 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class PropertyInitUtil {
    import _root_.org.allbinary.logic.PropertyInitUtil.{*}

}

object PropertyInitUtil {
    private val instance : PropertyInitUtil = new PropertyInitUtil()

    /**      * @return the instance      */
    def getInstance(value : Int) : PropertyInitUtil = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val logUtil : LogUtil = LogUtil.getInstance()
        logUtil.putF(new StringMaker().append("PropertyInitUtil: ").appendint(value).toString(), logUtil, commonStrings.CONSTRUCTOR)
        return PropertyInitUtil.instance
    }

}


