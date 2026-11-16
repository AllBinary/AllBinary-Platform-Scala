/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.pickup.health

import _root_.org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.game.layer.pickup.CountedPickedUpLayerInterfaceFactory
import _root_.org.allbinary.game.layer.pickup.IconLayerFactory
import _root_.org.allbinary.game.layer.pickup.PickedUpLayerInterfaceFactory
import _root_.org.allbinary.game.layer.pickup.PickedUpLayerInterfaceFactoryInterface
import _root_.org.allbinary.game.layer.pickup.PickedUpLayerTypeFactory
import _root_.org.allbinary.game.layer.pickup.PickupProcessorInterface
import _root_.org.allbinary.layer.AllBinaryLayer

class HealPickedUpLayerInterfaceFactory private() extends PickedUpLayerInterfaceFactory(PickedUpLayerTypeFactory.getInstance().HEAL, IconLayerFactory.getInstance(FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(HealthResources.getInstance().RESOURCE).getInstance(0), 10, 10), FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(HealthResources.getInstance().RESOURCE).getInstance(0)) with PickupProcessorInterface {
    import _root_.org.allbinary.game.ag.layer.pickup.health.HealPickedUpLayerInterfaceFactory.{*}

    private var pool : HealLayerCircularStaticPool = new HealLayerCircularStaticPool(new HealLayerFactory(), 1)

    def getTotal() : Int = {
        return 1
    }

    override def process(sourceLayerInterface : AllBinaryLayer) : Unit = {
        this.pool.visit(sourceLayerInterface)
    }

}

object HealPickedUpLayerInterfaceFactory {
    private var pickedUpLayerInterfaceFactoryInterface : PickedUpLayerInterfaceFactoryInterface = CountedPickedUpLayerInterfaceFactory.NULL_COUNTED_PICKUP_LAYER_FACTORY

    def init() : Unit = {
        HealPickedUpLayerInterfaceFactory.pickedUpLayerInterfaceFactoryInterface = new HealPickedUpLayerInterfaceFactory()
    }

    def getInstance() : PickedUpLayerInterfaceFactoryInterface = {
        return HealPickedUpLayerInterfaceFactory.pickedUpLayerInterfaceFactoryInterface
    }

}


