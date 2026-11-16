/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.layer.Layer
import _root_.org.allbinary.logic.math.MathUtil
import _root_.org.allbinary.util.BasicArrayList

class BasicGeographicMap(param_id : Integer, param_name : String, param_cellTypeIdToGeographicMapCellType : Array[Int], param_tiledLayer : AllBinaryTiledLayer, param_foregroundBasicColor : BasicColor, param_backgroundBasicColor : BasicColor, param_geographicMapCellPositionFactoryInterface : GeographicMapCellPositionFactoryInterface, param_geographicMapCellPositionBaseFactory : GeographicMapCellPositionBaseFactory, param_geographicMapCellTypeFactory : GeographicMapCellTypeFactory) extends SimpleGeographicMap(param_id, param_name, param_cellTypeIdToGeographicMapCellType, param_tiledLayer, param_foregroundBasicColor, param_backgroundBasicColor) with GeographicMapInterface {
    import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap.{NULL_BASIC_GEOGRAPHIC_MAP_ARRAY as _, *}
    def NULL_BASIC_GEOGRAPHIC_MAP_ARRAY : Array[BasicGeographicMap] = _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap.NULL_BASIC_GEOGRAPHIC_MAP_ARRAY

    private val mathUtil : MathUtil = MathUtil.getInstance()

    private var geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = null

    private var geographicMapCellPositionFactoryInterface : GeographicMapCellPositionFactoryInterface = null

    private var geographicMapCellTypeFactory : GeographicMapCellTypeFactory = null

    //Constructor
    {
        val id : Integer = param_id
        val name : String = param_name
        val cellTypeIdToGeographicMapCellType : Array[Int] = param_cellTypeIdToGeographicMapCellType
        val tiledLayer : AllBinaryTiledLayer = param_tiledLayer
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val geographicMapCellPositionFactoryInterface : GeographicMapCellPositionFactoryInterface = param_geographicMapCellPositionFactoryInterface
        val geographicMapCellPositionBaseFactory : GeographicMapCellPositionBaseFactory = param_geographicMapCellPositionBaseFactory
        val geographicMapCellTypeFactory : GeographicMapCellTypeFactory = param_geographicMapCellTypeFactory
        this.geographicMapCellPositionFactoryInterface = geographicMapCellPositionFactoryInterface
        this.geographicMapCellPositionFactory = geographicMapCellPositionBaseFactory.getInstance(this)
        this.geographicMapCellTypeFactory = geographicMapCellTypeFactory
    }

    /*     public GPoint getPointAt(        GeographicMapCellPosition geographicMapCellPosition)        throws Exception     {         AllBinaryTiledLayer allBinaryTiledLayer = this.getAllBinaryTiledLayer();         int x = allBinaryTiledLayer.getCellHeight() * geographicMapCellPosition.getColumn();         int y = allBinaryTiledLayer.getCellWidth() * geographicMapCellPosition.getRow();         return PointFactory.getInstance(x, y);     }      */
    def getCellPosition(direction : Int, oldGeographicMapCellPosition : GeographicMapCellPosition) : GeographicMapCellPosition = {
        direction match {
            case 0 => {
                return this.geographicMapCellPositionFactory.getAt(oldGeographicMapCellPosition.getColumn() - 1, oldGeographicMapCellPosition.getRow())
            }
            case 1 => {
                return this.geographicMapCellPositionFactory.getAt(oldGeographicMapCellPosition.getColumn() + 1, oldGeographicMapCellPosition.getRow())
            }
            case 2 => {
                return this.geographicMapCellPositionFactory.getAt(oldGeographicMapCellPosition.getColumn(), oldGeographicMapCellPosition.getRow() - 1)
            }
            case 3 => {
                return this.geographicMapCellPositionFactory.getAt(oldGeographicMapCellPosition.getColumn(), oldGeographicMapCellPosition.getRow() + 1)
            }
            case _ => {
                throw new Exception("Only Four Directions")
            }
        }
        throw new IllegalStateException()
    }

