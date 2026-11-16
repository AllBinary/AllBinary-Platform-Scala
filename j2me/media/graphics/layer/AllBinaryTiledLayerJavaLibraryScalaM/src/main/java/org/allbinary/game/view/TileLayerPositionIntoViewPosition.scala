/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.view

import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.layer.Layer
import _root_.org.allbinary.layer.NullLayer
import _root_.org.allbinary.view.ViewPosition

/**  *  * @author user  */
class TileLayerPositionIntoViewPosition() extends ViewPosition(0, 0, 0) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var tiledLayer : Layer = NullLayer.getInstance()

    override def getX() : Int = {
        return super.getX() - this.tiledLayer.getXP()
    }

    override def getY() : Int = {
        return super.getY() - this.tiledLayer.getYP()
    }

    override def getZ() : Int = {
        return super.getZ() - this.tiledLayer.getZP()
    }

    def setTiledLayer(tiledLayer : AllBinaryTiledLayer) : Unit = {
        this.tiledLayer = tiledLayer
    }

}


