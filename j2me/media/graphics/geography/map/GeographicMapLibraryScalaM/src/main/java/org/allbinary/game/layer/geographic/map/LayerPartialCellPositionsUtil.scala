/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.geographic.map

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory

/**  *  * @author user  *  * This class finds all GeographicMapCellPositions that a layer covers  * including those that are partially covered.  */
class LayerPartialCellPositionsUtil {
    import _root_.org.allbinary.game.layer.geographic.map.LayerPartialCellPositionsUtil.{*}

    //Assumes that entire layer is on the map //not
    final def getAll(geographicMapInterface : BasicGeographicMap, layerInterface : AllBinaryLayer, reusableList : BasicArrayList) : BasicArrayList = {
        reusableList.clear()
        var topLeftGeographicMapCellPosition : GeographicMapCellPosition = geographicMapInterface.getCellPositionAtXYNoThrow(layerInterface.getXP(), layerInterface.getYP())
        var topRightGeographicMapCellPosition : GeographicMapCellPosition = geographicMapInterface.getCellPositionAtXYNoThrow(layerInterface.getXP() + layerInterface.getWidth(), layerInterface.getYP())
        var bottomLeftGeographicMapCellPosition : GeographicMapCellPosition = geographicMapInterface.getCellPositionAtXYNoThrow(layerInterface.getXP(), layerInterface.getYP() + layerInterface.getHeight())
        var bottomRightGeographicMapCellPosition : GeographicMapCellPosition = geographicMapInterface.getCellPositionAtXYNoThrow(layerInterface.getXP() + layerInterface.getWidth(), layerInterface.getYP() + layerInterface.getHeight())
        if (topLeftGeographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            reusableList.add(topLeftGeographicMapCellPosition)
        }
        if ((topRightGeographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) && (topLeftGeographicMapCellPosition ne topRightGeographicMapCellPosition)) {
            reusableList.add(topRightGeographicMapCellPosition)
        }
        if ((bottomLeftGeographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) && !reusableList.contains(bottomLeftGeographicMapCellPosition)) {
            reusableList.add(bottomLeftGeographicMapCellPosition)
        }
        if ((bottomRightGeographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) && !reusableList.contains(bottomRightGeographicMapCellPosition)) {
            reusableList.add(bottomRightGeographicMapCellPosition)
        }
        return reusableList
    }

    final def getAllDXY(geographicMapInterface : BasicGeographicMap, layerInterface : AllBinaryLayer, dx : Int, dy : Int, reusableList : BasicArrayList) : BasicArrayList = {
        reusableList.clear()
        var topLeftGeographicMapCellPosition : GeographicMapCellPosition = geographicMapInterface.getCellPositionAtXYNoThrow(layerInterface.getXP() + dx, layerInterface.getYP() + dy)
        var topRightGeographicMapCellPosition : GeographicMapCellPosition = geographicMapInterface.getCellPositionAtXYNoThrow((layerInterface.getXP() + layerInterface.getWidth()) + dx, layerInterface.getYP() + dy)
        var bottomLeftGeographicMapCellPosition : GeographicMapCellPosition = geographicMapInterface.getCellPositionAtXYNoThrow(layerInterface.getXP() + dx, (layerInterface.getYP() + layerInterface.getHeight()) + dy)
        var bottomRightGeographicMapCellPosition : GeographicMapCellPosition = geographicMapInterface.getCellPositionAtXYNoThrow((layerInterface.getXP() + layerInterface.getWidth()) + dx, (layerInterface.getYP() + layerInterface.getHeight()) + dy)
        //reusableList.add(topLeftGeographicMapCellPosition);
        if (topLeftGeographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            reusableList.add(topLeftGeographicMapCellPosition)
        }
        if ((topRightGeographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) && (topLeftGeographicMapCellPosition ne topRightGeographicMapCellPosition)) {
            reusableList.add(topRightGeographicMapCellPosition)
        }
        if ((bottomLeftGeographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) && !reusableList.contains(bottomLeftGeographicMapCellPosition)) {
            reusableList.add(bottomLeftGeographicMapCellPosition)
        }
        if ((bottomRightGeographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) && !reusableList.contains(bottomRightGeographicMapCellPosition)) {
            reusableList.add(bottomRightGeographicMapCellPosition)
        }
        return reusableList
    }

}

object LayerPartialCellPositionsUtil {
    private val instance : LayerPartialCellPositionsUtil = new LayerPartialCellPositionsUtil()

    def getInstance() : LayerPartialCellPositionsUtil = {
        return LayerPartialCellPositionsUtil.instance
    }

}


