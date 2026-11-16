/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class BasicGeographicMapCellPositionFactory(param_geographicMapInterface : BasicGeographicMap) {

    val logUtil : LogUtil = LogUtil.getInstance()

    var geographicMapCellPositionArray : Array[Array[GeographicMapCellPosition]] = null

    var geographicMapInterface : BasicGeographicMap = null

    var geographicMapCellPositionFactoryInterface : GeographicMapCellPositionFactoryInterface = null

    private var columns : Int = 0

    private var rows : Int = 0

    private var tiledLayer : AllBinaryTiledLayer = null

    //protected
    //Constructor
    {
        val geographicMapInterface : BasicGeographicMap = param_geographicMapInterface
        this.geographicMapInterface = geographicMapInterface
        this.geographicMapCellPositionFactoryInterface = this.geographicMapInterface.getGeographicMapCellPositionFactoryInterface()
        this.tiledLayer = this.geographicMapInterface.getAllBinaryTiledLayer()
        this.columns = this.tiledLayer.getColumns()
        this.rows = this.tiledLayer.getRows()
        this.geographicMapCellPositionArray = Array.ofDim[GeographicMapCellPosition](this.rows, this.columns)
        this.init()
    }

    private def init() : Unit = {
        val tiledLayer : AllBinaryTiledLayer = this.tiledLayer
        val columns : Int = this.getColumns()
        val rows : Int = this.getRows()
        val width : Int = tiledLayer.getCellWidth()
        val height : Int = tiledLayer.getCellHeight()

        {
            var column : Int = 0
            while (column < columns) {
                // this.logUtil.putF("Initializing Column: ").append(col, this, this.commonStrings.INIT);

                {
                    var row : Int = 0
                    while (row < rows) {
                        // GeographicMapCellPosition cellPosition =
                        this.createInstance(column, row, width, height)
                        row += 1
                    }
                }
                column += 1
            }
        }
    }

    def visit(geographicMapCelPositionFactoryInitVisitorInterface : GeographicMapCellPositionFactoryInitVisitorInterface) : Unit = {
        val tiledLayer : AllBinaryTiledLayer = this.tiledLayer
        val columns : Int = this.getColumns()
        val rows : Int = this.getRows()
        //int height = tiledLayer.getCellHeight();
        try {
            var cellPosition : GeographicMapCellPosition = null

            {
                var column : Int = 0
                while (column < columns) {
                    // this.logUtil.putF("Initializing Column: ").append(col, this, this.commonStrings.INIT);

                    {
                        var row : Int = 0
                        while (row < rows) {
                            // this.logUtil.putF("Initializing Row: ").append(row, this, this.commonStrings.INIT);
                            cellPosition = this.getAt(column, row)
                            geographicMapCelPositionFactoryInitVisitorInterface.visit(tiledLayer, cellPosition)
                            row += 1
                        }
                    }
                    column += 1
                }
            }
        } catch {
            case e : Exception => {
                val commonSeps : CommonSeps = CommonSeps.getInstance()
                this.logUtil.put(new StringMaker().append(commonSeps.BRACKET_OPEN).appendint(rows).append(commonSeps.BRACKET_CLOSE).append(commonSeps.BRACKET_OPEN).appendint(columns).append(commonSeps.BRACKET_CLOSE).toString(), this, "visit", e)
                throw e
            }
        }
    }

    def getAt(i_column : Int, i_row : Int) : GeographicMapCellPosition = {
        /*         if (i_column >= this.geographicMapCellPositionArray.length             || i_row >= this.geographicMapCellPositionArray[0].length)         {             StringMaker stringBuffer = new StringMaker();              stringBuffer.append("columns: ");             stringBuffer.append(this.getColumns());             stringBuffer.append(" rows: ");             stringBuffer.append(this.getRows());             stringBuffer.append(" col: ");             stringBuffer.append(i_column);             stringBuffer.append(" row: ");             stringBuffer.append(i_row);              throw new Exception(stringBuffer.toString());         }         */
        return this.geographicMapCellPositionArray(i_row)(i_column)
    }

    def getInstance(anotherMapGeographicMapCellPosition : GeographicMapCellPosition) : GeographicMapCellPosition = {
        return this.getAt(anotherMapGeographicMapCellPosition.getColumn(), anotherMapGeographicMapCellPosition.getRow())
    }

    def createInstance(i_column : Int, i_row : Int, width : Int, height : Int) : GeographicMapCellPosition = {
        // String cellPositionKey = GeographicMapCellPosition.toString(i_column, i_row);
        var cellPositionCanBeNull : Object = this.geographicMapCellPositionArray(i_row)(i_column)
        if (cellPositionCanBeNull == null) {
            cellPositionCanBeNull = this.geographicMapCellPositionFactoryInterface.getInstance(this.geographicMapInterface, i_column, i_row, this.columns, this.rows, width, height)
            this.geographicMapCellPositionArray(i_row)(i_column) = cellPositionCanBeNull.asInstanceOf[GeographicMapCellPosition]
        }
        return cellPositionCanBeNull.asInstanceOf[GeographicMapCellPosition]
    }

    def getColumns() : Int = {
        return this.columns
    }

    def getRows() : Int = {
        return this.rows
    }

}


