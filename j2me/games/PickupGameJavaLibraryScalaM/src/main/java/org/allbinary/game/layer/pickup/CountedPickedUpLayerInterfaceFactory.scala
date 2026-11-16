/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.pickup

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList

class CountedPickedUpLayerInterfaceFactory(param_pickeUpLayerType : PickedUpLayerType, param_iconLayer : IconLayer, param_animationInterface : Animation) extends PickedUpLayerInterfaceFactory(param_pickeUpLayerType, param_iconLayer, param_animationInterface) with CountedPickedUpLayerInterfaceFactoryInterface {
    import _root_.org.allbinary.game.layer.pickup.CountedPickedUpLayerInterfaceFactory.{NULL_COUNTED_PICKUP_LAYER_FACTORY as _, *}
    def NULL_COUNTED_PICKUP_LAYER_FACTORY : CountedPickedUpLayerInterfaceFactory = _root_.org.allbinary.game.layer.pickup.CountedPickedUpLayerInterfaceFactory.NULL_COUNTED_PICKUP_LAYER_FACTORY

    private var id : Int = 0

    //Constructor
    {
        val pickeUpLayerType : PickedUpLayerType = param_pickeUpLayerType
        val iconLayer : IconLayer = param_iconLayer
        val animationInterface : Animation = param_animationInterface
        //that creates the parts list or array
        var list : BasicArrayList = CountedPickedUpLayerInterfaceFactoryPool.getInstance().getList()
        this.id = list.size()
        list.add(this)
    }

    override def getNextInstance(hashtable : ABHashtable[Object, Object], x : Int, y : Int, z : Int) : AllBinaryLayer = {
        throw new Exception(CommonStrings.getInstance().NOT_IMPLEMENTED)
    }

    override def getTotal() : Int = {
        return -1
    }

    override def getId() : Int = {
        return this.id
    }

}

object CountedPickedUpLayerInterfaceFactory {
    val NULL_COUNTED_PICKUP_LAYER_FACTORY : CountedPickedUpLayerInterfaceFactory = new CountedPickedUpLayerInterfaceFactory(PickedUpLayerTypeFactory.getInstance().NONE, IconLayer.NULL_ICON_LAYER, NullAnimationFactory.getFactoryInstance().getInstance(0))

}


