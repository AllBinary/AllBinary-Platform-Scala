/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion

import _root_.org.allbinary.input.motion.gesture.TouchMotionGestureFactory
import _root_.org.allbinary.input.motion.gesture.configuration.MotionGestureConfiguration
import _root_.org.allbinary.input.motion.gesture.configuration.MotionGestureConfigurationFactory
import _root_.org.allbinary.input.motion.touch.action.DiagonalDownLeftTouchInputToGameKeyEventAction
import _root_.org.allbinary.input.motion.touch.action.DiagonalDownRightTouchInputToGameKeyEventAction
import _root_.org.allbinary.input.motion.touch.action.DiagonalUpLeftTouchInputToGameKeyEventAction
import _root_.org.allbinary.input.motion.touch.action.DiagonalUpRightTouchInputToGameKeyEventAction
import _root_.org.allbinary.input.motion.touch.action.DownTouchInputToGameKeyEventAction
import _root_.org.allbinary.input.motion.touch.action.LeftTouchInputToGameKeyEventAction
import _root_.org.allbinary.input.motion.touch.action.ReleaseTouchInputToGameKeyEventAction
import _root_.org.allbinary.input.motion.touch.action.RightTouchInputToGameKeyEventAction
import _root_.org.allbinary.input.motion.touch.action.UpTouchInputToGameKeyEventAction
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class CompleteMotionGestureInputToGameMotionGestureInput {
    import _root_.org.allbinary.input.motion.CompleteMotionGestureInputToGameMotionGestureInput.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def init() : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        try {
            PreLogUtil.put("Compound Motion Gestures", this, commonStrings.INIT)
            val motionGestureConfiguration : MotionGestureConfiguration = MotionGestureConfigurationFactory.getInstance()
            val touchMotionGestureFactory : TouchMotionGestureFactory = TouchMotionGestureFactory.getInstance()
            var list : BasicArrayList = new BasicArrayListD()
            list.add(touchMotionGestureFactory.DIAGONAL_DOWN_LEFT)
            motionGestureConfiguration.addMotionGestureAction(list, DiagonalDownLeftTouchInputToGameKeyEventAction.getInstance())
            list = new BasicArrayListD()
            list.add(touchMotionGestureFactory.DIAGONAL_DOWN_RIGHT)
            motionGestureConfiguration.addMotionGestureAction(list, DiagonalDownRightTouchInputToGameKeyEventAction.getInstance())
            list = new BasicArrayListD()
            list.add(touchMotionGestureFactory.DIAGONAL_UP_LEFT)
            motionGestureConfiguration.addMotionGestureAction(list, DiagonalUpLeftTouchInputToGameKeyEventAction.getInstance())
            list = new BasicArrayListD()
            list.add(touchMotionGestureFactory.DIAGONAL_UP_RIGHT)
            motionGestureConfiguration.addMotionGestureAction(list, DiagonalUpRightTouchInputToGameKeyEventAction.getInstance())
            list = new BasicArrayListD()
            list.add(touchMotionGestureFactory.LEFT)
            motionGestureConfiguration.addMotionGestureAction(list, LeftTouchInputToGameKeyEventAction.getInstance())
            list = new BasicArrayListD()
            list.add(touchMotionGestureFactory.RIGHT)
            motionGestureConfiguration.addMotionGestureAction(list, RightTouchInputToGameKeyEventAction.getInstance())
            list = new BasicArrayListD()
            list.add(touchMotionGestureFactory.DOWN)
            motionGestureConfiguration.addMotionGestureAction(list, DownTouchInputToGameKeyEventAction.getInstance())
            list = new BasicArrayListD()
            list.add(touchMotionGestureFactory.UP)
            motionGestureConfiguration.addMotionGestureAction(list, UpTouchInputToGameKeyEventAction.getInstance())
            list = new BasicArrayListD()
            list.add(touchMotionGestureFactory.RELEASED)
            motionGestureConfiguration.addMotionGestureAction(list, ReleaseTouchInputToGameKeyEventAction.getInstance())
        } catch {
            case e : Exception => {
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.INIT, e)
            }
        }
    }

}

object CompleteMotionGestureInputToGameMotionGestureInput {
    private val instance : CompleteMotionGestureInputToGameMotionGestureInput = new CompleteMotionGestureInputToGameMotionGestureInput()

    def getInstance() : CompleteMotionGestureInputToGameMotionGestureInput = {
        return CompleteMotionGestureInputToGameMotionGestureInput.instance
    }

}


