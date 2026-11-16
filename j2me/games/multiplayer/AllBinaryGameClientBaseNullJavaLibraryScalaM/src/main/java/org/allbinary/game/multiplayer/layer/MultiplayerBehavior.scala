/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.multiplayer.layer

import _root_.org.allbinary.logic.string.StringUtil

class MultiplayerBehavior(param_username : String) {
    import _root_.org.allbinary.game.multiplayer.layer.MultiplayerBehavior.{NULL_MULTIPLAYER_BEHAVIOR as _, *}
    def NULL_MULTIPLAYER_BEHAVIOR : MultiplayerBehavior = _root_.org.allbinary.game.multiplayer.layer.MultiplayerBehavior.NULL_MULTIPLAYER_BEHAVIOR

    //Constructor
    {
        val username : String = param_username
    }

    def startTick() : Unit = {
    }

    def endTick() : Unit = {
    }

    def getApproximateElapsed() : Long = {
        return 0
    }

}

object MultiplayerBehavior {
    val NULL_MULTIPLAYER_BEHAVIOR : MultiplayerBehavior = new MultiplayerBehavior(StringUtil.getInstance().EMPTY_STRING)

}


