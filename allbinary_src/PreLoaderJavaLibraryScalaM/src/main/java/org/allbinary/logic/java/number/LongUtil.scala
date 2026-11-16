/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.number

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonPhoneStrings

class LongUtil private() {
    import _root_.org.allbinary.logic.java.number.LongUtil.{*}

}

object LongUtil {
    def fillIn(end : String) : String = {
        val frameStringBuffer : StringMaker = new StringMaker()
        if (frameStringBuffer.length() < LongData.MAX_LONG_LENGTH) {
            val commonPhoneStrings : CommonPhoneStrings = CommonPhoneStrings.getInstance()
            val size : Int = LongData.MAX_LONG_LENGTH - frameStringBuffer.length()

            {
                var index : Int = 0
                while (index < size) {
                    frameStringBuffer.append(commonPhoneStrings.ZERO)
                    index += 1
                }
            }
        }
        frameStringBuffer.append(end)
        return frameStringBuffer.toString()
    }

}


