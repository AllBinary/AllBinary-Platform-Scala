/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.string.CommonStrings

class SimpleGeographicMap(param_id : Integer, param_name : String, param_cellTypeIdToGeographicMapCellType : Array[Int], param_tiledLayer : AllBinaryTiledLayer, param_foregroundBasicColor : BasicColor, param_backgroundBasicColor : BasicColor) {

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var id : Integer = null

    private var name : String = null

    var cellTypeIdToGeographicMapCellType : Array[Int] = null

    private var tiledLayer : AllBinaryTiledLayer = null

    private var foregroundBasicColor : BasicColor = BasicColorFactory.getInstance().NULL_COLOR

    private var backgroundBasicColor : BasicColor = BasicColorFactory.getInstance().NULL_COLOR

    private val geographicMapCellTypeFactory : GeographicMapCellTypeFactory = GeographicMapCellTypeFactory.getInstance()

    //Constructor
    {
        val id : Integer = param_id
        val name : String = param_name
        val cellTypeIdToGeographicMapCellType : Array[Int] = param_cellTypeIdToGeographicMapCellType
        val tiledLayer : AllBinaryTiledLayer = param_tiledLayer
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        this.id = id
        this.name = name
        this.cellTypeIdToGeographicMapCellType = cellTypeIdToGeographicMapCellType
        this.tiledLayer = tiledLayer
        this.setBackgroundBasicColor(backgroundBasicColor)
        this.setForegroundBasicColor(foregroundBasicColor)
    }

    def getId() : Integer = {
        return this.id
    }

    def getName() : String = {
        return this.name
    }

    def reset() : Unit = {
    }

    def getAllBinaryTiledLayer() : AllBinaryTiledLayer = {
        return this.tiledLayer
    }

    def getCellTypeAt(cellPosition : GeographicMapCellPosition) : GeographicMapCellType = {
        val i_column : Int = cellPosition.getColumn()
        val i_row : Int = cellPosition.getRow()
        var cellTypeId : Int = this.tiledLayer.getCell(i_column, i_row)
        if (cellTypeId < 0) {
            cellTypeId = this.tiledLayer.getAnimatedTile(cellTypeId)
        }
        return this.geographicMapCellTypeFactory.get(this.cellTypeIdToGeographicMapCellType(cellTypeId))
    }

    def getCellTypeFromMapCellTypeInt(cellTypeId : Int) : Int = {
        return this.cellTypeIdToGeographicMapCellType(cellTypeId)
    }

    def getForegroundBasicColor() : BasicColor = {
        return this.foregroundBasicColor
    }

    private def setForegroundBasicColor(foregroundBasicColor : BasicColor) : Unit = {
        this.foregroundBasicColor = foregroundBasicColor
    }

    def getBackgroundBasicColor() : BasicColor = {
        return this.backgroundBasicColor
    }

    private def setBackgroundBasicColor(backgroundBasicColor : BasicColor) : Unit = {
        this.backgroundBasicColor = backgroundBasicColor
    }

}


