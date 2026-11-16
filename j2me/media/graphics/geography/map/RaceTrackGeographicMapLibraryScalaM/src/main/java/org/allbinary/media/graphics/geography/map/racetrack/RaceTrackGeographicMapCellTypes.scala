/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack


class RaceTrackGeographicMapCellTypes() {
    import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapCellTypes.{*}

    var BOTTOM_LEFT_TURN_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var BOTTOM_RIGHT_TURN_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var TOP_LEFT_TURN_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var TOP_RIGHT_TURN_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var HORIZONTAL_STRAIGHT_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var VERTICAL_STRAIGHT_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var START_LINE_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    var DEFAULT_FINISH_LINE_ROAD_CELL_TYPE : RaceTrackGeographicMapCellType = null

    //Constructor
    {
        this.BOTTOM_LEFT_TURN_ROAD_CELL_TYPE = new RaceTrackGeographicMapCellType("Bottom Left Turn", 1, 1, 0)
        this.BOTTOM_RIGHT_TURN_ROAD_CELL_TYPE = new RaceTrackGeographicMapCellType("Bottom Right Turn", 2, 1, 0)
        this.TOP_LEFT_TURN_ROAD_CELL_TYPE = new RaceTrackGeographicMapCellType("Top Left Turn", 3, 1, 0)
        this.TOP_RIGHT_TURN_ROAD_CELL_TYPE = new RaceTrackGeographicMapCellType("Top Right Turne", 4, 1, 0)
        this.HORIZONTAL_STRAIGHT_ROAD_CELL_TYPE = new RaceTrackGeographicMapCellType("Horizontal Straight", 5, 1, 0)
        this.VERTICAL_STRAIGHT_ROAD_CELL_TYPE = new RaceTrackGeographicMapCellType("Vertical Straight", 6, 1, 0)
        this.START_LINE_ROAD_CELL_TYPE = new RaceTrackGeographicMapCellType("Start Line", 7, 1, 0)
        this.DEFAULT_FINISH_LINE_ROAD_CELL_TYPE = new RaceTrackGeographicMapCellType("Finish Line", 8, 1, 0)
    }

}

object RaceTrackGeographicMapCellTypes {
    private val instance : RaceTrackGeographicMapCellTypes = new RaceTrackGeographicMapCellTypes()

    def getInstance() : RaceTrackGeographicMapCellTypes = {
        return RaceTrackGeographicMapCellTypes.instance
    }

}


