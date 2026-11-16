/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.pickup

import _root_.org.allbinary.layer.AllBinaryLayerCircularPool

class PickupLayerCircularStaticPool private() extends AllBinaryLayerCircularPool {
    import _root_.org.allbinary.game.layer.pickup.PickupLayerCircularStaticPool.{*}

    def getInstanceXYZ(pickedUpLayerInterfaceFactoryInterface : PickedUpLayerInterfaceFactoryInterface, x : Int, y : Int, z : Int) : PickedUpLayerInterface = {
        val pickupLayer : PickupLayer = this.getNextInstance().asInstanceOf[PickupLayer]
        pickupLayer.initXYZ(x, y, z)
        pickupLayer.init(pickedUpLayerInterfaceFactoryInterface, pickedUpLayerInterfaceFactoryInterface.getAnimationInterface())
        return pickupLayer
    }

}

object PickupLayerCircularStaticPool {
    private var SINGLETON : PickupLayerCircularStaticPool = new PickupLayerCircularStaticPool()

    def getInstance() : PickupLayerCircularStaticPool = {
        return PickupLayerCircularStaticPool.SINGLETON
    }

}


