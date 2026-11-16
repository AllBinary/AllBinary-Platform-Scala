/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.graphics.CellPosition
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory

class GeographicMapCellPosition(param_column : Int, param_row : Int, param_columns : Int, param_rows : Int, param_width : Int, param_height : Int) extends CellPosition(param_column, param_row, param_columns, param_rows) {

    private var point : GPoint = null

    private var midPoint : GPoint = null

    //Constructor
    {
        val column : Int = param_column
        val row : Int = param_row
        val columns : Int = param_columns
        val rows : Int = param_rows
        val width : Int = param_width
        val height : Int = param_height
        //this.point = PointFactory.getInstance(x, y);
        var x : Int = this.getColumn() * width
        var y : Int = this.getRow() * height
        val pointFactory : PointFactory = PointFactory.getInstance()
        this.point = pointFactory.createXY(x, y)
        this.midPoint = pointFactory.createXY(x + (width >> 1), y + (height >> 1))
    }

    def getPoint() : GPoint = {
        return this.point
    }

    /**      * @return the midPoint      */
    def getMidPoint() : GPoint = {
        return this.midPoint
    }

    /**      * @param midPoint the midPoint to set      */
    def setMidPoint(midPoint : GPoint) : Unit = {
        this.midPoint = midPoint
    }

}


