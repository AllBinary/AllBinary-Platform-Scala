/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory

/**  *  * @author user  */
class GeographicMapCellPathHistoryInfo {

    private var previousGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    private var previousOnPathGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    private var nextUnvisitedOnPathGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    private var nextOnPathGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    private var nextChosenOnPathGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    def getPreviousGeographicMapCellPosition() : GeographicMapCellPosition = {
        return this.previousGeographicMapCellPosition
    }

    def setPreviousGeographicMapCellPosition(previousGeographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        this.previousGeographicMapCellPosition = previousGeographicMapCellPosition
    }

    def getPreviousOnPathGeographicMapCellPosition() : GeographicMapCellPosition = {
        return this.previousOnPathGeographicMapCellPosition
    }

    def setPreviousOnPathGeographicMapCellPosition(previousOnPathGeographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        this.previousOnPathGeographicMapCellPosition = previousOnPathGeographicMapCellPosition
    }

    def getNextUnvisitedOnPathGeographicMapCellPosition() : GeographicMapCellPosition = {
        return this.nextUnvisitedOnPathGeographicMapCellPosition
    }

    def setNextUnvisitedOnPathGeographicMapCellPosition(nextUnvisitedOnPathGeographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        this.nextUnvisitedOnPathGeographicMapCellPosition = nextUnvisitedOnPathGeographicMapCellPosition
    }

    def getNextOnPathGeographicMapCellPosition() : GeographicMapCellPosition = {
        return this.nextOnPathGeographicMapCellPosition
    }

    def setNextOnPathGeographicMapCellPosition(nextOnPathGeographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        this.nextOnPathGeographicMapCellPosition = nextOnPathGeographicMapCellPosition
    }

    def getNextChosenOnPathGeographicMapCellPosition() : GeographicMapCellPosition = {
        return this.nextChosenOnPathGeographicMapCellPosition
    }

    def setNextChosenOnPathGeographicMapCellPosition(nextChosenOnPathGeographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        this.nextChosenOnPathGeographicMapCellPosition = nextChosenOnPathGeographicMapCellPosition
    }

}


