/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.math

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.jsinterop.annotations.JsProperty
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor

@JsType
class AngleIncrementInfo(param_angleIncrement : Short) {
    import _root_.org.allbinary.math.AngleIncrementInfo.{*}

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var angleIncrement : Short = 0

    @JsProperty
    var DOWN_FRAME : Integer = null

    @JsProperty
    var UP_FRAME : Integer = null

    @JsProperty
    var LEFT_FRAME : Integer = null

    @JsProperty
    var RIGHT_FRAME : Integer = null

    private val frameUtil : FrameUtil = FrameUtil.getInstance()

    //protected    
    //Constructor
    {
        val angleIncrement : Short = param_angleIncrement
        this.angleIncrement = angleIncrement
        val angleFactory : AngleFactory = AngleFactory.getInstance()
        val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
        this.DOWN_FRAME = smallIntegerSingletonFactory.getAt(angleFactory.DOWN.getValue() / this.angleIncrement)
        this.UP_FRAME = smallIntegerSingletonFactory.getAt(angleFactory.UP.getValue().toInt)
        this.LEFT_FRAME = smallIntegerSingletonFactory.getAt(angleFactory.LEFT.getValue() / this.angleIncrement)
        this.RIGHT_FRAME = smallIntegerSingletonFactory.getAt(angleFactory.RIGHT.getValue() / this.angleIncrement)
    }

    @JsMethod
    def getFrameAngle(frame : Int) : Int = {
        return this.frameUtil.getFrameAngle(frame, this.angleIncrement.toInt)
    }

    //public Integer getAngleIncrement()
    @JsMethod
    def getAngleIncrement() : Short = {
        return this.angleIncrement
    }

    @JsMethod
    override def toString() : String = {
        return new StringMaker().append(AngleIncrementInfo.INCREMENT).appendshort(this.angleIncrement).toString()
    }

    @JsMethod
    def getClosestGeneralDirection(angle : Short) : Int = {
        var closestDirection : Integer = SmallIntegerSingletonFactory.getInstance().getAt(360)
        if ((this.UP_FRAME.intValue() - angle) < (closestDirection.intValue() - angle)) {
            closestDirection = this.UP_FRAME
        }
        if ((this.DOWN_FRAME.intValue() - angle) < (closestDirection.intValue() - angle)) {
            closestDirection = this.DOWN_FRAME
        }
        if ((this.LEFT_FRAME.intValue() - angle) < (closestDirection.intValue() - angle)) {
            closestDirection = this.LEFT_FRAME
        }
        if ((this.RIGHT_FRAME.intValue() - angle) < (closestDirection.intValue() - angle)) {
            closestDirection = this.RIGHT_FRAME
        }
        return closestDirection.intValue()
    }

}

object AngleIncrementInfo {
    private val INCREMENT : String = "Inc: "

}


