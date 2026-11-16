/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics

import _root_.jsinterop.annotations.JsType
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.string.CommonSeps

@JsType
class GPoint(param_x : Int, param_y : Int, param_z : Int) {
    import _root_.org.allbinary.graphics.GPoint.{*}

    private var x : Int = 0

    private var y : Int = 0

    private var z : Int = 0

    //protected
    //Constructor
    {
        val x : Int = param_x
        val y : Int = param_y
        val z : Int = param_z
        this.x = x
        this.y = y
        this.z = z
    }

    @JsMethod
    def getX() : Int = {
        return this.x
    }

    @JsMethod
    def getY() : Int = {
        return this.y
    }

    @JsMethod
    def getZ() : Int = {
        return this.z
    }

    @JsMethod
    def getRawX() : Int = {
        return this.x
    }

    @JsMethod
    def getRawY() : Int = {
        return this.y
    }

    @JsMethod
    def getRawZ() : Int = {
        return this.z
    }

    @JsMethod
    override def toString() : String = {
        return GPoint.toStringStatic(this.getX(), this.getY(), this.getZ())
    }

}

object GPoint {
    @JsMethod
    def getInstance(point : GPoint) : GPoint = {
        return new GPoint(point.getX(), point.getY(), point.getZ())
    }

    private val POINT_LABEL : String = "Point: "

    @JsMethod
    def toStringStatic(x : Int, y : Int, z : Int) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val positionStrings : PositionStrings = PositionStrings.getInstance()
        stringBuffer.append(GPoint.POINT_LABEL)
        stringBuffer.append(positionStrings.X_LABEL)
        stringBuffer.appendint(x)
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(positionStrings.Y_LABEL)
        stringBuffer.appendint(y)
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(positionStrings.Z_LABEL)
        stringBuffer.appendint(z)
        return stringBuffer.toString()
    }

}


