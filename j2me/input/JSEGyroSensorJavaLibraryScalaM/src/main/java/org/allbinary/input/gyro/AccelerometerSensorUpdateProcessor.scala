/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.gyro

import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.SensorFeatureFactory
import _root_.org.allbinary.game.input.motion.action.NoCompleteMotionGestureInputEventListener
import _root_.org.allbinary.game.input.motion.action.SingleKeyPressGameKeyFromMotionGestureEventListener
import _root_.org.allbinary.input.accelerometer.AccelerometerSensorFactory

class AccelerometerSensorUpdateProcessor extends Processor {

    override def process() : Unit = {
        var sensorFeatureFactory : SensorFeatureFactory = SensorFeatureFactory.getInstance()
        // Stop/Start sensor input
        if (Features.getInstance().isFeature(sensorFeatureFactory.ORIENTATION_SENSORS)) {
            AccelerometerSensorFactory.getInstance().setCompleteMotionGestureInputEventListener(new SingleKeyPressGameKeyFromMotionGestureEventListener())
        } else if (Features.getInstance().isFeature(sensorFeatureFactory.SIMULATED_ORIENTATION_SENSORS)) {
            AccelerometerSensorFactory.getInstance().setCompleteMotionGestureInputEventListener(new SingleKeyPressGameKeyFromMotionGestureEventListener())
        } else if (Features.getInstance().isFeature(sensorFeatureFactory.NO_ORIENTATION)) {
            AccelerometerSensorFactory.getInstance().setCompleteMotionGestureInputEventListener(NoCompleteMotionGestureInputEventListener.getInstance())
        } else {
            throw new Exception("Sensor Feature Not Set")
        }
    }

}


