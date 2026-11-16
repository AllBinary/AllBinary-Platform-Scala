/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author user  */
class NoPlayerGameInput private() extends PlayerGameInput(new BasicArrayListD(), new BasicArrayListD(), -1) {
    import _root_.org.allbinary.game.input.NoPlayerGameInput.{*}

    override def onDownGameKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
    }

    override def onUpGameKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
    }

}

object NoPlayerGameInput {
    private val SINGLETON : NoPlayerGameInput = new NoPlayerGameInput()

    def getInstance() : NoPlayerGameInput = {
        return NoPlayerGameInput.SINGLETON
    }

}


