/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.pickup

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.layer.AllBinaryLayer

class PickedUpLayerInterfaceFactory(param_pickeUpLayerType : PickedUpLayerType, param_iconLayer : IconLayer, param_animationInterface : Animation) extends PickedUpLayerInterfaceFactoryBase {

    private var pickedUpLayerType : PickedUpLayerType = null

    private var iconLayer : IconLayer = null

    private var animationInterface : Animation = null

    //Constructor
    {
        val pickeUpLayerType : PickedUpLayerType = param_pickeUpLayerType
        val iconLayer : IconLayer = param_iconLayer
        val animationInterface : Animation = param_animationInterface
        this.pickedUpLayerType = pickeUpLayerType
        this.animationInterface = animationInterface
        this.iconLayer = iconLayer
    }

    override def getIconLayer() : AllBinaryLayer = {
        return this.iconLayer
    }

    override def getAnimationInterface() : Animation = {
        return this.animationInterface
    }

    override def getPickedUpLayerType() : PickedUpLayerType = {
        return this.pickedUpLayerType
    }

}


