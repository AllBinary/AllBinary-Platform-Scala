/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.pickup

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.layer.AllBinaryLayer

/**  *  * @author User  */
class PickedUpLayerInterfaceFactoryBase extends PickedUpLayerInterfaceFactoryInterface {
    import _root_.org.allbinary.game.layer.pickup.PickedUpLayerInterfaceFactoryBase.{NULL_PICKED_UP_LAYER_FACTORY_BASE as _, *}
    def NULL_PICKED_UP_LAYER_FACTORY_BASE : PickedUpLayerInterfaceFactoryBase = _root_.org.allbinary.game.layer.pickup.PickedUpLayerInterfaceFactoryBase.NULL_PICKED_UP_LAYER_FACTORY_BASE

    override def getIconLayer() : AllBinaryLayer = {
        throw new RuntimeException()
    }

    override def getAnimationInterface() : Animation = {
        throw new RuntimeException()
    }

    override def getPickedUpLayerType() : PickedUpLayerType = {
        throw new RuntimeException()
    }

}

object PickedUpLayerInterfaceFactoryBase {
    val NULL_PICKED_UP_LAYER_FACTORY_BASE : PickedUpLayerInterfaceFactoryBase = new PickedUpLayerInterfaceFactoryBase()

}


