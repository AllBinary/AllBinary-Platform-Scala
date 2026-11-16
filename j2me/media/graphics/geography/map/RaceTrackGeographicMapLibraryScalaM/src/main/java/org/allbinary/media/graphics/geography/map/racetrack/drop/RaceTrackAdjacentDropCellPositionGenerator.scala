/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack.drop

import _root_.org.allbinary.game.identification.GroupCommonFactory
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.direction.DirectionFactory
import _root_.org.allbinary.game.identification.BasicGroupFactory
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.geographic.map.LayerCoveringCellPositionsUtil
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapDirectionUtil
import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.drop.DropCellPositionGeneratorInterface
import _root_.org.allbinary.media.graphics.geography.map.drop.DropCellPositionHistory
import _root_.org.allbinary.media.graphics.geography.map.racetrack.BaseRaceTrackGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapCellTypeFactory
import _root_.org.allbinary.util.ABHashtable

/**  *   * @author user  */
class RaceTrackAdjacentDropCellPositionGenerator private() extends RaceTrackDropCellPositionGenerator {
    import _root_.org.allbinary.media.graphics.geography.map.racetrack.drop.RaceTrackAdjacentDropCellPositionGenerator.{*}

    private val layerCoveringCellPositionsUtil : LayerCoveringCellPositionsUtil = LayerCoveringCellPositionsUtil.getInstance()

    private val groupCommonFactory : GroupCommonFactory = GroupCommonFactory.getInstance()

    //private GeographicMapCellPosition[] surroundingCellPositions = new GeographicMapCellPosition[8];
    private var surroundingCellPositions : Array[GeographicMapCellPosition] = new Array[GeographicMapCellPosition](4)

    private val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    private val geographicMapDirectionUtil : GeographicMapDirectionUtil = GeographicMapDirectionUtil.getInstance()

    private def getFirstNonRoadAdjacentCellPosition(column : Int, row : Int) : GeographicMapCellPosition = {
        var nonRoadGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
        //tiledLayer.getRows()
        val geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = this.raceTrackGeographicMap.getGeographicMapCellPositionFactory()
        this.surroundingCellPositions(0) = geographicMapCellPositionFactory.getAt(column, row - 1)
        this.surroundingCellPositions(1) = geographicMapCellPositionFactory.getAt(column, row + 1)
        this.surroundingCellPositions(2) = geographicMapCellPositionFactory.getAt(column - 1, row)
        this.surroundingCellPositions(3) = geographicMapCellPositionFactory.getAt(column + 1, row)
        /*         this.surroundingCellPositions[0] =         geographicMapCellPositionFactory.getInstance(column - 1, row - 1);         this.surroundingCellPositions[1] =         geographicMapCellPositionFactory.getInstance(column, row - 1);         this.surroundingCellPositions[2] =         geographicMapCellPositionFactory.getInstance(column + 1, row - 1);         this.surroundingCellPositions[3] =         geographicMapCellPositionFactory.getInstance(column - 1, row);         this.surroundingCellPositions[4] =         geographicMapCellPositionFactory.getInstance(column + 1, row);         this.surroundingCellPositions[5] =         geographicMapCellPositionFactory.getInstance(column - 1, row + 1);         this.surroundingCellPositions[6] =         geographicMapCellPositionFactory.getInstance(column, row + 1);         this.surroundingCellPositions[7] =         geographicMapCellPositionFactory.getInstance(column + 1, row + 1);          */
        val baseRaceTrackGeographicMap : BaseRaceTrackGeographicMap = this.raceTrackGeographicMap.asInstanceOf[BaseRaceTrackGeographicMap]
        val raceTrackGeographicMapCellTypeFactory : RaceTrackGeographicMapCellTypeFactory = baseRaceTrackGeographicMap.getGeographicMapCellTypeFactory().asInstanceOf[RaceTrackGeographicMapCellTypeFactory]
        var geographicMapCellPosition : GeographicMapCellPosition = null
        var raceTrackGeographicMapCellType : RaceTrackGeographicMapCellType = null

        {
            var index : Int = this.surroundingCellPositions.length
            scala.util.boundary { (break_N75160 : scala.util.boundary.Label[Unit]) ?=>
                while ({ index -= 1; index } >= 0) {
                    geographicMapCellPosition = this.surroundingCellPositions(index)
                    raceTrackGeographicMapCellType = this.raceTrackGeographicMap.getCellTypeAt(geographicMapCellPosition).asInstanceOf[RaceTrackGeographicMapCellType]
                    if (!raceTrackGeographicMapCellTypeFactory.isPath(raceTrackGeographicMapCellType)) {
                        nonRoadGeographicMapCellPosition = geographicMapCellPosition
                        scala.util.boundary.break()(using break_N75160)
                    }
                }
            }
        }
        /*         if (nonRoadGeographicMapCellPosition == null)         {         throw new Exception("No non road adjacent: column: " + column + " row: " + row);         }          */
        return nonRoadGeographicMapCellPosition
    }

