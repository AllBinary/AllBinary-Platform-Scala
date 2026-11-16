/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.health

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.ProceduralAnimationInterfaceFactoryInterface
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.media.ScaleProperties

class HealthBarAnimationInterfaceFactory() extends AnimationInterfaceFactoryInterface with ProceduralAnimationInterfaceFactoryInterface {

    def getInstanceByLocation(layerInterface : AllBinaryLayer, location : Int) : HealthBarAnimation = {
        return new HealthBarThreedAnimation(layerInterface, location)
    }

    override def getInstance(instanceId : Int) : Animation = {
        return null
    }

    override def getInstanceAnimation(animationInterface : Animation) : Animation = {
        return null
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}


