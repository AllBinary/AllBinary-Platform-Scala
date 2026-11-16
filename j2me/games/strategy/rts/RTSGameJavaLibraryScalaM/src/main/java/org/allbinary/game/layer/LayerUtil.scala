/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.util.ABHashtable

class LayerUtil {
    import _root_.org.allbinary.game.layer.LayerUtil.{*}

}

object LayerUtil {
    private val HASHTABLE : String = "Hashtable: "

    def toString(hashtable : ABHashtable[Object, Object], x : Int, y : Int, z : Int) : String = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val positionStrings : PositionStrings = PositionStrings.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(LayerUtil.HASHTABLE)
        stringBuffer.append(StringUtil.getInstance().toString(hashtable))
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(positionStrings.X_LABEL)
        stringBuffer.appendint(x)
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(positionStrings.Y_LABEL)
        stringBuffer.appendint(y)
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(positionStrings.Z_LABEL)
        stringBuffer.appendint(z)
        return stringBuffer.toString()
    }

}