    def getCellPositionNoThrow(direction : Int, oldGeographicMapCellPosition : GeographicMapCellPosition) : GeographicMapCellPosition = {
        direction match {
            case 0 => {
                if ((oldGeographicMapCellPosition.getColumn() - 1) >= 0) {
                    return this.geographicMapCellPositionFactory.getAt(oldGeographicMapCellPosition.getColumn() - 1, oldGeographicMapCellPosition.getRow())
                } else {
                    return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
                }
                if ((oldGeographicMapCellPosition.getColumn() + 1) < this.getAllBinaryTiledLayer().getColumns()) {
                    return this.geographicMapCellPositionFactory.getAt(oldGeographicMapCellPosition.getColumn() + 1, oldGeographicMapCellPosition.getRow())
                } else {
                    return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
                }
                if ((oldGeographicMapCellPosition.getRow() - 1) >= 0) {
                    return this.geographicMapCellPositionFactory.getAt(oldGeographicMapCellPosition.getColumn(), oldGeographicMapCellPosition.getRow() - 1)
                } else {
                    return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
                }
                if ((oldGeographicMapCellPosition.getRow() + 1) < this.getAllBinaryTiledLayer().getRows()) {
                    return this.geographicMapCellPositionFactory.getAt(oldGeographicMapCellPosition.getColumn(), oldGeographicMapCellPosition.getRow() + 1)
                } else {
                    return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
                }
                return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
            }
            case 1 => {
                if ((oldGeographicMapCellPosition.getColumn() + 1) < this.getAllBinaryTiledLayer().getColumns()) {
                    return this.geographicMapCellPositionFactory.getAt(oldGeographicMapCellPosition.getColumn() + 1, oldGeographicMapCellPosition.getRow())
                } else {
                    return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
                }
                if ((oldGeographicMapCellPosition.getRow() - 1) >= 0) {
                    return this.geographicMapCellPositionFactory.getAt(oldGeographicMapCellPosition.getColumn(), oldGeographicMapCellPosition.getRow() - 1)
                } else {
                    return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
                }
                if ((oldGeographicMapCellPosition.getRow() + 1) < this.getAllBinaryTiledLayer().getRows()) {
                    return this.geographicMapCellPositionFactory.getAt(oldGeographicMapCellPosition.getColumn(), oldGeographicMapCellPosition.getRow() + 1)
                } else {
                    return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
                }
                return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
            }
            case 2 => {
                if ((oldGeographicMapCellPosition.getRow() - 1) >= 0) {
                    return this.geographicMapCellPositionFactory.getAt(oldGeographicMapCellPosition.getColumn(), oldGeographicMapCellPosition.getRow() - 1)
                } else {
                    return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
                }
                if ((oldGeographicMapCellPosition.getRow() + 1) < this.getAllBinaryTiledLayer().getRows()) {
                    return this.geographicMapCellPositionFactory.getAt(oldGeographicMapCellPosition.getColumn(), oldGeographicMapCellPosition.getRow() + 1)
                } else {
                    return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
                }
                return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
            }
            case 3 => {
                if ((oldGeographicMapCellPosition.getRow() + 1) < this.getAllBinaryTiledLayer().getRows()) {
                    return this.geographicMapCellPositionFactory.getAt(oldGeographicMapCellPosition.getColumn(), oldGeographicMapCellPosition.getRow() + 1)
                } else {
                    return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
                }
                return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
            }
            case _ => {
                return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
            }
        }
        throw new IllegalStateException()
    }

    def isOfFourDirections(oldGeographicMapCellPosition : GeographicMapCellPosition, newGeographicMapCellPosition : GeographicMapCellPosition) : Boolean = {

        {
            var index : Int = 0
            while (index < 4) {
                if (newGeographicMapCellPosition eq this.getCellPositionNoThrow(index, oldGeographicMapCellPosition)) {
                    return true
                }
                index += 1
            }
        }
        return false
    }

    override def getCellPositionAtXY(x : Int, y : Int) : GeographicMapCellPosition = {
        val allBinaryTiledLayer : AllBinaryTiledLayer = this.getAllBinaryTiledLayer()
        val i_column : Int = this.mathUtil.abs(x / allBinaryTiledLayer.getCellHeight())
        val i_row : Int = this.mathUtil.abs(y / allBinaryTiledLayer.getCellWidth())
        return this.geographicMapCellPositionFactory.getAt(i_column, i_row)
    }

    override def getCellPositionAtXYNoThrow(x : Int, y : Int) : GeographicMapCellPosition = {
        val allBinaryTiledLayer : AllBinaryTiledLayer = this.getAllBinaryTiledLayer()
        val i_column : Int = this.mathUtil.abs(x / allBinaryTiledLayer.getCellHeight())
        val i_row : Int = this.mathUtil.abs(y / allBinaryTiledLayer.getCellWidth())
        if ((allBinaryTiledLayer.getColumns() > i_column) && (allBinaryTiledLayer.getRows() > i_row)) {
            try {
                return this.geographicMapCellPositionFactory.getAt(i_column, i_row)
            } catch {
                case e : Exception => {
                    return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
                }
            }
        } else {
            return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
        }
        throw new IllegalStateException()
    }

