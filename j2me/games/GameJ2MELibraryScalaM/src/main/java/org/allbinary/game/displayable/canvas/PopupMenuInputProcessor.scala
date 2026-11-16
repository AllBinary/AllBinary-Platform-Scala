/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.input.GameInputStrings
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.displayable.MyCanvas
import _root_.org.allbinary.input.motion.gesture.MotionGestureInput
import _root_.org.allbinary.input.motion.gesture.TouchMotionGestureFactory
import _root_.org.allbinary.input.motion.gesture.observer.MotionGestureEvent
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.math.RectangleCollisionUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.BasicArrayList

class PopupMenuInputProcessor(param_gameKeyEventList : BasicArrayList, param_playerInputId : Int, param_gameCanvas : MyCanvas, param_rectangle : Rectangle) extends BasicMenuInputProcessor(param_gameKeyEventList, param_playerInputId, param_gameCanvas) {

    private val rectangleCollisionUtil : RectangleCollisionUtil = RectangleCollisionUtil.getInstance()

    private val CLICK_DELAY : Int = 120

    private val clickTimeHelper : TimeDelayHelper = new TimeDelayHelper(this.CLICK_DELAY)

    private var rectangle : Rectangle = null

    //Constructor
    {
        val gameKeyEventList : BasicArrayList = param_gameKeyEventList
        val playerInputId : Int = param_playerInputId
        val gameCanvas : MyCanvas = param_gameCanvas
        val rectangle : Rectangle = param_rectangle
        this.rectangle = rectangle
    }

    def init(rectangle : Rectangle) : Unit = {
        this.rectangle = rectangle
    }

    def processInput(key : Int) : Int = {
        //4,8,KEY_STAR
        if (key == Canvas.KEY_STAR) {
            //PreLogUtil.put("Key: ").append(key, this, GameInputStrings.getInstance());
            val gameCanvas : AllBinaryGameCanvas = this.getCanvas().asInstanceOf[AllBinaryGameCanvas]
            gameCanvas.toggleMenu()
            return 1
        }
        return 0
    }

    override def processInputList() : Int = {
        try {
            val motionInputsIndex : Int = this.processMotionInputs()
            val list : BasicArrayList = this.getGameKeyEventList()
            val size : Int = list.size()
            var key : Int = 0
            var gameKeyEvent : GameKeyEvent = null

            {
                var index : Int = 0
                scala.util.boundary { (break_N77317 : scala.util.boundary.Label[Unit]) ?=>
                    while (index < size) {
                        gameKeyEvent = list.objectArray(index).asInstanceOf[GameKeyEvent]
                        if (gameKeyEvent != null) {
                            key = gameKeyEvent.getKey()
                            if (this.processInput(key) == 1) {
                                scala.util.boundary.break()(using break_N77317)
                            }
                        }
                        index += 1
                    }
                }
            }
            this.clear()
            if ((size > 0) || (motionInputsIndex >= 0)) {
                return 1
            } else {
                return -1
            }
        } catch {
            case breakException: scala.util.boundary.Break[?] => throw breakException
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, GameInputStrings.getInstance().PROCESS_INPUT, e)
                return -1
            }
        }
        throw new IllegalStateException()
    }

    //AllBinaryLayerManager layerManager
    def processMotionInputs() : Int = {
        val lastIndex : Int = this.motionGestureEventList.size() - 1
        if (lastIndex >= 0) {
            val motionGestureEvent : MotionGestureEvent = this.motionGestureEventList.objectArray(lastIndex).asInstanceOf[MotionGestureEvent]
            this.processMotionInput(motionGestureEvent)
        }
        this.motionGestureEventList.clear()
        return lastIndex
    }

    def processMotionInput(motionGestureEvent : MotionGestureEvent) : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, gameInputStrings.PROCESS_MOTION_INPUT);
        if (motionGestureEvent == null) {
            this.logUtil.putF("Exception: Bug", this, this.gameInputStrings.PROCESS_MOTION_INPUT)
            return
        }
        val touchMotionGestureFactory : TouchMotionGestureFactory = TouchMotionGestureFactory.getInstance()
        val motionGestureInput : MotionGestureInput = motionGestureEvent.getMotionGesture()
        if (motionGestureInput eq touchMotionGestureFactory.RELEASED) {
            var point : GPoint = motionGestureEvent.getCurrentPoint()
            //PreLogUtil.put(new StringMaker().append("Rect: ").append(rectangle.toString()).append(CommonSeps.getInstance().SPACE).append(point.toString()).toString(), this, this.gameInputStrings.PROCESS_MOTION_INPUT);
            var rectPoint : GPoint = this.rectangle.getPoint()
            if (this.rectangleCollisionUtil.isInside(rectPoint.getX(), rectPoint.getY(), this.rectangle.getMaxX() + 20, this.rectangle.getMaxY(), point.getX(), point.getY())) {
                if (this.clickTimeHelper.isTimeTNT()) {
                    //PreLogUtil.put("Toggle Menu: ").append(motionGestureInput.toString(), this, this.gameInputStrings.PROCESS_MOTION_INPUT);
                    val gameCanvas : AllBinaryGameCanvas = this.getCanvas().asInstanceOf[AllBinaryGameCanvas]
                    gameCanvas.toggleMenu()
                }
            }
        }
    }

}


