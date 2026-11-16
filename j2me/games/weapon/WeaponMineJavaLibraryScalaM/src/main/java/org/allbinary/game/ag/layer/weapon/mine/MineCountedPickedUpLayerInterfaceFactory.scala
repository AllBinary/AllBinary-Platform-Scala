/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.weapon.mine

import _root_.org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.game.combat.weapon.WeaponProperties
import _root_.org.allbinary.game.layer.pickup.CountedPickedUpLayerInterfaceFactory
import _root_.org.allbinary.game.layer.pickup.IconLayerFactory
import _root_.org.allbinary.game.layer.pickup.PickedUpLayerInterfaceFactoryInterface
import _root_.org.allbinary.game.layer.pickup.PickedUpLayerTypeFactory
import _root_.org.allbinary.game.layer.weapon.WeaponLayerCircularPool
import _root_.org.allbinary.game.score.ScoreableInterface
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.util.ABHashtable

class MineCountedPickedUpLayerInterfaceFactory private() extends CountedPickedUpLayerInterfaceFactory(PickedUpLayerTypeFactory.getInstance().MINE, IconLayerFactory.getInstance(FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(MineWeaponResources.getInstance().DROP_ICON_RESOURCE).getInstance(0), 10, 10), FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(MineWeaponResources.getInstance().DROP_RESOURCE).getInstance(0)) {
    import _root_.org.allbinary.game.ag.layer.weapon.mine.MineCountedPickedUpLayerInterfaceFactory.{*}

    private val weaponLayerCircularStaticPool : WeaponLayerCircularPool = MineLayerCircularStaticPool.getInstance()

    private val weaponProperties : WeaponProperties = new WeaponProperties(-1L, -1L, 0, 8000, (10).toShort)

    private val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()

    override def getTotal() : Int = {
        return 3
    }

    override def getNextInstance(hashtable : ABHashtable[Object, Object], x : Int, y : Int, z : Int) : AllBinaryLayer = {
        val sourceLayerInterface : AllBinaryLayer = hashtable.get(this.smallIntegerSingletonFactory.getAt(0).asInstanceOf[Object]).asInstanceOf[AllBinaryLayer]
        val angle : Integer = hashtable.get(this.smallIntegerSingletonFactory.getAt(1).asInstanceOf[Object]).asInstanceOf[Integer]
        val scoreableInterface : ScoreableInterface = sourceLayerInterface.asInstanceOf[ScoreableInterface]
        return this.weaponLayerCircularStaticPool.getInstanceWeaponLayer(sourceLayerInterface, x, y, z, angle.intValue().toInt, 0, this.weaponProperties, scoreableInterface)
    }

}

object MineCountedPickedUpLayerInterfaceFactory {
    private var pickedUpLayerInterfaceFactoryInterface : PickedUpLayerInterfaceFactoryInterface = CountedPickedUpLayerInterfaceFactory.NULL_COUNTED_PICKUP_LAYER_FACTORY

    def init() : Unit = {
        MineCountedPickedUpLayerInterfaceFactory.pickedUpLayerInterfaceFactoryInterface = new MineCountedPickedUpLayerInterfaceFactory()
    }

    def getInstance() : PickedUpLayerInterfaceFactoryInterface = {
        return MineCountedPickedUpLayerInterfaceFactory.pickedUpLayerInterfaceFactoryInterface
    }

}


