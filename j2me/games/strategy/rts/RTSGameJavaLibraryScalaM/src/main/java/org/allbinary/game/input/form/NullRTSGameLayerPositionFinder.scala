/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.form

import _root_.org.allbinary.game.input.LayerPositionFinderInterface
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.drop.DropCellPositionHistory

/**  *  * @author user  */
class NullRTSGameLayerPositionFinder() extends LayerPositionFinderInterface {
    import _root_.org.allbinary.game.input.form.NullRTSGameLayerPositionFinder.{*}

    override def getLayerInterface(geographicMapCellPosition : GeographicMapCellPosition) : AllBinaryLayer = {
        var layerInterface : AllBinaryLayer = DropCellPositionHistory.getInstance().getLayerInterface(geographicMapCellPosition)
        return layerInterface
    }

}

object NullRTSGameLayerPositionFinder {
    private val instance : NullRTSGameLayerPositionFinder = new NullRTSGameLayerPositionFinder()

    /**      * @return the instance      */
    def getInstance() : NullRTSGameLayerPositionFinder = {
        return NullRTSGameLayerPositionFinder.instance
    }

}


