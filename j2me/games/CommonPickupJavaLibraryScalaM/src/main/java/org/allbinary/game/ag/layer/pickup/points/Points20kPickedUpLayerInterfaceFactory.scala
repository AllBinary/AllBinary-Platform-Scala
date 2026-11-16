/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.pickup.points

import _root_.org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.game.configuration.GameConfigurationUtil
import _root_.org.allbinary.game.layer.pickup.CountedPickedUpLayerInterfaceFactory
import _root_.org.allbinary.game.layer.pickup.IconLayerFactory
import _root_.org.allbinary.game.layer.pickup.PickedUpLayerInterfaceFactory
import _root_.org.allbinary.game.layer.pickup.PickedUpLayerInterfaceFactoryInterface
import _root_.org.allbinary.game.layer.pickup.PickedUpLayerTypeFactory
import _root_.org.allbinary.game.layer.pickup.PickupProcessorInterface
import _root_.org.allbinary.layer.AllBinaryLayer

class Points20kPickedUpLayerInterfaceFactory private() extends PickedUpLayerInterfaceFactory(PickedUpLayerTypeFactory.getInstance().POINTS, IconLayerFactory.getInstance(FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(PointsResources.getInstance().RESOURCE_2).getInstance(0), 10, 10), FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(PointsResources.getInstance().RESOURCE_2).getInstance(0)) with PickupProcessorInterface {
    import _root_.org.allbinary.game.ag.layer.pickup.points.Points20kPickedUpLayerInterfaceFactory.{*}

    private var pool : PointsLayerCircularStaticPool = new PointsLayerCircularStaticPool(new PointsLayerFactory(GameConfigurationUtil.getInstance().getCompetitionValue() * 20000), 1)

    def getTotal() : Int = {
        return 1
    }

    override def process(sourceLayerInterface : AllBinaryLayer) : Unit = {
        this.pool.visit(sourceLayerInterface)
    }

}

object Points20kPickedUpLayerInterfaceFactory {
    private var pickedUpLayerInterfaceFactoryInterface : PickedUpLayerInterfaceFactoryInterface = CountedPickedUpLayerInterfaceFactory.NULL_COUNTED_PICKUP_LAYER_FACTORY

    def init() : Unit = {
        Points20kPickedUpLayerInterfaceFactory.pickedUpLayerInterfaceFactoryInterface = new Points20kPickedUpLayerInterfaceFactory()
    }

    def getInstance() : PickedUpLayerInterfaceFactoryInterface = {
        return Points20kPickedUpLayerInterfaceFactory.pickedUpLayerInterfaceFactoryInterface
    }

}


