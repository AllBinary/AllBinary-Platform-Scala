/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.math

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor

@JsType
class AngleInfo private(param_angleIncrementInfo : AngleIncrementInfo) {
    import _root_.org.allbinary.math.AngleInfo.{*}

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var angleIncrementInfo : AngleIncrementInfo = null

    private var angle : Short = 0

    private val frameUtil : FrameUtil = FrameUtil.getInstance()

    //Constructor
    {
        val angleIncrementInfo : AngleIncrementInfo = param_angleIncrementInfo
        this.angleIncrementInfo = angleIncrementInfo
    }

    @JsMethod
    def adjustAngle(frame : Int) : Unit = {
        val newAngle : Int = (this.angleIncrementInfo.getAngleIncrement() * frame) - 90
        this.setAngle(this.frameUtil.adjustAngleToFrameAngle(newAngle).toShort)
    }

    @JsMethod
    def getAngle() : Short = {
        return this.angle
    }

    @JsMethod
    def setAngle(angle : Short) : Unit = {
        //this.logUtil.putF("Set Angle: " + angle, this, "setAngle");
        this.angle = angle
    }

    @JsMethod
    def getAngleIncrementInfo() : AngleIncrementInfo = {
        //this.logUtil.putF(angleIncrementInfo.toString(), this, "getAngleIncrementInfo()");
        return this.angleIncrementInfo
    }

    @JsMethod
    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(AngleInfo.ANGLE)
        stringBuffer.appendshort(this.angle)
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(StringUtil.getInstance().toString(this.getAngleIncrementInfo()))
        return stringBuffer.toString()
    }

}

object AngleInfo {
    @JsMethod
    def getInstance(angleIncrement : Short) : AngleInfo = {
        return new AngleInfo(AngleIncrementInfoFactory.getInstance().getAt(angleIncrement))
    }

    private val ANGLE : String = "Angle: "

}


