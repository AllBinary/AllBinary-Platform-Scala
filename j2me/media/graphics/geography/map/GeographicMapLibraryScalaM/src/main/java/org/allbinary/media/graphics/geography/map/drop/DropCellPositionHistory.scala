/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.drop

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.graphics.CellPosition
import _root_.org.allbinary.graphics.CellPositionFactory
import _root_.org.allbinary.layer.AllBinaryLayer

/**  *  * @author user  */
class DropCellPositionHistory {
    import _root_.org.allbinary.media.graphics.geography.map.drop.DropCellPositionHistory.{*}

    private val cellPositionFactory : CellPositionFactory = CellPositionFactory.getInstance()

    private var positionList : BasicArrayList = new BasicArrayListD()

    private var layerList : BasicArrayList = new BasicArrayListD()

    def add(cellPosition : CellPosition, layerInterface : AllBinaryLayer) : Unit = {
        this.positionList.add(cellPosition)
        this.layerList.add(layerInterface)
    }

    def addAll(list : BasicArrayList, layerInterface : AllBinaryLayer) : Unit = {

        {
            var index : Int = list.size() - 1
            while (index >= 0) {
                this.add(list.get(index).asInstanceOf[CellPosition], layerInterface)
                index -= 1
            }
        }
    }

    def remove(cellPosition : CellPosition) : Unit = {
        var index : Int = this.positionList.indexOf(cellPosition)
        if (index >= 0) {
            this.positionList.removeAt(index)
            this.layerList.removeAt(index)
        }
    }

    def removeAll(layerInterface : AllBinaryLayer) : Unit = {
        var index : Int = 0

        {
            while (index != -1) {
                index = this.layerList.indexOf(layerInterface)
                if (index >= 0) {
                    this.positionList.removeAt(index)
                    this.layerList.removeAt(index)
                }
            }
        }
    }

    def clear() : Unit = {
        this.positionList.clear()
        this.layerList.clear()
    }

    def isCellPositionWithDrop(cellPosition : CellPosition) : Boolean = {
        return this.positionList.contains(cellPosition)
    }

    def anyCellPositionWithDrop(list : BasicArrayList) : Boolean = {

        {
            var index : Int = list.size() - 1
            while (index >= 0) {
                if (this.isCellPositionWithDrop(list.get(index).asInstanceOf[CellPosition])) {
                    return true
                }
                index -= 1
            }
        }
        return false
    }

    def getCellPositionWithDrop(list : BasicArrayList) : CellPosition = {
        var cellPosition : CellPosition = null

        {
            var index : Int = list.size() - 1
            while (index >= 0) {
                cellPosition = list.get(index).asInstanceOf[CellPosition]
                if (this.isCellPositionWithDrop(cellPosition)) {
                    return cellPosition
                }
                index -= 1
            }
        }
        return this.cellPositionFactory.NONE
    }

    def getLayerInterface(cellPosition : CellPosition) : AllBinaryLayer = {
        var index : Int = this.positionList.indexOf(cellPosition)
        if (index >= 0) {
            return this.layerList.get(index).asInstanceOf[AllBinaryLayer]
        } else {
            return AllBinaryLayer.NULL_ALLBINARY_LAYER
        }
        throw new IllegalStateException()
    }

}

object DropCellPositionHistory {
    private val SINGLETON : DropCellPositionHistory = new DropCellPositionHistory()

    def getInstance() : DropCellPositionHistory = {
        return DropCellPositionHistory.SINGLETON
    }

}


