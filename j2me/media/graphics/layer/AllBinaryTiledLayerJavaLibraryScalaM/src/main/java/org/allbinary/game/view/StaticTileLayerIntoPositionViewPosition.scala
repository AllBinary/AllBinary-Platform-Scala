/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.view

import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.Layer
import _root_.org.allbinary.layer.NullLayer
import _root_.org.allbinary.view.ViewPosition

/**  *  * @author user  */
class StaticTileLayerIntoPositionViewPosition() extends ViewPosition(0, 0, 0) {
    import _root_.org.allbinary.game.view.StaticTileLayerIntoPositionViewPosition.{*}

    override def getX() : Int = {
        return super.getX() - StaticTileLayerIntoPositionViewPosition.tiledLayer.getXP()
    }

    override def getY() : Int = {
        return super.getY() - StaticTileLayerIntoPositionViewPosition.tiledLayer.getYP()
    }

    override def getZ() : Int = {
        return super.getZ() - StaticTileLayerIntoPositionViewPosition.tiledLayer.getZP()
    }

}

object StaticTileLayerIntoPositionViewPosition {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var tiledLayer : Layer = NullLayer.getInstance()

    var layer : AllBinaryLayer = AllBinaryLayer.NULL_ALLBINARY_LAYER

    //   }
    def setTiledLayer(tiledLayer : AllBinaryTiledLayer) : Unit = {
        StaticTileLayerIntoPositionViewPosition.tiledLayer = tiledLayer
    }

}


