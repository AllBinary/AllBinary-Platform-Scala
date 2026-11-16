/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics

import _root_.org.allbinary.graph.V
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class CellPosition(param_column : Int, param_row : Int, param_columns : Int, param_rows : Int) extends V {
    import _root_.org.allbinary.graphics.CellPosition.{*}

    //TWB - SmallIntegerSingletonFactory may not be needed
    private var id : Int = 0

    private var column : Int = 0

    private var row : Int = 0

    //Constructor
    {
        val column : Int = param_column
        val row : Int = param_row
        val columns : Int = param_columns
        val rows : Int = param_rows
        this.column = column
        this.row = row
        this.id = (row * columns) + column
    }

    def getColumn() : Int = {
        return this.column
    }

    /*    public void moveColumns(int column)    {       this.column += column;    }    */
    def getRow() : Int = {
        return this.row
    }

    /*    public void moveRows(int row)    {       this.row += row;    }    */
    override def toString() : String = {
        return CellPosition.toStringColRow(this.getColumn(), this.getRow())
    }

    override def getId() : Int = {
        return this.id
    }

}

object CellPosition {
    def toStringCellPosition(basicGeographicMapCellPosition : CellPosition) : String = {
        return CellPosition.toStringColRow(basicGeographicMapCellPosition.getColumn(), basicGeographicMapCellPosition.getRow())
    }

    def toStringColRow(i_column : Int, i_row : Int) : String = {
        //return "Column: " + i_column + " Row: " + i_row;
        var stringBuffer : StringMaker = new StringMaker()
        var commonSeps : CommonSeps = CommonSeps.getInstance()
        stringBuffer.append(commonSeps.PARENTHESIS_OPEN)
        stringBuffer.appendint(i_column)
        stringBuffer.append(commonSeps.COMMA)
        stringBuffer.appendint(i_row)
        stringBuffer.append(commonSeps.PARENTHESIS_CLOSE)
        return stringBuffer.toString()
    }

}


