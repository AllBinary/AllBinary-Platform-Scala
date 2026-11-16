/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration

import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureChoiceGroups
import _root_.org.allbinary.game.configuration.feature.InGameFeatureChoiceGroups
import _root_.org.allbinary.game.configuration.feature.SensorFeatureFactory
import _root_.org.allbinary.game.configuration.feature.TouchFeatureFactory
import _root_.org.allbinary.init.Init
import _root_.org.allbinary.input.gyro.OrientationData
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class InGameFeatures extends Init {

    override def init() : Unit = {
        val LABEL : String = "Screen Buttons"
        val orientationData : OrientationData = OrientationData.getInstance()
        val exclusiveOrientationSensorVector : BasicArrayList = GameFeatureChoiceGroups.getExclusiveInstance().get().get(orientationData.ORIENTATION_SENSOR_INPUT.asInstanceOf[Object]).asInstanceOf[BasicArrayList]
        val inGameFeatureChoiceGroups : InGameFeatureChoiceGroups = InGameFeatureChoiceGroups.getExclusiveInstance()
        if (exclusiveOrientationSensorVector != null) {
            val inGameExclusiveOrientationSensorVectorCanBeNull : Object = inGameFeatureChoiceGroups.get().get(orientationData.ORIENTATION_SENSOR_INPUT.asInstanceOf[Object])
            if (inGameExclusiveOrientationSensorVectorCanBeNull == null) {
                this.addToInGameMenu()
            } else {
                val inGameExclusiveOrientationSensorVector : BasicArrayList = inGameExclusiveOrientationSensorVectorCanBeNull.asInstanceOf[BasicArrayList]
                if (inGameExclusiveOrientationSensorVector.size() == 0) {
                    this.addToInGameMenu()
                }
            }
        }
        val features : Features = Features.getInstance()
        if ((features.isFeature(TouchFeatureFactory.getInstance().SHOW_SCREEN_BUTTONS) || features.isFeature(TouchFeatureFactory.getInstance().AUTO_HIDE_SHOW_SCREEN_BUTTONS)) || features.isFeature(TouchFeatureFactory.getInstance().HIDE_SCREEN_BUTTONS)) {
            val exclusiveScreenButtonsVector : BasicArrayList = new BasicArrayListD()
            val touchFeatureFactory : TouchFeatureFactory = TouchFeatureFactory.getInstance()
            exclusiveScreenButtonsVector.add(touchFeatureFactory.AUTO_HIDE_SHOW_SCREEN_BUTTONS)
            exclusiveScreenButtonsVector.add(touchFeatureFactory.SHOW_SCREEN_BUTTONS)
            exclusiveScreenButtonsVector.add(touchFeatureFactory.HIDE_SCREEN_BUTTONS)
            inGameFeatureChoiceGroups.add(LABEL, exclusiveScreenButtonsVector)
        }
    }

    private def addToInGameMenu() : Unit = {
        val orientationData : OrientationData = OrientationData.getInstance()
        val inGameExclusiveOrientationSensorVector : BasicArrayList = new BasicArrayListD()
        inGameExclusiveOrientationSensorVector.add(SensorFeatureFactory.getInstance().ORIENTATION_SENSORS)
        inGameExclusiveOrientationSensorVector.add(SensorFeatureFactory.getInstance().NO_ORIENTATION)
        InGameFeatureChoiceGroups.getExclusiveInstance().add(orientationData.ORIENTATION_SENSOR_INPUT, inGameExclusiveOrientationSensorVector)
    }

    def isAny() : Boolean = {
        val features : Features = Features.getInstance()
        val touchFeatureFactory : TouchFeatureFactory = TouchFeatureFactory.getInstance()
        if ((features.isFeature(touchFeatureFactory.SHOW_SCREEN_BUTTONS) || features.isFeature(touchFeatureFactory.AUTO_HIDE_SHOW_SCREEN_BUTTONS)) || features.isFeature(touchFeatureFactory.HIDE_SCREEN_BUTTONS)) {
            return true
        }
        val exclusiveOrientationSensorVector : BasicArrayList = GameFeatureChoiceGroups.getExclusiveInstance().get().get(OrientationData.getInstance().ORIENTATION_SENSOR_INPUT.asInstanceOf[Object]).asInstanceOf[BasicArrayList]
        if (exclusiveOrientationSensorVector != null) {
            return true
        }
        return false
    }

}


