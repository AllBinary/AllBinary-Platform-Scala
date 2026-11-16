/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.graphics.paint.PaintableInterface
import _root_.org.allbinary.layer.Layer
import _root_.org.allbinary.layer.NamedInterface
import _root_.org.allbinary.string.CommonStrings

class AllBinaryTiledLayer(param_dataId : Integer, param_width : Int, param_height : Int, param_cellWidth : Int, param_cellHeight : Int) extends Layer(0, 0) with NamedInterface with PaintableInterface {

    //LayerInterface
    private var cellWidth : Int = 0

    private var cellHeight : Int = 0

    private var halfWidth : Int = 0

    private var halfHeight : Int = 0

    private var halfCellWidth : Int = 0

    private var halfCellHeight : Int = 0

    private var dataId : Integer = null

    //Constructor
    {
        val dataId : Integer = param_dataId
        val width : Int = param_width
        val height : Int = param_height
        val cellWidth : Int = param_cellWidth
        val cellHeight : Int = param_cellHeight
        this.dataId = dataId
        this.setLayerWidth(width)
        this.setLayerHeight(height)
        //this.logUtil.putF("TiledLayer: w: " + width + " h: " + height, this, this.commonStrings.CONSTRUCTOR);
        super.setPosition(0, 0, 0)
        //this.logUtil.putF("TiledLayer: x: " + this.x + " y: " + this.y, this, this.commonStrings.CONSTRUCTOR);
        this.cellWidth = cellWidth
        this.cellHeight = cellHeight
        this.halfWidth = (this.getWidth() >> 1)
        this.halfHeight = (this.getHeight() >> 1)
        //this.logUtil.putF("TiledLayer: hw: " + this.halfWidth + " hh: " + this.halfHeight, this, this.commonStrings.CONSTRUCTOR);
        this.halfCellWidth = (cellWidth >> 1)
        this.halfCellHeight = (cellHeight >> 1)
    }

    def setCells(mapTwoDArray : Array[Array[Int]]) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Start: r: ")
        stringBuffer.appendint(mapTwoDArray.length)
        stringBuffer.append(" c: ")
        stringBuffer.appendint(mapTwoDArray(0).length)
        stringBuffer.append(" rows: ")
        stringBuffer.appendint(this.getRows())
        stringBuffer.append(" columns: ")
        stringBuffer.appendint(this.getColumns())
        this.logUtil.putF(stringBuffer.toString(), this, "setCells")
        val rows : Int = this.getRows()
        val columns : Int = this.getColumns()

        {
            var col : Int = 0
            while (col < columns) {

                {
                    var row : Int = 0
                    while (row < rows) {
                        this.setCell(col, row, mapTwoDArray(row)(col))
                        row += 1
                    }
                }
                col += 1
            }
        }
    }

    def updateCells(mapTwoDArray : Array[Array[Int]], fromTileId : Int, toTileId : Int) : Unit = {
        //        this.logUtil.putF(stringBuffer.append(fromTileId).append(TO).append(toTileId).toString(), this, UPDATE_CELLS);
        val rows : Int = this.getRows()
        val columns : Int = this.getColumns()

        {
            var col : Int = 0
            while (col < columns) {

                {
                    var row : Int = 0
                    while (row < rows) {
                        if (fromTileId == mapTwoDArray(row)(col)) {
                            //                    this.logUtil.put(stringBuffer.append(fromTileId).append(TO).append(toTileId).append(AT).append(col).append(',').append(row).toString(), this, UPDATE_CELLS);
                            mapTwoDArray(row)(col) = toTileId
                            this.setCell(col, row, mapTwoDArray(row)(col))
                        }
                        row += 1
                    }
                }
                col += 1
            }
        }
    }

    override def getName() : String = {
        return this.getClass().getName()
    }

    override def paint(graphics : Graphics) : Unit = {
    }

    override def paintThreed(graphics : Graphics) : Unit = {
    }

    def getX2() : Int = {
        return this.x + this.getWidth()
    }

    def getY2() : Int = {
        return this.y + this.getHeight()
    }

    def getZ2() : Int = {
        return (this.z + this.getDepth()).toInt
    }

    def getCellWidth() : Int = {
        return this.cellWidth
    }

    def getCellHeight() : Int = {
        return this.cellHeight
    }

    def getCell(col : Int, row : Int) : Int = {
        return -1
    }

    def getColumns() : Int = {
        return -1
    }

    def getRows() : Int = {
        return -1
    }

    def setCell(col : Int, row : Int, tileIndex : Int) : Unit = {
    }

    def getHalfWidth() : Int = {
        return this.halfWidth
    }

    def getHalfHeight() : Int = {
        return this.halfHeight
    }

    def getDataId() : Integer = {
        return this.dataId
    }

    def getHalfCellWidth() : Int = {
        return this.halfCellWidth
    }

    def getHalfCellHeight() : Int = {
        return this.halfCellHeight
    }

    def isOnTileLayer(column : Int, row : Int) : Boolean = {
        if ((((this.getColumns() > column) && (this.getRows() > row)) && (row >= 0)) && (column >= 0)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def getAnimatedTile(animationTileIndex : Int) : Int = {
        return animationTileIndex
    }

}


