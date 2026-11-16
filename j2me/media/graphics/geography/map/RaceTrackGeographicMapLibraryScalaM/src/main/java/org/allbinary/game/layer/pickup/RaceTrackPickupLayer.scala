/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.pickup

import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.game.identification.BasicGroupFactory
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo
import _root_.org.allbinary.game.view.TileLayerPositionIntoViewPosition
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.view.ViewPosition
import _root_.org.allbinary.view.event.ViewPositionEventHandler

class RaceTrackPickupLayer() extends PickupLayer(_root_.org.allbinary.game.layer.pickup.RaceTrackPickupLayer.NAME, RemoteInfo.REMOTE_INFO, 0, CountedPickedUpLayerInterfaceFactory.NULL_COUNTED_PICKUP_LAYER_FACTORY, NullAnimationFactory.getFactoryInstance().getInstance(0), new Rectangle(PointFactory.getInstance().ZERO_ZERO, 0, 0), new TileLayerPositionIntoViewPosition()) {
    import _root_.org.allbinary.game.layer.pickup.RaceTrackPickupLayer.{*}

    private val viewPositionEventHandler : ViewPositionEventHandler = ViewPositionEventHandler.getInstance()

    def setTiledLayer(tiledLayer : AllBinaryTiledLayer) : Unit = {
        val viewPosition : TileLayerPositionIntoViewPosition = this.getViewPosition().asInstanceOf[TileLayerPositionIntoViewPosition]
        viewPosition.setTiledLayer(tiledLayer)
        this.viewPositionEventHandler.addListener(this.asInstanceOf[AllBinaryLayer])
    }

    override def setDestroyed(destroyed : Boolean) : Unit = {
        super.setDestroyed(destroyed)
        if (this.isDestroyed()) {
            this.viewPositionEventHandler.removeListener(this)
        }
    }

}

object RaceTrackPickupLayer {
    private val NAME : String = "RaceTrackPickupLayer"

}


