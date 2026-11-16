/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.direction

import _root_.org.allbinary.math.Angle
import _root_.org.allbinary.math.AngleFactory

class DirectionUtil private() {
    import _root_.org.allbinary.direction.DirectionUtil.{*}

    private var directionArray : Array[Angle] = new Array[Angle](10)

    private var directionArray2 : Array[Angle] = new Array[Angle](10)

    //Constructor
    {
        var angleFactory : AngleFactory = AngleFactory.getInstance()
        var directionFactory : DirectionFactory = DirectionFactory.getInstance()
        this.directionArray(directionFactory.LEFT.getValue()) = angleFactory.LEFT
        this.directionArray(directionFactory.RIGHT.getValue()) = angleFactory.RIGHT
        this.directionArray(directionFactory.UP.getValue()) = angleFactory.UP
        this.directionArray(directionFactory.DOWN.getValue()) = angleFactory.DOWN
        this.directionArray2(directionFactory.LEFT.getValue()) = angleFactory.LEFT
        this.directionArray2(directionFactory.RIGHT.getValue()) = angleFactory.RIGHT
        this.directionArray2(directionFactory.UP.getValue()) = angleFactory.UP
        this.directionArray2(directionFactory.DOWN.getValue()) = angleFactory.DOWN
    }

    def getAngle(direction : Direction) : Angle = {
        return this.directionArray2(direction.getValue())
    }

    def getFrameAngle(direction : Direction) : Angle = {
        return this.directionArray(direction.getValue())
    }

}

object DirectionUtil {
    private val instance : DirectionUtil = new DirectionUtil()

    def getInstance() : DirectionUtil = {
        return DirectionUtil.instance
    }

}


