/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack

import _root_.org.allbinary.game.layer.AdvancedRTSGameLayer
import _root_.org.allbinary.game.layer.waypoint.WaypointLayer
import _root_.org.allbinary.graphics.CellPosition
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellTypeFactory
import _root_.org.allbinary.media.graphics.geography.map.drop.DropCellPositionHistory

class CustomMapGenerator(param_raceTrackGeographicMap : RaceTrackGeographicMap) extends CustomMapGeneratorBase {

    private var customMapArray : Array[Array[Int]] = null

    private var raceTrackGeographicMap : RaceTrackGeographicMap = null

    private var geographicMapCellTypeFactory : GeographicMapCellTypeFactory = null

    private val dropCellPositionHistory : DropCellPositionHistory = DropCellPositionHistory.getInstance()

    //Constructor
    {
        val raceTrackGeographicMap : RaceTrackGeographicMap = param_raceTrackGeographicMap
        this.raceTrackGeographicMap = raceTrackGeographicMap
        this.geographicMapCellTypeFactory = this.raceTrackGeographicMap.getGeographicMapCellTypeFactory()
        val mapArray : Array[Array[Int]] = raceTrackGeographicMap.getRaceTrackData().getMapArray()
        val size2 : Int = mapArray(0).length
        this.customMapArray = Array.ofDim[Int](mapArray.length, size2)
        if ((mapArray.length != this.customMapArray.length) || (mapArray(0).length != this.customMapArray(0).length)) {
            throw new Exception("Array Incorrect")
        }
    }

    override def copyMapIntoCustomMap() : Unit = {
        // this.getOwnerLayer().geographicMapInterface;
        var mapArray : Array[Array[Int]] = this.raceTrackGeographicMap.getRaceTrackData().getMapArray()
        var startIndex2 : Int = mapArray(0).length - 1

        {
            var index : Int = mapArray.length - 1
            while (index >= 0) {

                {
                    var index2 : Int = startIndex2
                    while (index2 >= 0) {
                        this.customMapArray(index)(index2) = this.getCustomType(index2, index, mapArray(index)(index2))
                        index2 -= 1
                    }
                }
                index -= 1
            }
        }
    }

    override def getCustomType(column : Int, row : Int, currentType : Int) : Int = {
        val emptyType : Int = this.geographicMapCellTypeFactory.getEmptyType()
        val geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = this.raceTrackGeographicMap.getGeographicMapCellPositionFactory()
        //  this.getOwnerLayer().geographicMapInterface.getGeographicMapCellPositionFactory();
        val cellPosition : CellPosition = geographicMapCellPositionFactory.getAt(column, row)
        if (this.dropCellPositionHistory.isCellPositionWithDrop(cellPosition)) {
            val layer : AllBinaryLayer = this.dropCellPositionHistory.getLayerInterface(cellPosition)
            if (layer eq AllBinaryLayer.NULL_ALLBINARY_LAYER) {
                return emptyType
            }
            val rtsLayer : AdvancedRTSGameLayer = layer.asInstanceOf[AdvancedRTSGameLayer]
            if (!(rtsLayer.getType() == WaypointLayer.getStaticType())) {
                return emptyType
            }
        }
        return currentType
    }

    override def getCustomMapArray() : Array[Array[Int]] = {
        return this.customMapArray
    }

}


