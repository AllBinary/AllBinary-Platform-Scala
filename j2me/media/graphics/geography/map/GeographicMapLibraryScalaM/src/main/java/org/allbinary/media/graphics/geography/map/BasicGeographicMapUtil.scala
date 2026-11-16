/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.layer.Layer
import _root_.org.allbinary.logic.communication.log.LogUtil

class BasicGeographicMapUtil {
    import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getBorderingRow(direction : Int, oldGeographicMapCellPosition : GeographicMapCellPosition) : Int = {
        val LOCATION_CHANGE : Int = 1
        direction match {
            case 0 => {
                return oldGeographicMapCellPosition.getRow()
            }
            case 1 => {
                return oldGeographicMapCellPosition.getRow()
            }
            case 2 => {
                return oldGeographicMapCellPosition.getRow() + LOCATION_CHANGE
            }
            case 3 => {
                return oldGeographicMapCellPosition.getRow() - LOCATION_CHANGE
            }
            case _ => {
                throw new Exception("Only Four Directions")
            }
        }
        throw new IllegalStateException()
    }

    def getBorderingColumn(direction : Int, oldGeographicMapCellPosition : GeographicMapCellPosition) : Int = {
        val LOCATION_CHANGE : Int = 1
        direction match {
            case 0 => {
                return oldGeographicMapCellPosition.getColumn() - LOCATION_CHANGE
            }
            case 1 => {
                return oldGeographicMapCellPosition.getColumn() + LOCATION_CHANGE
            }
            case 2 => {
                return oldGeographicMapCellPosition.getColumn()
            }
            case 3 => {
                return oldGeographicMapCellPosition.getColumn()
            }
            case _ => {
                throw new Exception("Only Four Directions")
            }
        }
        throw new IllegalStateException()
    }

    def isSameCellPosition(fromGeographicMapCellPosition : GeographicMapCellPosition, toGeographicMapCellPosition : GeographicMapCellPosition) : Boolean = {
        val fromColumn : Int = fromGeographicMapCellPosition.getColumn()
        val fromRow : Int = fromGeographicMapCellPosition.getRow()
        val goColumn : Int = toGeographicMapCellPosition.getColumn()
        val goRow : Int = toGeographicMapCellPosition.getRow()
        if ((fromColumn == goColumn) && (fromRow == goRow)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def createAllBinaryTiledLayerArray(geographicMapInterfaceArray : Array[BasicGeographicMap]) : Array[Layer] = {
        val tiledLayerArray : Array[Layer] = new Array[Layer](geographicMapInterfaceArray.length)
        return this.getAllBinaryTiledLayerArray(geographicMapInterfaceArray, tiledLayerArray, 0)
    }

    def getAllBinaryTiledLayerArray(geographicMapInterfaceArray : Array[BasicGeographicMap], tiledLayerArray : Array[Layer], startIndex : Int) : Array[Layer] = {
        var geographicMapInterface : BasicGeographicMap = null
        val size : Int = geographicMapInterfaceArray.length
        var count : Int = 0

        {
            var index : Int = size + startIndex
            while ({ index -= 1; index } >= startIndex) {
                geographicMapInterface = geographicMapInterfaceArray(index)
                tiledLayerArray({ val value_N69754 = count; count += 1; value_N69754 }) = geographicMapInterface.getAllBinaryTiledLayer()
            }
        }
        return tiledLayerArray
    }

    def move(geographicMapInterfaceArray : Array[BasicGeographicMap], dx : Int, dy : Int) : Unit = {
        var geographicMapInterface : BasicGeographicMap = null
        val size : Int = geographicMapInterfaceArray.length

        {
            var index : Int = size
            while ({ index -= 1; index } >= 0) {
                geographicMapInterface = geographicMapInterfaceArray(index)
                geographicMapInterface.getAllBinaryTiledLayer().moveDXY(dx, dy)
            }
        }
    }

    def setPosition(geographicMapInterfaceArray : Array[BasicGeographicMap], x : Int, y : Int) : Unit = {
        //this.logUtil.putF(new StringMaker().append("x: ").append(x).append(" y: ").append(y).toString(), this, commonStrings.PROCESS);
        var geographicMapInterface : BasicGeographicMap = null
        val size : Int = geographicMapInterfaceArray.length

        {
            var index : Int = size
            while ({ index -= 1; index } >= 0) {
                geographicMapInterface = geographicMapInterfaceArray(index)
                geographicMapInterface.getAllBinaryTiledLayer().setPosition(x, y, geographicMapInterface.getAllBinaryTiledLayer().getZP())
            }
        }
    }

}

object BasicGeographicMapUtil {
    private val instance : BasicGeographicMapUtil = new BasicGeographicMapUtil()

    def getInstance() : BasicGeographicMapUtil = {
        return BasicGeographicMapUtil.instance
    }

}


