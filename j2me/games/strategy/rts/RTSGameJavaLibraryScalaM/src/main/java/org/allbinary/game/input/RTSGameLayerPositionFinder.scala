/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.drop.DropCellPositionHistory

/**  *  * @author user  */
class RTSGameLayerPositionFinder private() extends LayerPositionFinderInterface {
    import _root_.org.allbinary.game.input.RTSGameLayerPositionFinder.{*}

    override def getLayerInterface(geographicMapCellPosition : GeographicMapCellPosition) : AllBinaryLayer = {
        return DropCellPositionHistory.getInstance().getLayerInterface(geographicMapCellPosition)
    }

}

object RTSGameLayerPositionFinder {
    private val instance : RTSGameLayerPositionFinder = new RTSGameLayerPositionFinder()

    /**      * @return the instance      */
    def getInstance() : RTSGameLayerPositionFinder = {
        return RTSGameLayerPositionFinder.instance
    }

}


