/* * AllBinary Open License Version 1 * Copyright (c) 2006 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapCellType

class PathFindingNodeCostInfoFactory(param_max : Int) extends PathFindingNodeCostInfoFactoryBase {

    //Constructor
    {
        val max : Int = param_max
    }

    override def create(geographicMapInterface : BasicGeographicMap, goingToGeographicMapCellPosition : GeographicMapCellPosition, geographicMapCellPosition : GeographicMapCellPosition, costFromStart : Long, costToEnd : Long) : Unit = {
    }

    override def getTotalCost(geographicMapInterface : BasicGeographicMap, comingFromGeographicMapCellPosition : GeographicMapCellPosition, geographicMapCellPosition : GeographicMapCellPosition) : Long = {
        val geographicMapCellType : GeographicMapCellType = geographicMapInterface.getCellTypeAt(comingFromGeographicMapCellPosition)
        val geographicMapCellType2 : GeographicMapCellType = geographicMapInterface.getCellTypeAt(geographicMapCellPosition)
        val raceTrackGeographicMapCellType : RaceTrackGeographicMapCellType = geographicMapCellType.asInstanceOf[RaceTrackGeographicMapCellType]
        val raceTrackGeographicMapCellType2 : RaceTrackGeographicMapCellType = geographicMapCellType2.asInstanceOf[RaceTrackGeographicMapCellType]
        //        System.out.println(geographicMapCellPosition + " tc: " + raceTrackGeographicMapCellType2.getTravelCost());
        return raceTrackGeographicMapCellType.getTravelCost().toLong + raceTrackGeographicMapCellType2.getTravelCost()
    }

}