    def isOnMap(geographicMapCellPosition : GeographicMapCellPosition) : Boolean = {
        val allBinaryTiledLayer : AllBinaryTiledLayer = this.getAllBinaryTiledLayer()
        val i_column : Int = geographicMapCellPosition.getColumn()
        val i_row : Int = geographicMapCellPosition.getRow()
        if ((allBinaryTiledLayer.getColumns() > i_column) && (allBinaryTiledLayer.getRows() > i_row)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def getCellPositionAtNoThrow(x : Int, y : Int, x2 : Int, y2 : Int, geographicMapCellPositionList : BasicArrayList) : BasicArrayList = {
        geographicMapCellPositionList.clear()
        val allBinaryTiledLayer : AllBinaryTiledLayer = this.getAllBinaryTiledLayer()
        val i_columnMin : Int = this.mathUtil.abs(x / allBinaryTiledLayer.getCellHeight())
        val i_rowMin : Int = this.mathUtil.abs(y / allBinaryTiledLayer.getCellWidth())
        val i_columnMax : Int = this.mathUtil.abs(x2 / allBinaryTiledLayer.getCellHeight()) + 1
        val i_rowMax : Int = this.mathUtil.abs(y2 / allBinaryTiledLayer.getCellWidth()) + 1

        {
            var columnIndex : Int = i_columnMin
            while (columnIndex < i_columnMax) {

                {
                    var rowIndex : Int = i_rowMin
                    while (rowIndex < i_rowMax) {
                        if ((allBinaryTiledLayer.getColumns() > columnIndex) && (allBinaryTiledLayer.getRows() > rowIndex)) {
                            geographicMapCellPositionList.add(this.geographicMapCellPositionFactory.getAt(columnIndex, rowIndex))
                        }
                        rowIndex += 1
                    }
                }
                columnIndex += 1
            }
        }
        return geographicMapCellPositionList
    }

    // Assumes array is tied to the ratio of tile cell width and height
    override def getCellPositionsAt(layer : Layer, currentCellPositionArray : Array[Array[GeographicMapCellPosition]], cellPositionArray : Array[Array[GeographicMapCellPosition]]) : Boolean = {
        var hasChanged : Boolean = false
        val size : Int = cellPositionArray.length
        val size2 : Int = cellPositionArray(0).length
        val xPortion : Int = layer.getXP() / (size - 1)
        val yPortion : Int = layer.getYP() / (size - 1)

        {
            var index : Int = 0
            while (index < size) {

                {
                    var index2 : Int = 0
                    while (index2 < size2) {
                        val x : Int = xPortion * index
                        val y : Int = yPortion * index
                        cellPositionArray(index)(index2) = this.getCellPositionAtXY(x, y)
                        if (currentCellPositionArray(index)(index2) ne cellPositionArray(index)(index2)) {
                            hasChanged = true
                        }
                        index2 += 1
                    }
                }
                index += 1
            }
        }
        return hasChanged
    }

    override def getCellTypeAtXY(x : Int, y : Int) : GeographicMapCellType = {
        var cellPosition : GeographicMapCellPosition = this.getCellPositionAtXY(x, y)
        return this.getCellTypeAt(cellPosition)
    }

    override def getGeographicMapCellPositionFactory() : BasicGeographicMapCellPositionFactory = {
        return this.geographicMapCellPositionFactory
    }

    /**      * @return the geographicMapCellPositionFactoryInterface      */
    override def getGeographicMapCellPositionFactoryInterface() : GeographicMapCellPositionFactoryInterface = {
        return this.geographicMapCellPositionFactoryInterface
    }

    def getGeographicMapCellTypeFactory() : GeographicMapCellTypeFactory = {
        return this.geographicMapCellTypeFactory
    }

    //Needed for polyglot do not remove
    override def getId() : Integer = {
        return super.getId()
    }

    //Needed for polyglot do not remove
    override def getName() : String = {
        return super.getName()
    }

    //Needed for polyglot do not remove
    override def reset() : Unit = {
        super.reset()
    }

    //Needed for polyglot do not remove
    override def getAllBinaryTiledLayer() : AllBinaryTiledLayer = {
        return super.getAllBinaryTiledLayer()
    }

    //Needed for polyglot do not remove
    override def getCellTypeFromMapCellTypeInt(cellTypeId : Int) : Int = {
        return super.getCellTypeFromMapCellTypeInt(cellTypeId)
    }

    //Needed for polyglot do not remove
    override def getCellTypeAt(cellPosition : GeographicMapCellPosition) : GeographicMapCellType = {
        return super.getCellTypeAt(cellPosition)
    }

    //Needed for polyglot do not remove
    override def getForegroundBasicColor() : BasicColor = {
        return super.getForegroundBasicColor()
    }

    //Needed for polyglot do not remove
    override def getBackgroundBasicColor() : BasicColor = {
        return super.getBackgroundBasicColor()
    }

}

object BasicGeographicMap {
    val NULL_BASIC_GEOGRAPHIC_MAP_ARRAY : Array[BasicGeographicMap] = new Array[BasicGeographicMap](0)

}


