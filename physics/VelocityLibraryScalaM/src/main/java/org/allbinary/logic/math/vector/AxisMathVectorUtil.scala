/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math.vector

import _root_.org.allbinary.math.NoDecimalTrigTable

class AxisMathVectorUtil {
    import _root_.org.allbinary.logic.math.vector.AxisMathVectorUtil.{*}

    private val noDecimalTrigTable : NoDecimalTrigTable = NoDecimalTrigTable.getInstance()

    def calculateX(magnitude : Long, angle : Int) : Long = {
        return (magnitude * this.noDecimalTrigTable.cos(angle)) / 10
    }

    def calculateY(magnitude : Long, angle : Int) : Long = {
        return (magnitude * this.noDecimalTrigTable.sin(angle)) / 10
    }

    //as such it is hard to say what the otherAngle is since I do not have normal orientation of the axi.
    def calculateZ(magnitude : Long, otherAngle : Int) : Long = {
        return (magnitude * this.noDecimalTrigTable.sin(otherAngle)) / 10
    }

}

object AxisMathVectorUtil {
    private val instance : AxisMathVectorUtil = new AxisMathVectorUtil()

    def getInstance() : AxisMathVectorUtil = {
        return AxisMathVectorUtil.instance
    }

}


