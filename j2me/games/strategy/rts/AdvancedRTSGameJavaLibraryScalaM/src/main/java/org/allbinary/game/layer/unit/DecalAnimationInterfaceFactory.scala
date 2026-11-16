/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.unit

import _root_.org.allbinary.game.layer.resources.BasicGameResources
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.animation.NullRotationAnimationFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory

class DecalAnimationInterfaceFactory {
    import _root_.org.allbinary.game.layer.unit.DecalAnimationInterfaceFactory.{*}

    def getAnimationFactory(basicGameResources : BasicGameResources, basicColor : BasicColor) : AnimationInterfaceFactoryInterface = {
        var animationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = null
        if (basicColor eq BasicColorFactory.getInstance().RED) {
            animationInterfaceFactoryInterface = FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(basicGameResources.RESOURCE)
        } else {
            animationInterfaceFactoryInterface = NullRotationAnimationFactory.getFactoryInstance()
        }
        return animationInterfaceFactoryInterface
    }

}

object DecalAnimationInterfaceFactory {
    private val instance : DecalAnimationInterfaceFactory = new DecalAnimationInterfaceFactory()

    def getInstance() : DecalAnimationInterfaceFactory = {
        return DecalAnimationInterfaceFactory.instance
    }

}


