/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.view

import _root_.org.allbinary.game.view.TileLayerPositionIntoViewPosition
import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface

class TileLayerPositionIntoViewPositionUtil {
    import _root_.org.allbinary.game.view.TileLayerPositionIntoViewPositionUtil.{*}

}

object TileLayerPositionIntoViewPositionUtil {
    def init(gameCanvasInterface : AllBinaryGameCanvas, viewPosition : TileLayerPositionIntoViewPosition) : Unit = {
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = gameCanvasInterface.getLayerManager().asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        val tiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        viewPosition.setTiledLayer(tiledLayer)
    }

}


