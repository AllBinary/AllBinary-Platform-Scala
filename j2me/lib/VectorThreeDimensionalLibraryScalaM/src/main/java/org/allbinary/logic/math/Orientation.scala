/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math

import _root_.org.allbinary.logic.string.StringMaker

class Orientation private(param_yaw : Int, param_pitch : Int, param_roll : Int) {
    import _root_.org.allbinary.logic.math.Orientation.{*}

    var yaw : BasicDecimal = new BasicDecimal(0)

    var pitch : BasicDecimal = new BasicDecimal(0)

    var roll : BasicDecimal = new BasicDecimal(0)

    //Constructor
    {
        val yaw : Int = param_yaw
        val pitch : Int = param_pitch
        val roll : Int = param_roll
        this.yaw.setint(yaw)
        this.pitch.setint(pitch)
        this.roll.setint(roll)
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Y: ")
        stringBuffer.append(this.yaw.toString())
        stringBuffer.append(" P: ")
        stringBuffer.append(this.pitch.toString())
        stringBuffer.append(" R: ")
        stringBuffer.append(this.roll.toString())
        return stringBuffer.toString()
    }

}

object Orientation {
    var NONE : Orientation = new Orientation(0, 0, 0)

    private var SINGLETON : Orientation = new Orientation(0, 0, 0)

    def getInstance(yaw : Int, pitch : Int, roll : Int) : Orientation = {
        Orientation.SINGLETON.yaw.setint(yaw)
        Orientation.SINGLETON.pitch.setint(pitch)
        Orientation.SINGLETON.roll.setint(roll)
        return Orientation.SINGLETON
    }

}


