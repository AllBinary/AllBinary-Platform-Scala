/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input

import _root_.org.allbinary.input.accelerometer.AccelerometerSensorFactory
import _root_.org.allbinary.input.gyro.GyroSensorFactory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class AllBinarySensorManager private() {
    import _root_.org.allbinary.input.AllBinarySensorManager.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    val ORIENTATION_SENSOR_INPUT : String = "Orientation Sensor Input"

    val ORIENTATION_TYPE : String = "Orientation Type"

    private val list : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        try {
            GyroSensorFactory.init()
            AccelerometerSensorFactory.init()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
            }
        }
    }

    //public AllBinarySensor[] init()
    def init() : Unit = {
    }

    def getSensorNamesList() : BasicArrayList = {
        return this.list
    }

    def shutdown() : Unit = {
    }

}

object AllBinarySensorManager {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : AllBinarySensorManager = {
        if (AllBinarySensorManager.instance eq NullUtil.getInstance().NULL_OBJECT) {
            AllBinarySensorManager.instance = new AllBinarySensorManager()
        }
        return AllBinarySensorManager.instance.asInstanceOf[AllBinarySensorManager]
    }

}


