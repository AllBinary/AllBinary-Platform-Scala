/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.org.allbinary.logic.string.StringUtil

/**  *  * @author User  */
class NoSound private() extends Sound(StringUtil.getInstance().EMPTY_STRING) {
    import _root_.org.allbinary.media.audio.NoSound.{*}

    //Constructor
    {
        this.setPlayerP(NoPlayer.NO_PLAYER)
    }

}

object NoSound {
    /**      * @return the instance      */
    def getInstance() : NoSound = {
        return NoSound.instance
    }

    private val instance : NoSound = new NoSound()

}


