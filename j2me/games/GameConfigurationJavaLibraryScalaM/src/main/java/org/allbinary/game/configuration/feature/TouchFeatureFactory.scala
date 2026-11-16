/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature


class TouchFeatureFactory private() {
    import _root_.org.allbinary.game.configuration.feature.TouchFeatureFactory.{*}

    val TOUCH_ENABLED : TouchFeature = new TouchFeature("Touch Enabled")

    val SHOW_SCREEN_BUTTONS : TouchFeature = new TouchFeature("Show")

    val AUTO_HIDE_SHOW_SCREEN_BUTTONS : TouchFeature = new TouchFeature("Auto Hide (One Level)")

    val HIDE_SCREEN_BUTTONS : TouchFeature = new TouchFeature("Hide")

}

object TouchFeatureFactory {
    private val instance : TouchFeatureFactory = new TouchFeatureFactory()

    def getInstance() : TouchFeatureFactory = {
        return TouchFeatureFactory.instance
    }

}


