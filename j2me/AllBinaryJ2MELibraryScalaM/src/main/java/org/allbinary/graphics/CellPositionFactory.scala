/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings

class CellPositionFactory private() {
    import _root_.org.allbinary.graphics.CellPositionFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val NONE : CellPosition = new CellPosition(-1, -1, -1, -1)

    private var cellPositionArray : Array[Array[CellPosition]] = Array.ofDim[CellPosition](0, 0)

    private var columns : Int = 0

    private var rows : Int = 0

    def init(columns : Int, rows : Int) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Init: columns: ")
        stringBuffer.appendint(columns)
        stringBuffer.append(" rows: ")
        stringBuffer.appendint(rows)
        this.logUtil.putF(stringBuffer.toString(), this, commonStrings.INIT)
        this.cellPositionArray = Array.ofDim[CellPosition](columns, rows)
        this.columns = columns
        this.rows = rows

        {
            var column : Int = 0
            while (column < columns) {
                // this.logUtil.putF("Initializing Column: ").append(col, this, commonStrings.INIT);

                {
                    var row : Int = 0
                    while (row < rows) {
                        //CellPosition cellPosition =
                        this.createInstance(column, row)
                        row += 1
                    }
                }
                column += 1
            }
        }
    }

    def getInstanceColRow(i_column : Int, i_row : Int) : CellPosition = {
        try {
            return this.cellPositionArray(i_column)(i_row)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(new StringMaker().append("columns: ").appendint(this.getColumns()).append(" rows: ").appendint(this.getRows()).append(" col: ").appendint(i_column).append(" row: ").appendint(i_row).toString(), this, commonStrings.GET_INSTANCE, e)
                return this.NONE
            }
        }
        throw new IllegalStateException()
    }

    def createInstance(i_column : Int, i_row : Int) : CellPosition = {
        var cellPositionCanBeNull : CellPosition = this.cellPositionArray(i_column)(i_row)
        if (cellPositionCanBeNull == null) {
            cellPositionCanBeNull = new CellPosition(i_column, i_row, this.columns, this.rows)
            this.cellPositionArray(i_column)(i_row) = cellPositionCanBeNull
        }
        return cellPositionCanBeNull
    }

    def getColumns() : Int = {
        return this.columns
    }

    def getRows() : Int = {
        return this.rows
    }

}

object CellPositionFactory {
    private var SINGLETON : CellPositionFactory = new CellPositionFactory()

    def getInstance() : CellPositionFactory = {
        return CellPositionFactory.SINGLETON
    }

}


