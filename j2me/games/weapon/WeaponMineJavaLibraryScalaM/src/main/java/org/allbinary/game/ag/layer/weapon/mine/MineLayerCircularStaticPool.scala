/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.weapon.mine

import _root_.org.allbinary.game.layer.weapon.WeaponLayerCircularPool
import _root_.org.allbinary.view.ViewPositionFactoryInterface

class MineLayerCircularStaticPool {
    import _root_.org.allbinary.game.ag.layer.weapon.mine.MineLayerCircularStaticPool.{*}

}

object MineLayerCircularStaticPool {
    private var WEAPON_LAYER_CIRCULAR_STATIC_POOL : WeaponLayerCircularPool = new WeaponLayerCircularPool()

    def init(viewPositionFactoryInterface : ViewPositionFactoryInterface) : Unit = {
        MineCountedPickedUpLayerInterfaceFactory.init()
        MineLayerCircularStaticPool.WEAPON_LAYER_CIRCULAR_STATIC_POOL.initAllBinaryLayerCircularPool(new MineLayerFactory(viewPositionFactoryInterface), 20)
    }

    def getInstance() : WeaponLayerCircularPool = {
        return MineLayerCircularStaticPool.WEAPON_LAYER_CIRCULAR_STATIC_POOL
    }

}


