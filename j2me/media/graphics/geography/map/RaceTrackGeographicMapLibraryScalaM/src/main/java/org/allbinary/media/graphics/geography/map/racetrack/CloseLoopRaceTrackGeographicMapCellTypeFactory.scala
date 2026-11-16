/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack


class CloseLoopRaceTrackGeographicMapCellTypeFactory private() extends RaceTrackGeographicMapCellTypeFactory {
    import _root_.org.allbinary.media.graphics.geography.map.racetrack.CloseLoopRaceTrackGeographicMapCellTypeFactory.{*}

    //Constructor
    {
        this.EMPTY_CELL_TYPE = EmptyRaceRaceTrackGeographicMapCellTypeFactory.getInstance().EMPTY_CELL_TYPE
        this.EASY_CELL_TYPE = this.EMPTY_CELL_TYPE
        this.FINISH_LINE_ROAD_CELL_TYPE = this.START_LINE_ROAD_CELL_TYPE
    }

}

object CloseLoopRaceTrackGeographicMapCellTypeFactory {
    private val instanceC : CloseLoopRaceTrackGeographicMapCellTypeFactory = new CloseLoopRaceTrackGeographicMapCellTypeFactory()

    /**      * @return the instance      */
    def getInstance() : CloseLoopRaceTrackGeographicMapCellTypeFactory = {
        return CloseLoopRaceTrackGeographicMapCellTypeFactory.instanceC
    }

}


