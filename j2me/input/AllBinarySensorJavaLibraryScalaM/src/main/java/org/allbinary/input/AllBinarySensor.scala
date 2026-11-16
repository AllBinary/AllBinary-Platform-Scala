/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input

import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class AllBinarySensor() extends AllBinarySensorListener {
    import _root_.org.allbinary.input.AllBinarySensor.{NULL_ALLBINARY_SENSOR as _, *}
    def NULL_ALLBINARY_SENSOR : AllBinarySensor = _root_.org.allbinary.input.AllBinarySensor.NULL_ALLBINARY_SENSOR

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    def init() : Unit = {
    }

    def update() : Unit = {
    }

    def getId() : Int = {
        return AllBinarySensor.getMax()
    }

    def shutdown() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, "shutdown")
    }

    override def onSensorChange() : Unit = {
        ForcedLogUtil.log(this.commonStrings.NOT_IMPLEMENTED, this)
    }

}

object AllBinarySensor {
    val NULL_ALLBINARY_SENSOR : AllBinarySensor = new AllBinarySensor()

    private var max : Int = 100

    def setMax(max : Int) : Unit = {
        AllBinarySensor.max = max
    }

    def getMax() : Int = {
        return AllBinarySensor.max
    }

}


