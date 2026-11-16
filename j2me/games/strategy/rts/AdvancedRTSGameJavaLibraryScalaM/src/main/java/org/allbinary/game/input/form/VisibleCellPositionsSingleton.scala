/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.form

import _root_.javax.microedition.lcdui.game.SimpleTiledLayer
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.layer.RTSLayerEvent
import _root_.org.allbinary.game.layer.building.event.BuildingEventListenerInterface
import _root_.org.allbinary.game.layer.building.event.LocalPlayerBuildingEventHandler
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.graphics.CellPosition
import _root_.org.allbinary.layer.event.ScrollMapEvent
import _root_.org.allbinary.layer.event.ScrollMapEventHandler
import _root_.org.allbinary.layer.event.ScrollMapEventListenerInterface
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings

class VisibleCellPositionsSingleton private() extends BuildingEventListenerInterface with ScrollMapEventListenerInterface {
    import _root_.org.allbinary.game.input.form.VisibleCellPositionsSingleton.{*}

    private var stationaryVisibleCellPositions : Array[Array[Short]] = NullUtil.getInstance().NULL_SHORT_ARRAY_ARRAY

    private var visibleCellPositions : Array[Array[Short]] = NullUtil.getInstance().NULL_SHORT_ARRAY_ARRAY

    private var currentlyVisibleCellPositions : Array[Array[Short]] = NullUtil.getInstance().NULL_SHORT_ARRAY_ARRAY

    val ALL_VISIBLE_TILEDLAYER : SimpleTiledLayer = new SimpleTiledLayer(0, 0, 0, 0)

    private var simpleTiledLayer : SimpleTiledLayer = this.ALL_VISIBLE_TILEDLAYER

    private var paintSimpleTiledLayer : SimpleTiledLayer = this.ALL_VISIBLE_TILEDLAYER

    private var currentIndex : Int = 0

    //Constructor
    {
        LocalPlayerBuildingEventHandler.getInstance().addListenerInterface(this)
        ScrollMapEventHandler.getInstance().addListenerInterface(this)
    }

    def init(simpleTiledLayer : SimpleTiledLayer) : Unit = {
        this.paintSimpleTiledLayer = this.ALL_VISIBLE_TILEDLAYER
        this.currentIndex = 0
        var rows : Int = simpleTiledLayer.getRows()
        var columns : Int = simpleTiledLayer.getColumns()
        this.stationaryVisibleCellPositions = Array.ofDim[Short](rows, columns)
        this.visibleCellPositions = Array.ofDim[Short](rows, columns)
        this.currentlyVisibleCellPositions = Array.ofDim[Short](rows, columns)
        this.setSimpleTiledLayer(simpleTiledLayer)
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onBuildingEvent(event : RTSLayerEvent) : Unit = {
        this.paintSimpleTiledLayer = this.simpleTiledLayer
    }

    override def onMoveEvent(scrollMapEvent : ScrollMapEvent) : Unit = {
        this.move(scrollMapEvent.getDx(), scrollMapEvent.getDy())
    }

    def addStationaryCellPositions(list : BasicArrayList) : Unit = {

        {
            var index : Int = list.size() - 1
            while (index >= 0) {
                var cellPosition : CellPosition = list.get(index).asInstanceOf[CellPosition]
                this.stationaryVisibleCellPositions(cellPosition.getRow())(cellPosition.getColumn()) = (this.stationaryVisibleCellPositions(cellPosition.getRow())(cellPosition.getColumn()) + 1).toShort
                index -= 1
            }
        }
    }

    def removeStationaryCellPositions(list : BasicArrayList) : Unit = {

        {
            var index : Int = list.size() - 1
            while (index >= 0) {
                var cellPosition : CellPosition = list.get(index).asInstanceOf[CellPosition]
                this.stationaryVisibleCellPositions(cellPosition.getRow())(cellPosition.getColumn()) = (this.stationaryVisibleCellPositions(cellPosition.getRow())(cellPosition.getColumn()) - 1).toShort
                index -= 1
            }
        }
    }

    //set currently visible to new data and clear old data
    def update() : Unit = {
        if (this.currentIndex == 0) {
            val temp : Array[Array[Short]] = this.currentlyVisibleCellPositions
            this.currentlyVisibleCellPositions = this.visibleCellPositions
            this.visibleCellPositions = temp

            {
                var index : Int = this.visibleCellPositions.length - 1
                while (index >= 0) {

                    {
                        var index2 : Int = this.visibleCellPositions(0).length - 1
                        while (index2 >= 0) {
                            this.visibleCellPositions(index)(index2) = this.stationaryVisibleCellPositions(index)(index2)
                            index2 -= 1
                        }
                    }
                    index -= 1
                }
            }
        }
        this.currentIndex += 1
        if (this.currentIndex > 10) {
            this.currentIndex = 0
        }
    }

    def shouldProcess() : Boolean = {
        if (this.currentIndex == 0) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def addCellPositions(list : BasicArrayList) : Unit = {

        {
            var index : Int = list.size() - 1
            while (index >= 0) {
                var cellPosition : CellPosition = list.get(index).asInstanceOf[CellPosition]
                this.visibleCellPositions(cellPosition.getRow())(cellPosition.getColumn()) = (this.visibleCellPositions(cellPosition.getRow())(cellPosition.getColumn()) + 1).toShort
                index -= 1
            }
        }
    }

    def isVisible(cellPosition : CellPosition) : Boolean = {
        if (this.visibleCellPositions(cellPosition.getRow())(cellPosition.getColumn()) > 0) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    /*     public boolean isVisible(int column, int row)     {         if(this.visibleCellPositions[row][column] > 0)         {             return true;         }         else         {             return false;         }     }     */
    def move(dx : Int, dy : Int) : Unit = {
        this.getSimpleTiledLayer().moveDXY(dx, dy)
    }

    def paint(graphics : Graphics) : Unit = {
        this.paintSimpleTiledLayer.paint(graphics, this.currentlyVisibleCellPositions)
    }

    private def setSimpleTiledLayer(simpleTiledLayer : SimpleTiledLayer) : Unit = {
        this.simpleTiledLayer = simpleTiledLayer
    }

    def getSimpleTiledLayer() : SimpleTiledLayer = {
        return this.simpleTiledLayer
    }

}

object VisibleCellPositionsSingleton {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : VisibleCellPositionsSingleton = new VisibleCellPositionsSingleton()

    def getInstance() : VisibleCellPositionsSingleton = {
        return VisibleCellPositionsSingleton.instance
    }

}


