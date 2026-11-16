/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.geographic.map

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.CellPositionsUtil
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition

/**  *  * @author user  */
class LayerCoveringCellPositionsUtil {
    import _root_.org.allbinary.game.layer.geographic.map.LayerCoveringCellPositionsUtil.{*}

    private val cellPositionsUtil : CellPositionsUtil = CellPositionsUtil.getInstance()

    final def getAllXY(geographicMapInterface : BasicGeographicMap, layerInterface : AllBinaryLayer, x : Int, y : Int, reusableList : BasicArrayList) : BasicArrayList = {
        val topLeftGeographicMapCellPosition : GeographicMapCellPosition = geographicMapInterface.getCellPositionAtXY(x, y)
        return this.getAll(geographicMapInterface, topLeftGeographicMapCellPosition, layerInterface, reusableList)
    }

    final def getAll(geographicMapInterface : BasicGeographicMap, topLeftGeographicMapCellPosition : GeographicMapCellPosition, layerInterface : AllBinaryLayer, reusableList : BasicArrayList) : BasicArrayList = {
        reusableList.clear()
        var columns : Int = layerInterface.getWidth() / geographicMapInterface.getAllBinaryTiledLayer().getCellWidth()
        var rows : Int = layerInterface.getHeight() / geographicMapInterface.getAllBinaryTiledLayer().getCellHeight()
        //this.logUtil.putF(new StringMaker().append("c/r: ").append(columns).append('/').append(rows).toString(), this, "visit");
        if (columns == 0) {
            columns = 1
        }
        if (rows == 0) {
            rows = 1
        }
        return this.cellPositionsUtil.getAll(geographicMapInterface, topLeftGeographicMapCellPosition, columns, rows, reusableList)
    }

}

object LayerCoveringCellPositionsUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : LayerCoveringCellPositionsUtil = new LayerCoveringCellPositionsUtil()

    /**      * @return the instance      */
    def getInstance() : LayerCoveringCellPositionsUtil = {
        return LayerCoveringCellPositionsUtil.instance
    }

}


