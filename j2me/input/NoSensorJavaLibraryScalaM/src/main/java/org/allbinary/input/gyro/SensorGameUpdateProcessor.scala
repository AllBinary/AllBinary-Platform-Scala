/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.gyro

import _root_.org.allbinary.input.AllBinarySensor
import _root_.org.allbinary.input.NoAllBinarySensor

class SensorGameUpdateProcessor {

    private var inputSensor : AllBinarySensor = NoAllBinarySensor.getInstance()

    def setInputSensor(inputSensor : AllBinarySensor) : Unit = {
        this.inputSensor = inputSensor
    }

    def getInputSensor() : AllBinarySensor = {
        return this.inputSensor
    }

    //public void process(AllBinaryGameLayerManager layerManager) throws Exception
    def process(anyType : Object) : Unit = {
    }

    //public void sendNotifications(AllBinaryGameLayerManager layerManager) throws Exception
    def sendNotifications(anyType : Object) : Unit = {
    }

    def isAnySensor() : Boolean = {
        if (this.inputSensor eq NoAllBinarySensor.getInstance()) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    def setNoSensors() : Unit = {
        this.setInputSensor(NoAllBinarySensor.getInstance())
    }

}


