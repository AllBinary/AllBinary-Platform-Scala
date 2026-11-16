/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.form

import _root_.org.allbinary.game.input.LayerPositionFinderInterface
import _root_.org.allbinary.game.layer.waypoint.WaypointCellPositionHistory
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.drop.DropCellPositionHistory

/**  *  * @author user  */
class AdvancedRTSGameLayerPositionFinder private() extends LayerPositionFinderInterface {
    import _root_.org.allbinary.game.input.form.AdvancedRTSGameLayerPositionFinder.{*}

    override def getLayerInterface(geographicMapCellPosition : GeographicMapCellPosition) : AllBinaryLayer = {
        var layerInterface : AllBinaryLayer = DropCellPositionHistory.getInstance().getLayerInterface(geographicMapCellPosition)
        if (layerInterface eq AllBinaryLayer.NULL_ALLBINARY_LAYER) {
            layerInterface = WaypointCellPositionHistory.getInstance().getLayerInterface(geographicMapCellPosition)
        }
        return layerInterface
    }

}

object AdvancedRTSGameLayerPositionFinder {
    private val instance : AdvancedRTSGameLayerPositionFinder = new AdvancedRTSGameLayerPositionFinder()

    /**      * @return the instance      */
    def getInstance() : AdvancedRTSGameLayerPositionFinder = {
        return AdvancedRTSGameLayerPositionFinder.instance
    }

}


