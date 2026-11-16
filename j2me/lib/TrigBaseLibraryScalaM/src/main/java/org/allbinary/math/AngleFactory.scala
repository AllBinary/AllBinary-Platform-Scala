/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.math

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor
import _root_.jsinterop.annotations.JsProperty

@JsType
class AngleFactory() {
    import _root_.org.allbinary.math.AngleFactory.{*}

    @JsProperty
    val logUtil : LogUtil = LogUtil.getInstance()

    @JsProperty
    val TOTAL_ANGLE : Short = 360

    @JsProperty
    val QUARTER_TOTAL_ANGLE : Short = 90

    private val angleArray : Array[Angle] = new Array[Angle](this.TOTAL_ANGLE.toInt)

    private val NEGATIVE_ONE : Short = -1

    @JsProperty
    val NOT_ANGLE : NamedAngle = new NamedAngle(this.NEGATIVE_ONE, CommonStrings.getInstance().EMPTY)

    @JsProperty
    var DOWN : NamedAngle = null

    @JsProperty
    var UP : NamedAngle = null

    @JsProperty
    var LEFT : NamedAngle = null

    @JsProperty
    var RIGHT : NamedAngle = null

    private val frameUtil : FrameUtil = FrameUtil.getInstance()

    //Constructor
    {
        val commonPhoneStrings : CommonPhoneStrings = CommonPhoneStrings.getInstance()
        val total : Short = this.angleArray.length.toShort
        this.UP = new NamedAngle((0).toShort, commonPhoneStrings.UP)
        this.angleArray(0) = this.UP

        {
            var index : Int = 1
            while (index < 90) {
                this.angleArray(index) = new Angle(index.toShort)
                index += 1
            }
        }
        this.RIGHT = new NamedAngle((90).toShort, commonPhoneStrings.RIGHT)
        this.angleArray(90) = this.RIGHT

        {
            var index : Int = 91
            while (index < 180) {
                this.angleArray(index) = new Angle(index.toShort)
                index += 1
            }
        }
        this.DOWN = new NamedAngle((180).toShort, commonPhoneStrings.DOWN)
        this.angleArray(180) = this.DOWN

        {
            var index : Int = 181
            while (index < 270) {
                this.angleArray(index) = new Angle(index.toShort)
                index += 1
            }
        }
        this.LEFT = new NamedAngle((270).toShort, commonPhoneStrings.LEFT)
        this.angleArray(270) = this.LEFT

        {
            var index : Int = 271
            while (index < total) {
                this.angleArray(index) = new Angle(index.toShort)
                index += 1
            }
        }
    }

    @JsMethod
    def getAt(index : Int) : Angle = {
        val adjustedIndex : Int = this.frameUtil.adjustAngleToFrameAngle(index).toInt
        return this.angleArray(adjustedIndex)
    }

    @JsMethod
    def getClosestDirection(angle : Int) : Angle = {
        if (((angle >= 315) && (angle < 360)) || ((angle >= 0) && (angle < 45))) {
            return this.UP
        } else if ((angle >= 45) && (angle < 135)) {
            return this.RIGHT
        } else if ((angle >= 135) && (angle < 225)) {
            return this.DOWN
        } else if ((angle >= 225) && (angle < 315)) {
            return this.LEFT
        }
        throw new RuntimeException()
    }

    @JsMethod
    def getGeneralDirection() : Angle = {
        return this.NOT_ANGLE
    }

}

object AngleFactory {
    private val instance : AngleFactory = new AngleFactory()

    @JsMethod
    def getInstance() : AngleFactory = {
        return AngleFactory.instance
    }

    //    }
    @JsMethod
    def main(args : Array[String]) : Unit = {
        val stringMaker : StringMaker = new StringMaker()
        val angleFactory : AngleFactory = AngleFactory.getInstance()
        //System.out.println(angleFactory.TOTAL_ANGLE >> 2); /4

        {
            var index : Int = 0
            while (index < 360) {
                stringMaker.appendint(index).append(CommonSeps.getInstance().FORWARD_SLASH).appendshort(angleFactory.getClosestDirection(index).getValue()).append(CommonSeps.getInstance().NEW_LINE)
                index += 1
            }
        }
        LogUtil.getInstance().putF(stringMaker.toString(), "main", "main")
    }

}


