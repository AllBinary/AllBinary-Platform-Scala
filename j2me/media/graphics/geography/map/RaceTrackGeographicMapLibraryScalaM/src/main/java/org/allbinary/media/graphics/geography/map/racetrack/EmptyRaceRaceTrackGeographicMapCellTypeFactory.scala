/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingNodeCostInfoData

class EmptyRaceRaceTrackGeographicMapCellTypeFactory private() extends RaceTrackGeographicMapCellTypeFactory {
    import _root_.org.allbinary.media.graphics.geography.map.racetrack.EmptyRaceRaceTrackGeographicMapCellTypeFactory.{*}

    //Constructor
    {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.EMPTY_CELL_TYPE = new RaceTrackGeographicMapCellType(commonStrings.EMPTY, 0, PathFindingNodeCostInfoData.getInstance().MAX_NODE_COST, 1)
        this.EASY_CELL_TYPE = new RaceTrackGeographicMapCellType("Easy", 19, 1, 0)
        this.FINISH_LINE_ROAD_CELL_TYPE = this.DEFAULT_FINISH_LINE_ROAD_CELL_TYPE
    }

}

object EmptyRaceRaceTrackGeographicMapCellTypeFactory {
    private val instanceC : EmptyRaceRaceTrackGeographicMapCellTypeFactory = new EmptyRaceRaceTrackGeographicMapCellTypeFactory()

    /**      * @return the instance      */
    def getInstance() : EmptyRaceRaceTrackGeographicMapCellTypeFactory = {
        return EmptyRaceRaceTrackGeographicMapCellTypeFactory.instanceC
    }

}


