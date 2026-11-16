/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack.drop

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellTypeFactory
import _root_.org.allbinary.media.graphics.geography.map.drop.BaseDropCellPositionGenerator
import _root_.org.allbinary.media.graphics.geography.map.racetrack.BaseRaceTrackGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.racetrack.NullRaceTrackGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapCellTypeFactory
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapInterface
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackRoadsGeographicMapCellHistoryFactory
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper

/**  *   * @author user  */
class RaceTrackDropCellPositionGenerator() extends BaseDropCellPositionGenerator {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    val list : BasicArrayList = new BasicArrayListD()

    // private BasicArrayList typeList = new BasicArrayListD();
    private var timeDelayHelper : TimeDelayHelper = null

    private val STRAIGHTAWAY : Int = 4

    var raceTrackGeographicMap : RaceTrackGeographicMapInterface = NullRaceTrackGeographicMap.NULL_RACE_TRACK_GEOGRAPHIC_MAP

    var raceTrackGeographicMapCellTypeFactory : GeographicMapCellTypeFactory = GeographicMapCellTypeFactory.getInstance()

    private val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    //Constructor
    {
        this.timeDelayHelper = new TimeDelayHelper(10000)
    }

    private def init() : Unit = {
        this.list.clear()
    }

    //isStraightAwayRoad
    override def isDropAllowedAt(geographicMapCellPosition : GeographicMapCellPosition) : Boolean = {
        val raceTrackGeographicMapCellType : RaceTrackGeographicMapCellType = this.raceTrackGeographicMap.getCellTypeAt(geographicMapCellPosition).asInstanceOf[RaceTrackGeographicMapCellType]
        val raceTrackGeographicMapCellTypeFactory : RaceTrackGeographicMapCellTypeFactory = this.raceTrackGeographicMapCellTypeFactory.asInstanceOf[RaceTrackGeographicMapCellTypeFactory]
        if ((raceTrackGeographicMapCellType eq raceTrackGeographicMapCellTypeFactory.HORIZONTAL_STRAIGHT_ROAD_CELL_TYPE) || (raceTrackGeographicMapCellType eq raceTrackGeographicMapCellTypeFactory.VERTICAL_STRAIGHT_ROAD_CELL_TYPE)) {
            return true
        }
        return false
    }

    /* (non-Javadoc)      * @see allbinary.media.graphics.geography.map.racetrack.drop.DropCellPositionGeneratorInterface#update(allbinary.game.layer.AllBinaryGameLayerManager, allbinary.media.graphics.geography.map.racetrack.BaseRaceTrackGeographicMap)      */
    override def update(allBinaryGameLayerManager : AllBinaryGameLayerManager, geographicMapInterface : BasicGeographicMap) : Unit = {
        //PreLogUtil.put(commonStrings.START, this, this.commonStrings.UPDATE);
        this.init()
        val baseRaceTrackGeographicMap : BaseRaceTrackGeographicMap = geographicMapInterface.asInstanceOf[BaseRaceTrackGeographicMap]
        this.raceTrackGeographicMap = baseRaceTrackGeographicMap
        this.raceTrackGeographicMapCellTypeFactory = baseRaceTrackGeographicMap.getGeographicMapCellTypeFactory().asInstanceOf[RaceTrackGeographicMapCellTypeFactory]
        //raceTrackGeographicMap.getAllBinaryTiledLayer();
        val roadGeographicMapCellHistory : GeographicMapCellHistory = RaceTrackRoadsGeographicMapCellHistoryFactory.getInstance()
        val trackedList : BasicArrayList = roadGeographicMapCellHistory.getTracked()
        var geographicMapCellPosition : GeographicMapCellPosition = null
        val lastIndex : Int = trackedList.size() - 1
        var total : Int = 0
        var ahead : Int = 0

        {
            var index : Int = lastIndex
            while (index > 0) {
                geographicMapCellPosition = trackedList.get(index).asInstanceOf[GeographicMapCellPosition]
                total = 0
                // int behind = index - 1;
                ahead = index
                // (GeographicMapCellPosition) trackedList.get(behind)) &&

                {
                    scala.util.boundary { (break_N72256 : scala.util.boundary.Label[Unit]) ?=>
                        while (this.isDropAllowedAt(trackedList.get(ahead).asInstanceOf[GeographicMapCellPosition])) {
                            total += 1
                            // Both a straight away and not close to turn
                            if (total > this.STRAIGHTAWAY) {
                                this.list.add(geographicMapCellPosition)
                                scala.util.boundary.break()(using break_N72256)
                            }
                            ahead += 1
                            if (ahead > lastIndex) {
                                scala.util.boundary.break()(using break_N72256)
                            }
                        }
                    }
                }
                index -= 1
            }
        }
        var size : Int = this.list.size()
        //this.drop(allBinaryLayerManager, (size >> 1));

        {
            var index : Int = size - 1
            while (index >= 0) {
                this.drop(allBinaryGameLayerManager, index)
                index -= 1
            }
        }
    }

    /* (non-Javadoc)      * @see allbinary.media.graphics.geography.map.racetrack.drop.DropCellPositionGeneratorInterface#processTick(allbinary.layer.AllBinaryLayerManager)      */
    override def processTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        if (this.timeDelayHelper.isTime(GameTickTimeDelayHelperFactory.getInstance().startTime)) {
            var index : Int = this.basicArrayListUtil.getRandomIndex(this.list)
            this.drop(allBinaryLayerManager, index)
        }
    }

    def drop(allBinaryLayerManager : AllBinaryLayerManager, index : Int) : Unit = {
        throw new Exception(CommonStrings.getInstance().NOT_IMPLEMENTED)
    }

}


