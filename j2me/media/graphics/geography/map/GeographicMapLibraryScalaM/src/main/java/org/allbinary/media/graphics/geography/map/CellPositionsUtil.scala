/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.util.BasicArrayListS

/**  *  * @author user  */
class CellPositionsUtil {
    import _root_.org.allbinary.media.graphics.geography.map.CellPositionsUtil.{*}

    private val reusableSingleThreadedSurroundingList : BasicArrayList = new BasicArrayListS(8)

    private val surroundArray : Array[Array[Int]] = Array[Array[Int]](Array[Int](-1, -1), Array[Int](0, -1), Array[Int](1, -1), Array[Int](-1, 1), Array[Int](0, 1), Array[Int](1, 1), Array[Int](1, 0), Array[Int](-1, 0))

    final def getAll(geographicMapInterface : BasicGeographicMap, topRightGeographicMapCellPosition : GeographicMapCellPosition, columns : Int, rows : Int, reusableList : BasicArrayList) : BasicArrayList = {
        reusableList.clear()
        val geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = geographicMapInterface.getGeographicMapCellPositionFactory()
        val lastColumn : Int = topRightGeographicMapCellPosition.getColumn() + columns
        val lastRow : Int = topRightGeographicMapCellPosition.getRow() + rows
        //        this.logUtil.putF("Columns: " + columns + " Rows: " + rows + " LastColumn: " + lastColumn + " lastRow: " + lastRow, this, "addAll");
        if (((columns > 1) && (lastColumn > geographicMapInterface.getAllBinaryTiledLayer().getColumns())) || ((rows > 1) && (lastRow > geographicMapInterface.getAllBinaryTiledLayer().getRows()))) {
            return reusableList
        }
        //        this.logUtil.putF("layerInterface.getWidth(): " + layerInterface.getWidth() + " geographicMapInterface.getAllBinaryTiledLayer().getCellWidth(): " + geographicMapInterface.getAllBinaryTiledLayer().getCellWidth(), this, "addAll");

        {
            var rowIndex : Int = 0
            while (rowIndex < rows) {

                {
                    var columnIndex : Int = 0
                    while (columnIndex < columns) {
                        var geographicMapCellPosition : GeographicMapCellPosition = geographicMapCellPositionFactory.getAt(topRightGeographicMapCellPosition.getColumn() + columnIndex, topRightGeographicMapCellPosition.getRow() + rowIndex)
                        //                this.logUtil.putF("columnIndex: " + columnIndex + " rowIndex: " + rowIndex, this, "addAll");
                        reusableList.add(geographicMapCellPosition)
                        columnIndex += 1
                    }
                }
                rowIndex += 1
            }
        }
        //        this.logUtil.putF(new StringMaker().append("reusableList: ").append(reusableList).append(" topRightGeographicMapCellPosition: ").append(topRightGeographicMapCellPosition).toString(), this, "visit");
        return reusableList
    }

    final def getAllSurrounding(geographicMapInterface : BasicGeographicMap, occupyList : BasicArrayList, reusableList : BasicArrayList) : BasicArrayList = {
        reusableList.clear()

        {
            var index : Int = occupyList.size() - 1
            while (index >= 0) {
                val layerGeographicMapCellPosition : GeographicMapCellPosition = occupyList.get(index).asInstanceOf[GeographicMapCellPosition]
                val surroundingGeographicMapCellPositionList : BasicArrayList = this.getAllSurroundingAt(geographicMapInterface, layerGeographicMapCellPosition, this.reusableSingleThreadedSurroundingList)

                {
                    var index2 : Int = surroundingGeographicMapCellPositionList.size() - 1
                    while (index2 >= 0) {
                        val geographicMapCellPosition : GeographicMapCellPosition = surroundingGeographicMapCellPositionList.get(index2).asInstanceOf[GeographicMapCellPosition]
                        //Add if not already in list or not occupied
                        if (!reusableList.contains(geographicMapCellPosition) && !occupyList.contains(geographicMapCellPosition)) {
                            reusableList.add(geographicMapCellPosition)
                        }
                        index2 -= 1
                    }
                }
                index -= 1
            }
        }
        //this.logUtil.putF("list: " + list.size(), this, "getAllSurrounding");
        return reusableList
    }

    //new int[4][2];
    final def getAllSurroundingAt(geographicMapInterface : BasicGeographicMap, layerGeographicMapCellPosition : GeographicMapCellPosition, reusableSurroundingList : BasicArrayList) : BasicArrayList = {
        reusableSurroundingList.clear()
        val geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = geographicMapInterface.getGeographicMapCellPositionFactory()
        var tiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        var row : Int = 0
        var column : Int = 0

        {
            var index : Int = 0
            while (index < 8) {
                column = layerGeographicMapCellPosition.getColumn() + this.surroundArray(index)(0)
                row = layerGeographicMapCellPosition.getRow() + this.surroundArray(index)(1)
                if (tiledLayer.isOnTileLayer(column, row)) {
                    val geographicMapCellPosition : GeographicMapCellPosition = geographicMapCellPositionFactory.getAt(column, row)
                    reusableSurroundingList.add(geographicMapCellPosition)
                }
                index += 1
            }
        }
        return reusableSurroundingList
    }

}

object CellPositionsUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : CellPositionsUtil = new CellPositionsUtil()

    def getInstance() : CellPositionsUtil = {
        return CellPositionsUtil.instance
    }

}


