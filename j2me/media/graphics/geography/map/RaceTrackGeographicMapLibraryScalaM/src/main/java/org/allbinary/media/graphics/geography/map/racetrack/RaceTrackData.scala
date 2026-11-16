/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.graphics.CellPosition
import _root_.org.allbinary.logic.NullUtil

class RaceTrackData(param_id : Integer, param_cellWidth : Int, param_cellHeight : Int, param_miniCellWidth : Int, param_miniCellHeight : Int, param_cellTypeIdToGeographicMapCellTypeArray : Array[Int], param_mapArray : Array[Array[Int]]) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var tileSetImage : Image = NullImage.NULL_IMAGE

    private var miniTileSetImage : Image = NullImage.NULL_IMAGE

    private var cellWidth : Int = 0

    private var cellHeight : Int = 0

    private var miniCellWidth : Int = 0

    private var miniCellHeight : Int = 0

    private var mapArray : Array[Array[Int]] = NullUtil.getInstance().NULL_INT_ARRAY_ARRAY

    private var cellTypeIdToGeographicMapCellTypeArray : Array[Int] = NullUtil.getInstance().NULL_INT_ARRAY

    private var NO_OVER_PASSES_ARRAY : Array[CellPosition] = new Array[CellPosition](0)

    private var overPassGeographicMapCellPositionArray : Array[CellPosition] = this.NO_OVER_PASSES_ARRAY

    private var id : Integer = null

    //Constructor
    {
        val id : Integer = param_id
        val cellWidth : Int = param_cellWidth
        val cellHeight : Int = param_cellHeight
        val miniCellWidth : Int = param_miniCellWidth
        val miniCellHeight : Int = param_miniCellHeight
        val cellTypeIdToGeographicMapCellTypeArray : Array[Int] = param_cellTypeIdToGeographicMapCellTypeArray
        val mapArray : Array[Array[Int]] = param_mapArray
        this.id = id
        this.cellWidth = cellWidth
        this.cellHeight = cellHeight
        this.miniCellWidth = miniCellWidth
        this.miniCellHeight = miniCellHeight
        this.mapArray = mapArray
        this.cellTypeIdToGeographicMapCellTypeArray = cellTypeIdToGeographicMapCellTypeArray
    }

    def setMapArray(mapArray : Array[Array[Int]]) : Unit = {
        //this.logUtil.putF("Set Map Array: Rows: " + mapArray.length + "Cols:  " + mapArray[0].length, this, "setMapArray");
        this.mapArray = mapArray
    }

    def getMapArray() : Array[Array[Int]] = {
        return this.mapArray
    }

    def setCellTypeIdToGeographicMapCellTypeArray(cellTypeIdToGeographicMapCellTypeArray : Array[Int]) : Unit = {
        this.cellTypeIdToGeographicMapCellTypeArray = cellTypeIdToGeographicMapCellTypeArray
    }

    def getCellTypeIdToGeographicMapCellTypeArray() : Array[Int] = {
        return this.cellTypeIdToGeographicMapCellTypeArray
    }

    private def setCellWidth(cellWidth : Int) : Unit = {
        this.cellWidth = cellWidth
    }

    def getCellWidth() : Int = {
        return this.cellWidth
    }

    private def setCellHeight(cellHeight : Int) : Unit = {
        this.cellHeight = cellHeight
    }

    def getCellHeight() : Int = {
        return this.cellHeight
    }

    def getOverPassGeographicMapCellPositionArray() : Array[CellPosition] = {
        return this.overPassGeographicMapCellPositionArray
    }

    def setOverPassGeographicMapCellPositionArray(overPassGeographicMapCellPositionArray : Array[CellPosition]) : Unit = {
        this.overPassGeographicMapCellPositionArray = overPassGeographicMapCellPositionArray
    }

    def getTileSetImage() : Image = {
        return this.tileSetImage
    }

    def setTileSetImage(tileSetImage : Image) : Unit = {
        this.tileSetImage = tileSetImage
    }

    def getMiniTileSetImage() : Image = {
        return this.miniTileSetImage
    }

    def setMiniTileSetImage(miniTileSetImage : Image) : Unit = {
        this.miniTileSetImage = miniTileSetImage
    }

    def getMiniCellWidth() : Int = {
        return this.miniCellWidth
    }

    def setMiniCellWidth(miniCellWidth : Int) : Unit = {
        this.miniCellWidth = miniCellWidth
    }

    def getMiniCellHeight() : Int = {
        return this.miniCellHeight
    }

    def setMiniCellHeight(miniCellHeight : Int) : Unit = {
        this.miniCellHeight = miniCellHeight
    }

    def setId(id : Integer) : Unit = {
        this.id = id
    }

    def getId() : Integer = {
        return this.id
    }

}


