/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.motion.action

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class GameKeyCompleteMotionGestureInputEventFactory {
    import _root_.org.allbinary.game.input.motion.action.GameKeyCompleteMotionGestureInputEventFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val eventList : BasicArrayList = new BasicArrayListD()

    def add(gameKeyCompleteMotionGestureInputEvent : GameKeyCompleteMotionGestureInputEvent) : Unit = {
        this.eventList.add(gameKeyCompleteMotionGestureInputEvent)
    }

    def updateAll() : Unit = {
        this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().START_LABEL).appendint(this.eventList.size()).toString(), this, "updateAll")

        {
            var index : Int = this.eventList.size() - 1
            while (index >= 0) {
                var gameKeyCompleteMotionGestureInputEvent : GameKeyCompleteMotionGestureInputEvent = this.eventList.objectArray(index).asInstanceOf[GameKeyCompleteMotionGestureInputEvent]
                gameKeyCompleteMotionGestureInputEvent.update()
                index -= 1
            }
        }
    }

}

object GameKeyCompleteMotionGestureInputEventFactory {
    private val SINGLETON : GameKeyCompleteMotionGestureInputEventFactory = new GameKeyCompleteMotionGestureInputEventFactory()

    def getInstance() : GameKeyCompleteMotionGestureInputEventFactory = {
        return GameKeyCompleteMotionGestureInputEventFactory.SINGLETON
    }

}


