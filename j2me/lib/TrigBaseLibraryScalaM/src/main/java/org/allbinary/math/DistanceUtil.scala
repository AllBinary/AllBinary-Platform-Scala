/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.math

import _root_.org.allbinary.logic.math.MathUtil

class DistanceUtil {
    import _root_.org.allbinary.math.DistanceUtil.{*}

    private val mathUtil : MathUtil = MathUtil.getInstance()

    def getDistance(x1 : Int, y1 : Int, x2 : Int, y2 : Int) : Int = {
        val dx : Int = x1 - x2
        val dy : Int = y1 - y2
        return this.mathUtil.sqrt((dx * dx) + (dy * dy)).toInt
    }

}

object DistanceUtil {
    private val instance : DistanceUtil = new DistanceUtil()

    /**      * @return the instance      */
    def getInstance() : DistanceUtil = {
        return DistanceUtil.instance
    }

}


