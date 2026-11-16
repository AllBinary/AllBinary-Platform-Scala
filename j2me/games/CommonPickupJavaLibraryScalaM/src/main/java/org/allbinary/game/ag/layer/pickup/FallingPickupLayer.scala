/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.pickup

import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.game.layer.pickup.CountedPickedUpLayerInterfaceFactory
import _root_.org.allbinary.game.layer.pickup.PickupLayer
import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo
import _root_.org.allbinary.game.tick.TickableInterface
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.view.ViewPosition

class FallingPickupLayer(param_remoteInfo : RemoteInfo) extends PickupLayer(FallingPickupLayer.NAME, param_remoteInfo, 0, CountedPickedUpLayerInterfaceFactory.NULL_COUNTED_PICKUP_LAYER_FACTORY, NullAnimationFactory.getFactoryInstance().getInstance(0), new Rectangle(PointFactory.getInstance().ZERO_ZERO, 0, 0), ViewPosition.getInstanceD()) with TickableInterface {
    import _root_.org.allbinary.game.ag.layer.pickup.FallingPickupLayer.{*}

    //Constructor
    {
        val remoteInfo : RemoteInfo = param_remoteInfo
    }

    override def processTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        this.setPosition(this.x, this.y + 1, this.z)
    }

    override def implmentsTickableInterface() : Boolean = {
        return true
    }

}

object FallingPickupLayer {
    private val NAME : String = "FallingPickupLayer"

}