    override def update(allBinaryGameLayerManager : AllBinaryGameLayerManager, geographicMapInterface : BasicGeographicMap) : Unit = {
        this.hashtable.put(AllBinaryGameLayerManager.ID, allBinaryGameLayerManager)
        super.update(allBinaryGameLayerManager, geographicMapInterface)
    }

    override def drop(allBinaryLayerManager : AllBinaryLayerManager, index : Int) : Unit = {
        val geographicMapCellPosition : GeographicMapCellPosition = this.list.get(index).asInstanceOf[GeographicMapCellPosition]
        //LogUtil.put(, this, this.commonStrings.DROP));
        val randomGeographicMapCellPosition : GeographicMapCellPosition = this.getFirstNonRoadAdjacentCellPosition(geographicMapCellPosition.getColumn(), geographicMapCellPosition.getRow())
        if (randomGeographicMapCellPosition == null) {
            return
        }
        val dropCellPositionHistory : DropCellPositionHistory = DropCellPositionHistory.getInstance()
        if (!dropCellPositionHistory.isCellPositionWithDrop(geographicMapCellPosition)) {
            val direction : Direction = this.geographicMapDirectionUtil.getDirectionFromCellPositionToAdjacentCellPosition(randomGeographicMapCellPosition, geographicMapCellPosition)
            //this.logUtil.putF(stringBuffer.toString(), this, this.commonStrings.DROP);
            val objectCanBeNull : Object = this.hashtable.get(this.groupCommonFactory.ID)
            if (objectCanBeNull != null) {
            } else {
                this.hashtable.put(this.groupCommonFactory.ID, BasicGroupFactory.getInstance().NONE_ARRAY)
            }
            this.hashtable.put(DirectionFactory.getInstance().NAME, direction)
            val point : GPoint = randomGeographicMapCellPosition.getPoint()
            val x : Int = point.getX()
            val y : Int = point.getY()
            val z : Int = point.getZ()
            //this.logUtil.putF("Dropping: " + randomGeographicMapCellPosition.toString() + " = " + randomGeographicMapCellPosition.getPoint(), this, this.commonStrings.DROP);
            val layerInterface : AllBinaryLayer = RaceTrackAdjacentDropLayerFactory.getInstance().getRandomInstance().getNextInstance(hashtable, x, y, z)
            val baseRaceTrackGeographicMap : BaseRaceTrackGeographicMap = this.raceTrackGeographicMap.asInstanceOf[BaseRaceTrackGeographicMap]
            val list : BasicArrayList = this.layerCoveringCellPositionsUtil.getAll(baseRaceTrackGeographicMap, randomGeographicMapCellPosition, layerInterface, new BasicArrayListD())
            if (dropCellPositionHistory.anyCellPositionWithDrop(list)) {
                //PreLogUtil.put("Already Has A Drop", this, this.commonStrings.DROP);
                return
            }
            var geographicMapCellType : GeographicMapCellType = null

            {
                var index2 : Int = list.size()
                while ({ index2 -= 1; index2 } >= 0) {
                    geographicMapCellType = this.raceTrackGeographicMap.getCellTypeAt(list.get(index2).asInstanceOf[GeographicMapCellPosition])
                    if (this.raceTrackGeographicMapCellTypeFactory.isPath(geographicMapCellType)) {
                        //PreLogUtil.put("Can't Drop On a Road", this, this.commonStrings.DROP);
                        return
                    }
                }
            }
            //PreLogUtil.put("Dropping: " + layerInterface, this, this.commonStrings.DROP);
            dropCellPositionHistory.addAll(list, layerInterface)
            allBinaryLayerManager.append(layerInterface)
        }
    }

}

object RaceTrackAdjacentDropCellPositionGenerator {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var SINGLETON : RaceTrackAdjacentDropCellPositionGenerator = new RaceTrackAdjacentDropCellPositionGenerator()

    def getInstance() : DropCellPositionGeneratorInterface = {
        return RaceTrackAdjacentDropCellPositionGenerator.SINGLETON
    }

}


