/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.gyro

import _root_.org.allbinary.game.input.CompleteMotionGestureInputEventListenerInterface
import _root_.org.allbinary.game.input.motion.action.NoCompleteMotionGestureInputEventListener
import _root_.org.allbinary.input.AllBinarySensor
import _root_.org.allbinary.logic.math.Orientation
import _root_.org.allbinary.logic.math.PrimitiveFloatUtil

class AllBinaryOrientationSensor() extends AllBinarySensor {
    import _root_.org.allbinary.input.gyro.AllBinaryOrientationSensor.{NULL_ALLBINARY_ORIENTATION_SENSOR as _, *}
    def NULL_ALLBINARY_ORIENTATION_SENSOR : AllBinaryOrientationSensor = _root_.org.allbinary.input.gyro.AllBinaryOrientationSensor.NULL_ALLBINARY_ORIENTATION_SENSOR

    var sensorDataFloatArray : Array[Float] = PrimitiveFloatUtil.getArrayInstance()

    var listener : CompleteMotionGestureInputEventListenerInterface = NoCompleteMotionGestureInputEventListener.getInstance()

    def setCompleteMotionGestureInputEventListener(completeMotionGestureInputEventListenerInterface : CompleteMotionGestureInputEventListenerInterface) : Unit = {
        this.listener = completeMotionGestureInputEventListenerInterface
    }

    def getOrientation() : Orientation = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

}

object AllBinaryOrientationSensor {
    val NULL_ALLBINARY_ORIENTATION_SENSOR : AllBinaryOrientationSensor = new AllBinaryOrientationSensor()

}


