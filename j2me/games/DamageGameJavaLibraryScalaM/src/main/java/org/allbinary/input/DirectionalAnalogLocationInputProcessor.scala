/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input

import _root_.org.allbinary.android.input.motion.AnalogLocationInputProcessor
import _root_.org.allbinary.game.input.GameInputProcessor
import _root_.org.allbinary.game.input.GameKeyEventSourceInterface
import _root_.org.allbinary.game.input.GameKeyFactory
import _root_.org.allbinary.game.input.analog.AnalogLocationInput
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.input.event.GameKeyEventFactory
import _root_.org.allbinary.graphics.CustomGPoint
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class DirectionalAnalogLocationInputProcessor(param_inputProcessorArray : Array[GameInputProcessor]) extends AnalogLocationInputProcessor with GameKeyEventSourceInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var inputProcessorArray : Array[GameInputProcessor] = null

    private val gameKeyFactory : GameKeyFactory = GameKeyFactory.getInstance()

    private var leftGameKeyEvent : GameKeyEvent = GameKeyEvent.NONE

    private var rightGameKeyEvent : GameKeyEvent = GameKeyEvent.NONE

    private var upGameKeyEvent : GameKeyEvent = GameKeyEvent.NONE

    private var downGameKeyEvent : GameKeyEvent = GameKeyEvent.NONE

    private var leftTriggerGameKeyEvent : GameKeyEvent = GameKeyEvent.NONE

    private var rightTriggerGameKeyEvent : GameKeyEvent = GameKeyEvent.NONE

    //Constructor
    {
        val inputProcessorArray : Array[GameInputProcessor] = param_inputProcessorArray
        this.inputProcessorArray = inputProcessorArray
        try {
            this.leftGameKeyEvent = GameKeyEventFactory.getInstance().getInstanceForInput(this, this.gameKeyFactory.LEFT)
            this.rightGameKeyEvent = GameKeyEventFactory.getInstance().getInstanceForInput(this, this.gameKeyFactory.RIGHT)
            this.upGameKeyEvent = GameKeyEventFactory.getInstance().getInstanceForInput(this, this.gameKeyFactory.UP)
            this.downGameKeyEvent = GameKeyEventFactory.getInstance().getInstanceForInput(this, this.gameKeyFactory.DOWN)
            this.leftTriggerGameKeyEvent = GameKeyEventFactory.getInstance().getInstanceForInput(this, this.gameKeyFactory.KEY_NUM0)
            this.rightTriggerGameKeyEvent = GameKeyEventFactory.getInstance().getInstanceForInput(this, this.gameKeyFactory.KEY_NUM5)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e)
            }
        }
    }

    //private final String LEFT_TRIGGER_VALUE = "Left Trigger Value: ";    
    override def process(allbinaryLayerManager : AllBinaryLayerManager, analogLocationInput : AnalogLocationInput) : Unit = {
        try {
            var customGPoint : CustomGPoint = null
            customGPoint = analogLocationInput.getCustomGPoint()
            var x : Int = customGPoint.getX()
            var y : Int = customGPoint.getY()
            var leftTrigger : Int = analogLocationInput.getLeftTrigger()
            var rightTrigger : Int = analogLocationInput.getRightTrigger()
            if (x < 0) {
                this.inputProcessorArray(this.leftGameKeyEvent.getKey()).processAnalog(allbinaryLayerManager, this.leftGameKeyEvent, x)
            } else if (x > 0) {
                this.inputProcessorArray(this.rightGameKeyEvent.getKey()).processAnalog(allbinaryLayerManager, this.rightGameKeyEvent, x)
            }
            if (y < 0) {
                this.inputProcessorArray(this.downGameKeyEvent.getKey()).processAnalog(allbinaryLayerManager, this.downGameKeyEvent, y)
            } else if (y > 0) {
                this.inputProcessorArray(this.upGameKeyEvent.getKey()).processAnalog(allbinaryLayerManager, this.upGameKeyEvent, y)
            }
            //this.logUtil.putF(LEFT_TRIGGER_VALUE + leftTrigger, this, this.commonStrings.PROCESS);
            if (leftTrigger > 0) {
                this.inputProcessorArray(this.leftTriggerGameKeyEvent.getKey()).processAnalog(allbinaryLayerManager, this.leftTriggerGameKeyEvent, leftTrigger)
            }
            if (rightTrigger > 0) {
                this.inputProcessorArray(this.rightTriggerGameKeyEvent.getKey()).processAnalog(allbinaryLayerManager, this.rightTriggerGameKeyEvent, rightTrigger)
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put("Unable to process analog input", this, commonStrings.PROCESS, e)
            }
        }
    }

    override def getSourceId() : Int = {
        return 0
    }

}


