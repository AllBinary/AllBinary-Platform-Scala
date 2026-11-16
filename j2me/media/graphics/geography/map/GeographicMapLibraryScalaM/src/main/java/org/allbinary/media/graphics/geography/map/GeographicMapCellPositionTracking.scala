/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvasInterface
import _root_.org.allbinary.layer.AllBinaryLayer

class GeographicMapCellPositionTracking() {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var currentGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    private var previousGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    private var newGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    private var currentCellType : GeographicMapCellType = GeographicMapCellType.NULL_GEOGRAPHIC_MAP_CELL_TYPE

    def getCurrentOverCellType(geographicMap : BasicGeographicMap) : GeographicMapCellType = {
        val geographicMapCellPosition : GeographicMapCellPosition = this.currentGeographicMapCellPosition
        if (geographicMapCellPosition ne this.previousGeographicMapCellPosition) {
            // Get the location of this vehicle relative to the top righ corner of the tileLayer location
            this.currentCellType = geographicMap.getCellTypeAt(geographicMapCellPosition)
        }
        return this.currentCellType
    }

    def updateStart(gameCanvasInterface : AllBinaryGameCanvasInterface, layer : AllBinaryLayer) : Boolean = {
        //Check to see if initialized yet - only a problem because Layer calls it
        if (gameCanvasInterface ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            val geographicMapCompositeInterface : GeographicMapCompositeInterface = gameCanvasInterface.getLayerManager().asInstanceOf[GeographicMapCompositeInterface]
            val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
            this.newGeographicMapCellPosition = geographicMapInterface.getCellPositionAtXY(layer.getXP() + layer.getHalfWidth(), layer.getYP() + layer.getHalfHeight())
            if (this.newGeographicMapCellPosition ne this.currentGeographicMapCellPosition) {
                this.currentGeographicMapCellPosition = this.newGeographicMapCellPosition
                return true
            }
        }
        return false
    }

    def updateEnd() : Boolean = {
        if (this.currentGeographicMapCellPosition ne this.previousGeographicMapCellPosition) {
            this.previousGeographicMapCellPosition = this.currentGeographicMapCellPosition
            return true
        }
        return false
    }

    def getPreviousGeographicMapCellPosition() : GeographicMapCellPosition = {
        return this.previousGeographicMapCellPosition
    }

    def getCurrentGeographicMapCellPosition() : GeographicMapCellPosition = {
        return this.currentGeographicMapCellPosition
    }

}


