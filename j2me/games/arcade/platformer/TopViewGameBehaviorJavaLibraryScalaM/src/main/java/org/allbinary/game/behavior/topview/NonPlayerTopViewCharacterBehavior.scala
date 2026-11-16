/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.behavior.topview

import _root_.org.allbinary.media.graphics.geography.map.MultiGeographicMapBehavior
import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.direction.DirectionFactory
import _root_.org.allbinary.game.terrain.BasicTerrainInfo
import _root_.org.allbinary.game.terrain.TerrainEvent
import _root_.org.allbinary.game.terrain.TerrainEventCircularStaticPool
import _root_.org.allbinary.game.terrain.TerrainEventHandler
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory

/**  *  * @author User  */
class NonPlayerTopViewCharacterBehavior extends TopViewCharacterBehavior {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val geographicMapBehavior : MultiGeographicMapBehavior = new MultiGeographicMapBehavior()

    private val CLIFF : BasicTerrainInfo = new BasicTerrainInfo(AngleFactory.getInstance().DOWN)

    def terrainEvent(layer : AllBinaryLayer, direction : Direction, x : Int, y : Int, geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        val maxColumns : Int = geographicMapInterfaceArray(0).getAllBinaryTiledLayer().getColumns()
        if ((geographicMapCellPosition.getColumn() > 0) && (geographicMapCellPosition.getColumn() < maxColumns)) {
            var nextTerrainGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
            val geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = geographicMapInterfaceArray(0).getGeographicMapCellPositionFactory()
            if (direction eq DirectionFactory.getInstance().LEFT) {
                nextTerrainGeographicMapCellPosition = geographicMapCellPositionFactory.getAt(geographicMapCellPosition.getColumn() - 1, geographicMapCellPosition.getRow())
            } else if (direction eq DirectionFactory.getInstance().RIGHT) {
                nextTerrainGeographicMapCellPosition = geographicMapCellPositionFactory.getAt(geographicMapCellPosition.getColumn() + 1, geographicMapCellPosition.getRow())
            }
            this.geographicMapBehavior.getCellTypeAt(geographicMapInterfaceArray, geographicMapCellTypeArray, nextTerrainGeographicMapCellPosition)
            val hasSolidBlock : Boolean = this.hasSolidBlock(geographicMapInterfaceArray, geographicMapCellTypeArray)
            if (!hasSolidBlock) {
                // nextTerrainGeographicMapCellPosition, this, "terrainEvent");
                val terrainEvent : TerrainEvent = TerrainEventCircularStaticPool.getInstance().getNext(this.CLIFF)
                TerrainEventHandler.getInstance(layer).fireEvent(terrainEvent)
            }
        }
    }

    override def terrainMove(layer : AllBinaryLayer, geographicMapInterfaceArray : Array[BasicGeographicMap], x : Int, y : Int) : Unit = {
        layer.moveDXY(x, y)
    }

}


