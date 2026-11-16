/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics


class CustomGPoint(param_x : Int, param_y : Int, param_z : Int) extends GPoint(param_x, param_y, param_z) {
    import _root_.org.allbinary.graphics.CustomGPoint.{NULL_CUSTOM_POINT as _, *}
    def NULL_CUSTOM_POINT : CustomGPoint = _root_.org.allbinary.graphics.CustomGPoint.NULL_CUSTOM_POINT

    private var cx : Int = 0

    private var cy : Int = 0

    private var cz : Int = 0

    //Constructor
    {
        val x : Int = param_x
        val y : Int = param_y
        val z : Int = param_z
    }

    def setX(x : Int) : Unit = {
        this.cx = x
    }

    override def getX() : Int = {
        return this.cx
    }

    def setY(y : Int) : Unit = {
        this.cy = y
    }

    override def getY() : Int = {
        return this.cy
    }

    def setZ(z : Int) : Unit = {
        this.cz = z
    }

    override def getZ() : Int = {
        return this.cz
    }

}

object CustomGPoint {
    val NULL_CUSTOM_POINT : CustomGPoint = new CustomGPoint(0, 0, 0)

    def getInstance(point : GPoint) : CustomGPoint = {
        return new CustomGPoint(point.getX(), point.getY(), point.getZ())
    }

    def getInstance3(x : Int, y : Int) : CustomGPoint = {
        return new CustomGPoint(x, y, 3)
    }

}


