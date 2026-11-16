/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.drop

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.game.rand.MyRandomFactory
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap

class AnyRandomDropCellPositionGenerator extends BaseDropCellPositionGenerator {

    val list : BasicArrayList = new BasicArrayListD()

    var geographicMapInterface : Object = NullUtil.getInstance().NULL_OBJECT

    override def update(allBinaryGameLayerManager : AllBinaryGameLayerManager, geographicMapInterface : BasicGeographicMap) : Unit = {
        this.geographicMapInterface = geographicMapInterface
        val basicGeographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = geographicMapInterface.getGeographicMapCellPositionFactory()
        val randomFactory : MyRandomFactory = MyRandomFactory.getInstance()
        val tiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        val total : Int = tiledLayer.getColumns() * tiledLayer.getRows()
        var randomColumn : Int = 0
        var randomRow : Int = 0
        var geographicMapCellPosition : GeographicMapCellPosition = null
        //Create a list of random drops

        {
            var index : Int = total
            while ({ index -= 1; index } >= 0) {
                randomColumn = randomFactory.getAbsoluteNextInt(tiledLayer.getColumns())
                randomRow = randomFactory.getAbsoluteNextInt(tiledLayer.getRows())
                geographicMapCellPosition = basicGeographicMapCellPositionFactory.getAt(randomColumn, randomRow)
                //!this.list.contains(geographicMapCellPosition)
                if (this.isDropAllowedAt(geographicMapCellPosition)) {
                    this.list.add(geographicMapCellPosition)
                }
            }
        }
    }

    override def processTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
    }

}


