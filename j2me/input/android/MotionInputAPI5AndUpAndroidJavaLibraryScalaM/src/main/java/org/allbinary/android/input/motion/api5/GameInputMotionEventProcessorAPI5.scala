/* * AllBinary Open License Version 1 * Copyright (c) 2009 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.motion.api5

import _root_.android.view.MotionEvent
import _root_.org.allbinary.android.input.motion.BaseGameInputMotionEventProcessor
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.displayable.ScalableListener
import _root_.org.allbinary.input.motion.AllMotionRecognizer
import _root_.org.allbinary.input.motion.MotionRecognizer
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil

class GameInputMotionEventProcessorAPI5 private() extends BaseGameInputMotionEventProcessor {
    import _root_.org.allbinary.android.input.motion.api5.GameInputMotionEventProcessorAPI5.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private var motionRecognizerArray : Array[MotionRecognizer] = null

    private var TOTAL_MINUS_ONE : Int = 0

    //Constructor
    {
        //PreLogUtil.put("Single-Touch API Through API 4", this, this.commonStrings.CONSTRUCTOR);
        val size : Int = GameInputMotionInfoAPI5.getInstance().MAX_POINTERS
        this.motionRecognizerArray = new Array[AllMotionRecognizer](size)
        this.TOTAL_MINUS_ONE = size

        {
            var index : Int = 0
            while (index < size) {
                this.motionRecognizerArray(index) = new AllMotionRecognizer()
                index += 1
            }
        }
    }

    final private def isValid(pointerId : Int) : Boolean = {
        if (pointerId > this.TOTAL_MINUS_ONE) {
            var message : String = "Log that the pointer Ids are not what would be expected or Android has more than what I set my stuff to support pointerId: "
            ForcedLogUtil.log(message + pointerId, this)
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    override def process(motionEvent : MotionEvent) : Unit = {
        try {
            // commonStrings.PROCESS);
            val action : Int = motionEvent.getAction()
            var total : Int = this.motionRecognizerArray.length
            if (total > motionEvent.getPointerCount()) {
                total = motionEvent.getPointerCount()
            } else {
                var message : String = "Log that Android has more pointers than I have expected so increase it motionEvent.getPointerCount(): "
                ForcedLogUtil.log(message + motionEvent.getPointerCount(), this)
            }
            val totalMinusOne : Int = total - 1
            /*             for(int pointerIndex = totalMinusOne; pointerIndex >= 0; pointerIndex--)             {                 int pointerId = motionEvent.getPointerId(pointerIndex);                  if(this.isValid(pointerId))                 {                     int x = (int) (motionEvent.getX(pointerIndex) - this.displayInfo.getLeft());                     int y = (int) (motionEvent.getY(pointerIndex) - this.displayInfo.getTop());                     //int x = (int) ((motionEvent.getX(pointerIndex) - displayInfo.getLeft()) * displayInfo.getRatio()) ;                     //int y = (int) ((motionEvent.getY(pointerIndex) - displayInfo.getTop()) * displayInfo.getRatio());                     //int x = (int) motionEvent.getX(pointerIndex);                     //int y = (int) motionEvent.getY(pointerIndex);                                          this.logUtil.putF(                             new StringBuilder().append(commonStrings.START_LABEL)                                     .append("motionEvent: ").append(motionEvent.getAction()).append(" x: ").append(x).append(" y: ").append(y).toString(),                              this, this.commonStrings.PROCESS);                                      }             }             */
            if (action == MotionEvent.ACTION_DOWN) {

                {
                    var pointerIndex : Int = totalMinusOne
                    while (pointerIndex >= 0) {
                        val pointerId : Int = motionEvent.getPointerId(pointerIndex)
                        if (this.isValid(pointerId)) {
                            //                                this, this.commonStrings.PROCESS);
                            val scalableListener : ScalableListener = this.displayInfo.getScalableListener()
                            val x : Int = ((motionEvent.getX(pointerIndex) - this.displayInfo.getLeft()) / scalableListener.getRatio(this.displayInfo.getRatio())).toInt
                            val y : Int = ((motionEvent.getY(pointerIndex) - this.displayInfo.getTop()) / scalableListener.getRatio(this.displayInfo.getRatio())).toInt
                            //                                this, this.commonStrings.PROCESS);
                            this.motionRecognizerArray(pointerId).processStartMotionEvent(x, y, motionEvent.getDeviceId(), 0)
                        }
                        pointerIndex -= 1
                    }
                }
            } else if ((action == MotionEvent.ACTION_UP) || (action == MotionEvent.ACTION_CANCEL)) {

                {
                    var pointerIndex : Int = totalMinusOne
                    while (pointerIndex >= 0) {
                        val pointerId : Int = motionEvent.getPointerId(pointerIndex)
                        if (this.isValid(pointerId)) {
                            //                                this, this.commonStrings.PROCESS);
                            val scalableListener : ScalableListener = this.displayInfo.getScalableListener()
                            val x : Int = ((motionEvent.getX(pointerIndex) - this.displayInfo.getLeft()) / scalableListener.getRatio(this.displayInfo.getRatio())).toInt
                            val y : Int = ((motionEvent.getY(pointerIndex) - this.displayInfo.getTop()) / scalableListener.getRatio(this.displayInfo.getRatio())).toInt
                            //                                this, this.commonStrings.PROCESS);
                            this.motionRecognizerArray(pointerId).processEndMotionEvent(x, y, motionEvent.getDeviceId(), 0)
                        }
                        pointerIndex -= 1
                    }
                }
            } else if (action == MotionEvent.ACTION_MOVE) {

                {
                    var pointerIndex : Int = totalMinusOne
                    while (pointerIndex >= 0) {
                        val pointerId : Int = motionEvent.getPointerId(pointerIndex)
                        if (this.isValid(pointerId)) {
                            val scalableListener : ScalableListener = this.displayInfo.getScalableListener()
                            val x : Int = ((motionEvent.getX(pointerIndex) - this.displayInfo.getLeft()) / scalableListener.getRatio(this.displayInfo.getRatio())).toInt
                            val y : Int = ((motionEvent.getY(pointerIndex) - this.displayInfo.getTop()) / scalableListener.getRatio(this.displayInfo.getRatio())).toInt
                            this.motionRecognizerArray(pointerId).processDraggedMotionEvent(x, y, motionEvent.getDeviceId(), 0)
                        }
                        pointerIndex -= 1
                    }
                }
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.PROCESS, e)
            }
        }
    }

}

object GameInputMotionEventProcessorAPI5 {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : GameInputMotionEventProcessorAPI5 = {
        if (GameInputMotionEventProcessorAPI5.instance eq NullUtil.getInstance().NULL_OBJECT) {
            GameInputMotionEventProcessorAPI5.instance = new GameInputMotionEventProcessorAPI5()
        }
        return GameInputMotionEventProcessorAPI5.instance.asInstanceOf[GameInputMotionEventProcessorAPI5]
    }

}


