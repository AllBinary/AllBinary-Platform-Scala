/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.math

import _root_.jsinterop.annotations.JsType
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor

@JsType
class FrameUtil private() {
    import _root_.org.allbinary.math.FrameUtil.{*}

    // TWB - Note the angle is actually 90 degrees off
    @JsMethod
    def getFrameForAngle(angle : Short, angleIncrement : Int) : Int = {
        return this.adjustAngleToFrameAngle(angle.toInt) / angleIncrement
    }

    @JsMethod
    def getFrameAngle(frame : Int, angleIncrement : Int) : Int = {
        val frameAngle : Int = (angleIncrement * frame) - 90
        return this.adjustAngleToFrameAngle(frameAngle)
    }

    @JsMethod
    def adjustAngleToFrameAngle(param_currentAngle : Int) : Int = {
        var currentAngle : Int = param_currentAngle
        val angleFactory : AngleFactory = AngleFactory.getInstance()
        if (currentAngle > 359) {
            currentAngle = (currentAngle - angleFactory.TOTAL_ANGLE)

            {
                while (currentAngle > 359) {
                    //PreLogUtil.put(Integer.toString(currentAngle).toString(), this, AJUST_ANGLE_TO_FRAME_ANGLE_MORE);
                    currentAngle = (currentAngle - angleFactory.TOTAL_ANGLE)
                }
            }
        }
        if (currentAngle < 0) {
            currentAngle = (currentAngle + angleFactory.TOTAL_ANGLE)

            {
                while (currentAngle < 0) {
                    //PreLogUtil.put(Integer.toString(currentAngle).toString(), this, AJUST_ANGLE_TO_FRAME_ANGLE_LESS);
                    currentAngle = (currentAngle + angleFactory.TOTAL_ANGLE)
                }
            }
        }
        return currentAngle
    }

}

object FrameUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : FrameUtil = new FrameUtil()

    @JsMethod
    def getInstance() : FrameUtil = {
        return FrameUtil.instance
    }

}


