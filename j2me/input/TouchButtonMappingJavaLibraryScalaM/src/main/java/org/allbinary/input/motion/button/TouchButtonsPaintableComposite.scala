/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.game.input.CompleteMotionGestureInputEvent
import _root_.org.allbinary.game.input.CompleteMotionGestureInputEventHandler
import _root_.org.allbinary.game.input.CompleteMotionGestureInputEventListenerInterface
import _root_.org.allbinary.game.input.GameKey
import _root_.org.allbinary.game.input.mapping.InputMappingInterface
import _root_.org.allbinary.game.input.motion.action.GameKeyCompleteMotionGestureInputEvent
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.paint.ProcessPaintable
import _root_.org.allbinary.input.motion.gesture.MotionGestureInput
import _root_.org.allbinary.input.motion.gesture.TouchMotionGestureFactory
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.TimeDelayHelper

class TouchButtonsPaintableComposite(param_inputMappingInterface : InputMappingInterface, param_basicColor : BasicColor) extends ProcessPaintable with CompleteMotionGestureInputEventListenerInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var inputMappingInterface : InputMappingInterface = null

    //private MotionGestureInput previousMotionGestureInput;
    var touchButtonsPaintable : TouchButtonsMappingPaintable = null

    private var timeHelper : TimeDelayHelper = new TimeDelayHelper(250)

    private var released : Boolean = true

    private val METHOD_NAME : String = "onCompleteMotionGestureInputEvent"

    private val RELEASE : String = "Ignoring: MotionGestureInput Release"

    private val FAST_REPEAT : String = "Ignoring: MotionGestureInput Repeated To Quickly"

    private val IGNORE : String = "Ignoring: Until Released"

    //Constructor
    {
        val inputMappingInterface : InputMappingInterface = param_inputMappingInterface
        val basicColor : BasicColor = param_basicColor
        this.inputMappingInterface = inputMappingInterface
        CompleteMotionGestureInputEventHandler.getInstance().addListenerInterface(this)
        this.touchButtonsPaintable = new TouchButtonsMappingPaintable(basicColor)
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onCompleteMotionGestureInputEvent(completeMotionGestureInputEvent : CompleteMotionGestureInputEvent) : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "onCompleteMotionGestureInputEvent")
            val touchMotionGestureFactory : TouchMotionGestureFactory = TouchMotionGestureFactory.getInstance()
            val gameKeyCompleteMotionGestureInputEvent : GameKeyCompleteMotionGestureInputEvent = completeMotionGestureInputEvent.asInstanceOf[GameKeyCompleteMotionGestureInputEvent]
            val gameKey : GameKey = gameKeyCompleteMotionGestureInputEvent.getGameKey()
            val motionGestureInput : MotionGestureInput = completeMotionGestureInputEvent.getMotionGestureInput()
            //Ignore Release only motionGesture
            if (motionGestureInput eq touchMotionGestureFactory.RELEASED) {
                this.logUtil.putF(this.RELEASE, this, this.METHOD_NAME)
                this.released = true
                return
            }
            //if(previousMotionGestureInput == motionGestureInput && !this.timeHelper.isTime())
            if ((motionGestureInput eq TouchMotionGestureFactory.getInstance().NO_MOTION) && !this.timeHelper.isTimeTNT()) {
                this.logUtil.putF(this.FAST_REPEAT, this, this.METHOD_NAME)
                return
            }
            //if(motionGestureInput != TouchMotionGestureFactory.getInstance().TOUCH && !released)
            if (!this.released) {
                this.logUtil.putF(this.IGNORE, this, this.METHOD_NAME)
                return
            }
            this.released = false
            this.logUtil.putF(new StringMaker().append("GameKey: ").append(StringUtil.getInstance().toString(gameKey)).append(" MotionGestureInput: ").append(StringUtil.getInstance().toString(motionGestureInput)).toString(), this, this.METHOD_NAME)
            this.inputMappingInterface.processInputMapping(gameKey, motionGestureInput)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.METHOD_NAME, e)
            }
        }
    }

    override def process() : Unit = {
        CompleteMotionGestureInputEventHandler.getInstance().removeListener(this)
    }

}


