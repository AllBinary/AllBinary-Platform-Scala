/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.javax.microedition.media.Control
import _root_.org.allbinary.logic.string.StringUtil

class NoPlayer() extends BasicPlayer {
    import _root_.org.allbinary.media.audio.NoPlayer.{NO_PLAYER as _, *}
    def NO_PLAYER : NoPlayer = _root_.org.allbinary.media.audio.NoPlayer.NO_PLAYER

    override def close() : Unit = {
    }

    override def getContentType() : String = {
        return StringUtil.getInstance().NULL_STRING
    }

    override def getControl(controlType : String) : Control = {
        return new NullControl()
    }

    override def getControls() : Array[Control] = {
        return new Array[Control](0)
    }

}

object NoPlayer {
    val NO_PLAYER : NoPlayer = new NoPlayer()

}


