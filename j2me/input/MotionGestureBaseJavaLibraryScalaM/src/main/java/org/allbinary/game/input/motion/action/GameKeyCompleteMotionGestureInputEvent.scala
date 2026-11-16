/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.motion.action

import _root_.org.allbinary.game.input.CompleteMotionGestureInputEvent
import _root_.org.allbinary.game.input.GameKey
import _root_.org.allbinary.game.input.GameKeyEventSourceInterface
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.input.event.GameKeyEventFactory
import _root_.org.allbinary.game.input.mapping.InputToGameKeyMapping
import _root_.org.allbinary.input.motion.gesture.MotionGestureInput
import _root_.org.allbinary.string.CommonStrings

class GameKeyCompleteMotionGestureInputEvent(param_name : String, param_motionGestureInput : MotionGestureInput, param_inputToGameKeyMapping : InputToGameKeyMapping) extends CompleteMotionGestureInputEvent(param_name, param_motionGestureInput) with GameKeyEventSourceInterface {

    private val gameKeyEventFactory : GameKeyEventFactory = GameKeyEventFactory.getInstance()

    private val SOURCE_ID : Int = this.gameKeyEventFactory.MOTION_GESTURE_SOURCE_ID

    private var gameKey : GameKey = GameKey.NULL_GAME_KEY

    private var gameKeyEvent : GameKeyEvent = GameKeyEvent.NONE

    private var inputToGameKeyMapping : InputToGameKeyMapping = null

    //Constructor
    {
        val name : String = param_name
        val motionGestureInput : MotionGestureInput = param_motionGestureInput
        val inputToGameKeyMapping : InputToGameKeyMapping = param_inputToGameKeyMapping
        this.inputToGameKeyMapping = inputToGameKeyMapping
        GameKeyCompleteMotionGestureInputEventFactory.getInstance().add(this)
        this.update()
    }

    override def getSourceId() : Int = {
        return this.SOURCE_ID
    }

    def update() : Unit = {
        try {
            this.setGameKey(this.inputToGameKeyMapping.getInstance(this.getMotionGestureInput().getId()))
            this.setGameKeyEvent(this.gameKeyEventFactory.getInstanceForInput(this, this.getGameKey()))
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.UPDATE, e)
            }
        }
    }

    def setGameKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = {
        this.gameKeyEvent = gameKeyEvent
    }

    def getGameKeyEvent() : GameKeyEvent = {
        return this.gameKeyEvent
    }

    def setGameKey(gameKey : GameKey) : Unit = {
        this.gameKey = gameKey
    }

    def getGameKey() : GameKey = {
        return this.gameKey
    }

}


