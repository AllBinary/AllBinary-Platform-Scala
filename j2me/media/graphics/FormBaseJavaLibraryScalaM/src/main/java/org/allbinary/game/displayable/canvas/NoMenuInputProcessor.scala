/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.NullCanvas
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.input.motion.gesture.observer.MotionGestureEvent
import _root_.org.allbinary.util.BasicArrayListUtil

class NoMenuInputProcessor private() extends BasicMenuInputProcessor(BasicArrayListUtil.getInstance().getImmutableInstance(), -1, NullCanvas.NULL_CANVAS) {
    import _root_.org.allbinary.game.displayable.canvas.NoMenuInputProcessor.{*}

    override def onDownGameKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
    }

    override def onUpGameKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
    }

    override def onMotionGestureEvent(motionGestureEvent : MotionGestureEvent) : Unit = {
    }

}

object NoMenuInputProcessor {
    private val SINGLETON : NoMenuInputProcessor = new NoMenuInputProcessor()

    def getInstance() : NoMenuInputProcessor = {
        return NoMenuInputProcessor.SINGLETON
    }

}


