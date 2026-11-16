/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.gyro

import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.SensorFeatureFactory
import _root_.org.allbinary.logic.math.Orientation

class OrientationToGameKeyEvent() {

    private var allBinaryGyroSensor : AllBinaryOrientationSensor = null

    private val MIN : Int = 15

    //Constructor
    {
        if (Features.getInstance().isFeature(SensorFeatureFactory.getInstance().NO_ORIENTATION)) {
            this.allBinaryGyroSensor = new NoGyroSensor()
        } else {
            throw new Exception("Not Such Feature")
        }
    }

    def setAllBinaryGyroSensor(allBinaryGyroSensor : AllBinaryOrientationSensor) : Unit = {
        this.allBinaryGyroSensor = allBinaryGyroSensor
    }

    def getAllBinaryGyroSensor() : AllBinaryOrientationSensor = {
        return this.allBinaryGyroSensor
    }

    def process() : Unit = {
    }

    private def updateGameKeyEvents(orientation : Orientation, yaw : Int, pitch : Int, roll : Int) : Unit = {
    }

}


