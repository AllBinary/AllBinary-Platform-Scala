/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature


class SensorFeatureFactory private() {
    import _root_.org.allbinary.game.configuration.feature.SensorFeatureFactory.{*}

    val NO_ORIENTATION : SensorFeature = new SensorFeature("No Orientation")

    val ORIENTATION_SENSORS : SensorFeature = new SensorFeature("Orientation Sensors")

    val SIMULATED_ORIENTATION_SENSORS : SensorFeature = new SensorFeature("Simulated Orientation Sensors")

    val YAW : SensorFeature = new SensorFeature("Yaw")

    val YAW_MINUS_RIGHT_PLUS_LEFT : SensorFeature = new SensorFeature("Yaw -Right +Left")

    val YAW_MINUS_LEFT_PLUS_RIGHT : SensorFeature = new SensorFeature("Yaw -Left +Right ")

    val PITCH : SensorFeature = new SensorFeature("Pitch")

    val ROLL : SensorFeature = new SensorFeature("Roll")

}

object SensorFeatureFactory {
    private val instance : SensorFeatureFactory = new SensorFeatureFactory()

    def getInstance() : SensorFeatureFactory = {
        return SensorFeatureFactory.instance
    }

}


