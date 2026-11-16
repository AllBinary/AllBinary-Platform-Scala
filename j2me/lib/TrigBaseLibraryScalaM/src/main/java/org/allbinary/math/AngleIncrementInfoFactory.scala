/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.math


class AngleIncrementInfoFactory {
    import _root_.org.allbinary.math.AngleIncrementInfoFactory.{*}

    private val angleIncrementInfo : Array[AngleIncrementInfo] = new Array[AngleIncrementInfo](AngleFactory.getInstance().TOTAL_ANGLE.toInt)

    def getAt(angleIncrement : Short) : AngleIncrementInfo = {
        //Integer integer = SmallIntegerSingletonFactory.getInstance(angleIncrement);
        val halfAngleIncrement : Int = (angleIncrement.toInt >> 1)
        var angleIncrementInfo : AngleIncrementInfo = null
        var angleIncrementInfoCanBeNull : AngleIncrementInfo = this.angleIncrementInfo(halfAngleIncrement)
        //hashtable.get(integer);
        if (angleIncrementInfoCanBeNull == null) {
            //Integer integer = SmallIntegerSingletonFactory.getInstance(angleIncrement);
            angleIncrementInfo = new AngleIncrementInfo(angleIncrement)
            //hashtable.put(integer, angleIncrementInfoCanBeNull);
            this.angleIncrementInfo(halfAngleIncrement) = angleIncrementInfo
            return angleIncrementInfo
        } else {
            angleIncrementInfo = angleIncrementInfoCanBeNull
        }
        return angleIncrementInfo
    }

}

object AngleIncrementInfoFactory {
    private val instance : AngleIncrementInfoFactory = new AngleIncrementInfoFactory()

    def getInstance() : AngleIncrementInfoFactory = {
        return AngleIncrementInfoFactory.instance
    }

}


