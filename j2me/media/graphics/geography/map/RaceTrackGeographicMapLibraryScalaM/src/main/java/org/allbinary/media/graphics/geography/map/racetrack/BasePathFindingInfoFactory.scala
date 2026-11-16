/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellTypeFactory
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingInfo
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingNode
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPositionFactoryInitVisitorInterface
import _root_.org.allbinary.string.CommonSeps

/**  *  * @author user  */
class BasePathFindingInfoFactory {

    val logUtil : LogUtil = LogUtil.getInstance()

    def init(geographicMapInterface : BasicGeographicMap, pathFindingInfo : PathFindingInfo, mapArray : Array[Array[Int]]) : Unit = {
        //this.logUtil.putF("Map Info: \n").append(ArrayUtil.toString(mapArray), this, this.commonStrings.INIT);
        class RaceTrackGeographicMapCellPositionFactoryInitVisitor(param_pathFindingInfoFactory : BasePathFindingInfoFactory) extends GeographicMapCellPositionFactoryInitVisitorInterface {

            private[RaceTrackGeographicMapCellPositionFactoryInitVisitor] var startLineId : Int = 0

            private[RaceTrackGeographicMapCellPositionFactoryInitVisitor] var finishLineId : Int = 0

            private[RaceTrackGeographicMapCellPositionFactoryInitVisitor] var pathFindingInfoFactory : BasePathFindingInfoFactory = null

            //Constructor
            {
                val pathFindingInfoFactory : BasePathFindingInfoFactory = param_pathFindingInfoFactory
                this.pathFindingInfoFactory = pathFindingInfoFactory
                val raceTrackGeographicMapCellTypeFactory : GeographicMapCellTypeFactory = geographicMapInterface.getGeographicMapCellTypeFactory()
                this.startLineId = raceTrackGeographicMapCellTypeFactory.getStartType()
                this.finishLineId = raceTrackGeographicMapCellTypeFactory.getEndType()
            }

            override def visit(tiledLayer : AllBinaryTiledLayer, cellPosition : GeographicMapCellPosition) : Unit = {
                val row : Int = cellPosition.getRow()
                val column : Int = cellPosition.getColumn()
                try {
                    //this.cellTypeIdToGeographicMapCellType[allBinaryTiledLayer.getCell(col, row)];
                    val cellTypeId : Int = mapArray(row)(column)
                    val geographicCellType : Int = geographicMapInterface.getCellTypeFromMapCellTypeInt(cellTypeId)
                    if (geographicCellType == this.startLineId) {
                        this.pathFindingInfoFactory.addStartPathFindingNode(pathFindingInfo, cellPosition)
                    }
                    if (geographicCellType == this.finishLineId) {
                        if (geographicCellType == this.startLineId) {
                            this.pathFindingInfoFactory.addEndPathFindingNode(pathFindingInfo, geographicMapInterface.getGeographicMapCellPositionFactoryInterface().getInstance(geographicMapInterface, cellPosition.getColumn(), cellPosition.getRow(), tiledLayer.getColumns(), tiledLayer.getRows(), tiledLayer.getCellWidth(), tiledLayer.getCellHeight()))
                        } else {
                            this.pathFindingInfoFactory.addEndPathFindingNode(pathFindingInfo, cellPosition)
                        }
                    }
                    val raceTrackGeographicMapCellTypeFactory : GeographicMapCellTypeFactory = geographicMapInterface.getGeographicMapCellTypeFactory()
                    val geographicMapCellTypeFactory : GeographicMapCellTypeFactory = GeographicMapCellTypeFactory.getInstance()
                    // PathFinder/PathFactory results
                    if (raceTrackGeographicMapCellTypeFactory.isPath(geographicMapCellTypeFactory.get(geographicCellType))) {
                        RaceTrackRoadsGeographicMapCellHistoryFactory.getInstance().track(cellPosition)
                    } else {
                    }
                } catch {
                    case e : Exception => {
                        val commonSeps : CommonSeps = CommonSeps.getInstance()
                        this.pathFindingInfoFactory.logUtil.put(new StringMaker().append(commonSeps.BRACKET_OPEN).appendint(row).append(commonSeps.BRACKET_CLOSE).append(commonSeps.BRACKET_OPEN).appendint(column).append("] in [").appendint(mapArray.length).append(commonSeps.BRACKET_CLOSE).append(commonSeps.BRACKET_OPEN).appendint(mapArray(0).length).append(commonSeps.BRACKET_CLOSE).toString(), this, "visit", e)
                        throw e
                    }
                }
            }

        }

        geographicMapInterface.getGeographicMapCellPositionFactory().visit(new RaceTrackGeographicMapCellPositionFactoryInitVisitor(this))
    }

    private def addStartPathFindingNode(pathFindingInfo : PathFindingInfo, startGeographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        //startPathFindingNodeCostInfo.setTotalCost();
        pathFindingInfo.addStartPathFindingNode(new PathFindingNode(NullUtil.getInstance().NULL_OBJECT, startGeographicMapCellPosition))
    }

    private def addEndPathFindingNode(pathFindingInfo : PathFindingInfo, endGeographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        //endPathFindingNodeCostInfo.setTotalCost();
        pathFindingInfo.addEndPathFindingNode(new PathFindingNode(NullUtil.getInstance().NULL_OBJECT, endGeographicMapCellPosition))
    }

    def getInstancePathFindingInfo(geographicMapInterface : BasicGeographicMap, graphArray : Array[Array[Int]]) : PathFindingInfo = {
        throw new RuntimeException()
    }

}


