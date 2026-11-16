/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.media.graphics.geography.map.racetrack

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.racetrack.BasePathFindingInfoFactory
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackRoadsGeographicMapCellHistoryFactory
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingInfo
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingNodeCostInfoFactoryBase
import _root_.org.allbinary.util.BasicArrayListS

/**  *  * @author user  */
class PathFindingInfoFactory private() extends BasePathFindingInfoFactory {
    import _root_.org.allbinary.game.media.graphics.geography.map.racetrack.PathFindingInfoFactory.{*}

    override def getInstancePathFindingInfo(geographicMapInterface : BasicGeographicMap, graphArray : Array[Array[Int]]) : PathFindingInfo = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        PreLogUtil.put(commonStrings.START, this, commonStrings.GET_INSTANCE)
        val pathFindingInfo : PathFindingInfo = new PathFindingInfo(new PathFindingNodeCostInfoFactoryBase(), new BasicArrayListS(1), new BasicArrayListS(1))
        RaceTrackRoadsGeographicMapCellHistoryFactory.getInstance().init()
        this.init(geographicMapInterface, pathFindingInfo, graphArray)
        return pathFindingInfo
    }

}

object PathFindingInfoFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : PathFindingInfoFactory = new PathFindingInfoFactory()

    /**      * @return the instance      */
    def getInstance() : PathFindingInfoFactory = {
        return PathFindingInfoFactory.instance
    }

}


