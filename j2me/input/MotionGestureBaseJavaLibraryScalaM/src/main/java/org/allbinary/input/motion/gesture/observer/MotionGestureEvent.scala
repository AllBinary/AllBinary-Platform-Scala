/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture.observer

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.input.motion.gesture.MotionGestureInput
import _root_.org.allbinary.input.motion.gesture.TouchMotionGestureFactory
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.string.CommonLabels

class MotionGestureEvent(param_source : Object, param_id : Int, param_motionGesture : MotionGestureInput) extends AllBinaryEventObject(param_source) {
    import _root_.org.allbinary.input.motion.gesture.observer.MotionGestureEvent.{*}

    private var motionGesture : MotionGestureInput = TouchMotionGestureFactory.getInstance().NO_MOTION

    private var id : Int = 0

    private var previousPoint : GPoint = PointFactory.getInstance().ZERO_ZERO

    private var currentPoint : GPoint = PointFactory.getInstance().ZERO_ZERO

    private val commonLabels : CommonLabels = CommonLabels.getInstance()

    //Constructor
    {
        val source : Object = param_source
        val id : Int = param_id
        val motionGesture : MotionGestureInput = param_motionGesture
        this.id = id
        this.setMotionGesture(motionGesture)
    }

    def getMotionGesture() : MotionGestureInput = {
        return this.motionGesture
    }

    def setMotionGesture(motionGesture : MotionGestureInput) : Unit = {
        this.motionGesture = motionGesture
    }

    /**      * @return the previousPoint      */
    def getPreviousPoint() : GPoint = {
        return this.previousPoint
    }

    /**      * @param previousPoint the previousPoint to set      */
    def setPreviousPoint(previousPoint : GPoint) : Unit = {
        this.previousPoint = previousPoint
    }

    /**      * @return the currentPoint      */
    def getCurrentPoint() : GPoint = {
        return this.currentPoint
    }

    /**      * @param currentPoint the currentPoint to set      */
    def setCurrentPoint(currentPoint : GPoint) : Unit = {
        this.currentPoint = currentPoint
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val stringUtil : StringUtil = StringUtil.getInstance()
        stringBuffer.append(stringUtil.toString(this.motionGesture))
        stringBuffer.append(this.commonLabels.CURRENT)
        stringBuffer.append(stringUtil.toString(this.currentPoint))
        stringBuffer.append(MotionGestureEvent.PREVIOUS)
        stringBuffer.append(stringUtil.toString(this.previousPoint))
        stringBuffer.append(MotionGestureEvent.HASHCODE)
        stringBuffer.appendint(TsUtil.getInstance().hashCode(this))
        return stringBuffer.toString()
    }

    def getId() : Int = {
        return this.id
    }

}

object MotionGestureEvent {
    private val PREVIOUS : String = " Previous: "

    private val HASHCODE : String = " hashcode: "

}


