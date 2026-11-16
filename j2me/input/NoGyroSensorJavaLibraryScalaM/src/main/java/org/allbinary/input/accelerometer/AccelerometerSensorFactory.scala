/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.accelerometer

import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.SensorFeatureFactory
import _root_.org.allbinary.input.gyro.AllBinaryOrientationSensor

class AccelerometerSensorFactory {
    import _root_.org.allbinary.input.accelerometer.AccelerometerSensorFactory.{*}

}

object AccelerometerSensorFactory {
    //private static final AccelerometerSensorFactory instance = new AccelerometerSensorFactory();
    private var allBinaryAccelerometerSensor : AllBinaryOrientationSensor = AllBinaryOrientationSensor.NULL_ALLBINARY_ORIENTATION_SENSOR

    def init() : Unit = {
        //PreLogUtil.put(this.commonStrings.START, this, this.commonStrings.INIT);
        var features : Features = Features.getInstance()
        var sensorFeatureFactory : SensorFeatureFactory = SensorFeatureFactory.getInstance()
        if (features.isFeature(sensorFeatureFactory.ORIENTATION_SENSORS)) {
            throw new Exception("No Orientation Sensors")
        } else if (features.isFeature(sensorFeatureFactory.SIMULATED_ORIENTATION_SENSORS)) {
            throw new Exception("No Simulation Sensors")
        } else if (features.isFeature(sensorFeatureFactory.NO_ORIENTATION)) {
            AccelerometerSensorFactory.allBinaryAccelerometerSensor = new NoAccelerometerSensor()
        } else {
            throw new Exception("Not Such SensorFeature")
        }
    }

    def getInstance() : AllBinaryOrientationSensor = {
        return AccelerometerSensorFactory.allBinaryAccelerometerSensor
    }

}


