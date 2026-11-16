/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.health

import _root_.org.allbinary.graphics.opengles.OpenGLFeatureUtil
import _root_.org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.layer.AllBinaryLayer

class HealthBarFactory {

    def getInstance(layerInterface : AllBinaryLayer, healthInterface : Health, location : Int, direction : Int) : HealthBar = {
        if (OpenGLFeatureUtil.getInstance().isAnyThreed()) {
            var featuredAnimationInterfaceFactoryInterfaceFactory : FeaturedAnimationInterfaceFactoryInterfaceFactory = FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance()
            var healthBarAnimationInterfaceFactory : HealthBarAnimationInterfaceFactory = featuredAnimationInterfaceFactoryInterfaceFactory.get(Health.NAME).asInstanceOf[HealthBarAnimationInterfaceFactory]
            return new HealthBar(layerInterface, healthInterface, healthBarAnimationInterfaceFactory.getInstanceByLocation(layerInterface, location), direction)
        } else {
            return new HealthBar(layerInterface, healthInterface, new HealthBarTwodAnimation(layerInterface, location), direction)
        }
        throw new IllegalStateException()
    }

}


