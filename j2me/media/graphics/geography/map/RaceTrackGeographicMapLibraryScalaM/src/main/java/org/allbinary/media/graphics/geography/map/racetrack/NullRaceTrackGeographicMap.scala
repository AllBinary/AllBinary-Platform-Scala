/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack

import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.layer.Layer
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPositionFactoryInterface
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType

/**  *  * @author User  */
class NullRaceTrackGeographicMap extends RaceTrackGeographicMapInterface {
    import _root_.org.allbinary.media.graphics.geography.map.racetrack.NullRaceTrackGeographicMap.{NULL_RACE_TRACK_GEOGRAPHIC_MAP as _, *}
    def NULL_RACE_TRACK_GEOGRAPHIC_MAP : NullRaceTrackGeographicMap = _root_.org.allbinary.media.graphics.geography.map.racetrack.NullRaceTrackGeographicMap.NULL_RACE_TRACK_GEOGRAPHIC_MAP

    override def getId() : Integer = {
        throw new RuntimeException()
    }

    override def getName() : String = {
        throw new RuntimeException()
    }

    override def reset() : Unit = {
        throw new RuntimeException()
    }

    override def getAllBinaryTiledLayer() : AllBinaryTiledLayer = {
        throw new RuntimeException()
    }

    override def getCellPositionsAt(layer : Layer, currentCellPositionArray : Array[Array[GeographicMapCellPosition]], cellPositionArray : Array[Array[GeographicMapCellPosition]]) : Boolean = {
        throw new RuntimeException()
    }

    override def getCellPositionAtXY(x : Int, y : Int) : GeographicMapCellPosition = {
        throw new RuntimeException()
    }

    override def getCellPositionAtXYNoThrow(x : Int, y : Int) : GeographicMapCellPosition = {
        throw new RuntimeException()
    }

    override def getCellTypeFromMapCellTypeInt(cellTypeId : Int) : Int = {
        throw new RuntimeException()
    }

    override def getCellTypeAtXY(x : Int, y : Int) : GeographicMapCellType = {
        throw new RuntimeException()
    }

    override def getCellTypeAt(geographicMapCellPosition : GeographicMapCellPosition) : GeographicMapCellType = {
        throw new RuntimeException()
    }

    override def getGeographicMapCellPositionFactory() : BasicGeographicMapCellPositionFactory = {
        throw new RuntimeException()
    }

    override def getGeographicMapCellPositionFactoryInterface() : GeographicMapCellPositionFactoryInterface = {
        throw new RuntimeException()
    }

    override def getForegroundBasicColor() : BasicColor = {
        throw new RuntimeException()
    }

    override def getBackgroundBasicColor() : BasicColor = {
        throw new RuntimeException()
    }

    override def getRaceTrackInfo() : RaceTrackInfo = {
        throw new RuntimeException()
    }

    override def setRaceTrackInfo(aRaceTrackInfo : RaceTrackInfo) : Unit = {
        throw new RuntimeException()
    }

    override def getRaceTrackData() : RaceTrackData = {
        throw new RuntimeException()
    }

    override def setRaceTrackData(raceTrackData : RaceTrackData) : Unit = {
        throw new RuntimeException()
    }

}

object NullRaceTrackGeographicMap {
    val NULL_RACE_TRACK_GEOGRAPHIC_MAP : NullRaceTrackGeographicMap = new NullRaceTrackGeographicMap()

}


