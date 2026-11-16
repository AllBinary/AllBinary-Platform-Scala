/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.javax.microedition.media.Player
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class PlayerStateUtil {
    import _root_.org.allbinary.media.audio.PlayerStateUtil.{*}

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    val UNREALIZED : String = "UNREALIZED"

    val REALIZED : String = "REALIZED"

    val PREFETCHED : String = "PREFETCHED"

    val STARTED : String = "STARTED"

    val CLOSED : String = "CLOSED"

    def convert(state : Int) : String = {
        if (state == Player.UNREALIZED) {
            return this.UNREALIZED
        } else if (state == Player.REALIZED) {
            return this.REALIZED
        } else if (state == Player.PREFETCHED) {
            return this.PREFETCHED
        } else if (state == Player.STARTED) {
            return this.STARTED
        } else if (state == Player.CLOSED) {
            return this.CLOSED
        }
        return this.commonStrings.UNKNOWN
    }

}

object PlayerStateUtil {
    private val instance : PlayerStateUtil = new PlayerStateUtil()

    /**      * @return the instance      */
    def getInstance() : PlayerStateUtil = {
        return PlayerStateUtil.instance
    }

}


