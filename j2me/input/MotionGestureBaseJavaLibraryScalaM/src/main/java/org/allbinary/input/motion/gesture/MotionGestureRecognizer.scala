/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.Line
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.input.motion.gesture.configuration.MotionGestureConfiguration
import _root_.org.allbinary.input.motion.gesture.configuration.MotionGestureConfigurationFactory
import _root_.org.allbinary.input.motion.gesture.observer.BasicMotionGesturesHandler
import _root_.org.allbinary.input.motion.gesture.observer.MotionEventCircularPool
import _root_.org.allbinary.input.motion.gesture.observer.MotionGestureEvent
import _root_.org.allbinary.input.motion.gesture.observer.MovedMotionGesturesHandler
import _root_.org.allbinary.input.motion.gesture.observer.ScrolledMotionGesturesHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.math.J2SEMath
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.string.CommonStrings

class MotionGestureRecognizer(param_id : Int) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val j2seMath : J2SEMath = J2SEMath.getInstance()

    private val origin : GPoint = PointFactory.getInstance().ZERO_ZERO

    private var previous : GPoint = this.origin

    private var intermediate : GPoint = this.origin

    private val line : Line = new Line(this.origin, this.origin)

    //TWB - should be treated like the KeyEventHandlers per player for deviceId
    private var motionGesturesHandler : BasicMotionGesturesHandler = null

    private var movedMotionGesturesHandler : BasicEventHandler = null

    private var scrolledMotionGesturesHandler : BasicEventHandler = null

    //private final int id;
    private var motionEventCircularPool : MotionEventCircularPool = null

    //Constructor
    {
        val id : Int = param_id
        //this.id = id;
        this.motionEventCircularPool = MotionEventCircularPool.createPool(id)
        var motionGesturesHandler : BasicEventHandler = new BasicEventHandler()
        var movedMotionGesturesHandler : BasicEventHandler = motionGesturesHandler
        var scrolledMotionGesturesHandler : BasicEventHandler = motionGesturesHandler
        try {
            motionGesturesHandler = BasicMotionGesturesHandler.getInstance()
            movedMotionGesturesHandler = MovedMotionGesturesHandler.getInstance()
            scrolledMotionGesturesHandler = ScrolledMotionGesturesHandler.getInstance()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e)
            }
        }
        this.motionGesturesHandler = motionGesturesHandler.asInstanceOf[BasicMotionGesturesHandler]
        this.movedMotionGesturesHandler = movedMotionGesturesHandler
        this.scrolledMotionGesturesHandler = scrolledMotionGesturesHandler
    }

    def processPressedMotionEvent(current : GPoint, deviceId : Int, button : Int) : Boolean = {
        //PreLogUtil.put(commonStrings.START, this, "processPressedMotionEvent");
        this.intermediate = this.origin
        this.previous = this.origin
        val event : MotionGestureEvent = this.motionEventCircularPool.getInstance(TouchMotionGestureFactory.getInstance().PRESSED)
        event.setPreviousPoint(this.previous)
        event.setCurrentPoint(current)
        //this.logUtil.putF("Firing Event: " + event, this, "processReleasedMotionEvent");
        this.motionGesturesHandler.fireEvent(event)
        return true
    }

    def processReleasedMotionEvent(current : GPoint, deviceId : Int, button : Int) : Boolean = {
        /*          * if(this.touchButtonRecognizer.processTouchButtonInput(UpGameKeyEventHandler          * .getInstance(), current)) { touchButtonProcessing = false; return          * true; }          */
        val event : MotionGestureEvent = this.motionEventCircularPool.getInstance(TouchMotionGestureFactory.getInstance().RELEASED)
        event.setPreviousPoint(this.previous)
        event.setCurrentPoint(current)
        //this.logUtil.putF("Firing Event: " + event, this, "processReleasedMotionEvent");
        this.motionGesturesHandler.fireEvent(event)
        return true
    }

    def processDraggedMotionEvent(current : GPoint, deviceId : Int, buttonMask : Int) : Unit = {
        //TWB - GPoints are not cached so what is the deal here?
        if ((this.previous eq this.origin) || (this.intermediate eq this.origin)) {
            this.previous = current
            this.intermediate = current
            // return null;
            return
        }
        this.line.setP1(this.previous)
        this.line.setP2(current)
        // Line returnLine = new Line(intermediate, current);
        var minimumMotionGesture : Int = MotionGestureConfigurationFactory.getInstance().getMinimumMotionGesture()
        if ((this.j2seMath.abs(this.line.getDeltaX().toFloat) < minimumMotionGesture) && (this.j2seMath.abs(this.line.getDeltaY().toFloat) < minimumMotionGesture)) {
            this.intermediate = current
            return
        }
        var gradient : Double = this.line.getGradient()
        var absGradient : Double = this.j2seMath.abs(gradient.toFloat).toDouble
        val conf : MotionGestureConfiguration = MotionGestureConfigurationFactory.getInstance()
        val touchMotionGestureFactory : TouchMotionGestureFactory = TouchMotionGestureFactory.getInstance()
        var newMotionGesture : MotionGestureInput = touchMotionGestureFactory.NO_MOTION
        var diagonalToleranceHigher : Double = 12.0
        var diagonalToleranceLower : Double = 12.0
        if (conf.isDiagonalMotionGestureAllowed()) {
            diagonalToleranceHigher = (90 - conf.getDiagonalTolerance()).toDouble
            diagonalToleranceLower = conf.getDiagonalTolerance().toDouble
        }
        if (absGradient > Math.tan(Math.toRadians(diagonalToleranceHigher))) {
            if (this.line.getDeltaY() > 0) {
                newMotionGesture = touchMotionGestureFactory.UP
            } else {
                newMotionGesture = touchMotionGestureFactory.DOWN
            }
        } else {
            if (absGradient < Math.tan(Math.toRadians(diagonalToleranceLower))) {
                // line.getDeltaX(), this, "processDraggedMotionEvent");
                if (this.line.getDeltaX() > 0) {
                    newMotionGesture = touchMotionGestureFactory.LEFT
                } else {
                    newMotionGesture = touchMotionGestureFactory.RIGHT
                }
            } else {
                //this.logUtil.putF("Diagonal: " + gradient + CommonStrings + PositionStrings + line.getDeltaX() + PositionStrings + line.getDeltaY(), this, "processDraggedMotionEvent");
                if (gradient > 0) {
                    if (this.line.getDeltaX() > 0) {
                        //this.logUtil.putF("Diagonal Up Left", this, "processDraggedMotionEvent");
                        newMotionGesture = touchMotionGestureFactory.DIAGONAL_UP_LEFT
                    } else {
                        //this.logUtil.putF("Diagonal Down Right", this, "processDraggedMotionEvent");
                        newMotionGesture = touchMotionGestureFactory.DIAGONAL_DOWN_RIGHT
                    }
                } else {
                    if (this.line.getDeltaX() > 0) {
                        //this.logUtil.putF("Diagonal Down Left", this, "processDraggedMotionEvent");
                        newMotionGesture = touchMotionGestureFactory.DIAGONAL_DOWN_LEFT
                    } else {
                        //this.logUtil.putF("Diagonal Up Right", this, "processDraggedMotionEvent");
                        newMotionGesture = touchMotionGestureFactory.DIAGONAL_UP_RIGHT
                    }
                }
            }
        }
        this.previous = current
        this.intermediate = current
        val event : MotionGestureEvent = this.motionEventCircularPool.getInstance(newMotionGesture)
        event.setPreviousPoint(this.previous)
        event.setCurrentPoint(current)
        this.motionGesturesHandler.fireEvent(event)
        // return returnLine;
        return
    }

    def processMovedMotionEvent(current : GPoint, deviceId : Int, button : Int) : Boolean = {
        //this.logUtil.putF(this.commonStrings.START_LABEL + current.toString(), this, "processReleasedMotionEvent");
        val event : MotionGestureEvent = this.motionEventCircularPool.getInstance(TouchMotionGestureFactory.getInstance().NO_MOTION)
        event.setPreviousPoint(this.previous)
        event.setCurrentPoint(current)
        //this.logUtil.putF("Firing Event: " + event, this, "processReleasedMotionEvent");
        this.movedMotionGesturesHandler.fireEvent(event)
        return true
    }

    def processScrolledMotionEvent(current : GPoint, deviceId : Int, button : Int) : Boolean = {
        //        this.logUtil.putF(new StringMaker().append(current.toString()).append(commonSeps.SPACE).appendint(button).toString(), this, "processScrolledMotionEvent");
        val touchMotionGestureFactory : TouchMotionGestureFactory = TouchMotionGestureFactory.getInstance()
        var newMotionGesture : MotionGestureInput = touchMotionGestureFactory.NO_MOTION
        //TWB - this has only been tested for SWT
        if (button > 0) {
            newMotionGesture = touchMotionGestureFactory.SCROLL_UP
        } else if (button < 0) {
            newMotionGesture = touchMotionGestureFactory.SCROLL_DOWN
        }
        val event : MotionGestureEvent = this.motionEventCircularPool.getInstance(newMotionGesture)
        event.setPreviousPoint(this.previous)
        event.setCurrentPoint(current)
        //this.logUtil.putF("Firing Event: " + event, this, "processReleasedMotionEvent");
        this.scrolledMotionGesturesHandler.fireEvent(event)
        return true
    }

    def getMotionGesturesHandler() : BasicMotionGesturesHandler = {
        return this.motionGesturesHandler
    }

}


