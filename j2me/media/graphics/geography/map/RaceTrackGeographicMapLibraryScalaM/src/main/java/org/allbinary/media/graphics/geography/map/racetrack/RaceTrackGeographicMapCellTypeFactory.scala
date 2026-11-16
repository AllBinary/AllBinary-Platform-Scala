/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack

import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellTypeFactory

class RaceTrackGeographicMapCellTypeFactory() extends GeographicMapCellTypeFactory {
    import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapCellTypeFactory.{*}

    var EMPTY_CELL_TYPE : GeographicMapCellType = new GeographicMapCellType(0, -1)

    var EASY_CELL_TYPE : GeographicMapCellType = this.EMPTY_CELL_TYPE

    var BOTTOM_LEFT_TURN_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var BOTTOM_RIGHT_TURN_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var TOP_LEFT_TURN_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var TOP_RIGHT_TURN_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var HORIZONTAL_STRAIGHT_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var VERTICAL_STRAIGHT_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var START_LINE_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var DEFAULT_FINISH_LINE_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var FINISH_LINE_ROAD_CELL_TYPE : GeographicMapCellType = GeographicMapCellType.NULL_GEOGRAPHIC_MAP_CELL_TYPE

    //Constructor
    {
        val raceTrackGeographicMapCellTypes : RaceTrackGeographicMapCellTypes = RaceTrackGeographicMapCellTypes.getInstance()
        this.BOTTOM_LEFT_TURN_ROAD_CELL_TYPE = raceTrackGeographicMapCellTypes.BOTTOM_LEFT_TURN_ROAD_CELL_TYPE
        this.BOTTOM_RIGHT_TURN_ROAD_CELL_TYPE = raceTrackGeographicMapCellTypes.BOTTOM_RIGHT_TURN_ROAD_CELL_TYPE
        this.TOP_LEFT_TURN_ROAD_CELL_TYPE = raceTrackGeographicMapCellTypes.TOP_LEFT_TURN_ROAD_CELL_TYPE
        this.TOP_RIGHT_TURN_ROAD_CELL_TYPE = raceTrackGeographicMapCellTypes.TOP_RIGHT_TURN_ROAD_CELL_TYPE
        this.HORIZONTAL_STRAIGHT_ROAD_CELL_TYPE = raceTrackGeographicMapCellTypes.HORIZONTAL_STRAIGHT_ROAD_CELL_TYPE
        this.VERTICAL_STRAIGHT_ROAD_CELL_TYPE = raceTrackGeographicMapCellTypes.VERTICAL_STRAIGHT_ROAD_CELL_TYPE
        this.START_LINE_ROAD_CELL_TYPE = raceTrackGeographicMapCellTypes.START_LINE_ROAD_CELL_TYPE
        this.DEFAULT_FINISH_LINE_ROAD_CELL_TYPE = raceTrackGeographicMapCellTypes.DEFAULT_FINISH_LINE_ROAD_CELL_TYPE
    }

    override def getStartType() : Int = {
        return this.START_LINE_ROAD_CELL_TYPE.getType()
    }

    override def getEndType() : Int = {
        return this.FINISH_LINE_ROAD_CELL_TYPE.getType()
    }

    override def getEmptyType() : Int = {
        return this.EMPTY_CELL_TYPE.getType()
    }

    override def isPath(cellType : GeographicMapCellType) : Boolean = {
        // i_TileType == FINISH_LINE_ROAD_CELL_TYPE)
        if ((cellType ne this.EMPTY_CELL_TYPE) && (cellType ne this.EASY_CELL_TYPE)) {
            return true
        }
        return false
    }

}

object RaceTrackGeographicMapCellTypeFactory {
    private val instanceC : RaceTrackGeographicMapCellTypeFactory = new RaceTrackGeographicMapCellTypeFactory()

    def getInstance() : RaceTrackGeographicMapCellTypeFactory = {
        return RaceTrackGeographicMapCellTypeFactory.instanceC
    }

}


