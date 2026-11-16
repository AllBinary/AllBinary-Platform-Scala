/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.behavior.topview

import _root_.org.allbinary.game.physics.velocity.VelocityProperties
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.topview.BasicTopViewGeographicMapCellTypeFactory
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
class GeographicMapTopViewLayerBehavior(param_maxGravityActionIndex : Int) extends TopViewGameLayerBehavior(param_maxGravityActionIndex) {

    //Constructor
    {
        val maxGravityActionIndex : Int = param_maxGravityActionIndex
    }

    def getGeographicMapCellPositionIfNotSolidBlockOrOffMapLocation(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], velocityProperties : VelocityProperties, layer : AllBinaryLayer, x : Int, y : Int) : GeographicMapCellPosition = {
        return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
    }

    def getGeographicMapCellPositionIfNotSolidBlockOrOffMap(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], geographicMapCellPosition : GeographicMapCellPosition, velocityProperties : VelocityProperties, layer : AllBinaryLayer) : GeographicMapCellPosition = {
        return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
    }

    def getGeographicMapCellPositionFromListIfNotSolidBlockOrOffMap(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], geographicMapCellPositionList : BasicArrayList, velocityProperties : VelocityProperties, layer : AllBinaryLayer) : GeographicMapCellPosition = {
        return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
    }

    def gravity(velocityProperties : VelocityProperties, geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
    }

    def left(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], velocityProperties : VelocityProperties, layer : AllBinaryLayer) : Unit = {
    }

    def move(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], velocityProperties : VelocityProperties, layer : AllBinaryLayer, x : Int, y : Int) : Boolean = {
        return false
    }

    def moveAndLand(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], geographicMapCellPosition : GeographicMapCellPosition, velocityProperties : VelocityProperties, layer : AllBinaryLayer, x : Int, y : Int) : Unit = {
    }

    def right(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], velocityProperties : VelocityProperties, layer : AllBinaryLayer) : Unit = {
    }

    def hasSolidBlock(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType]) : Boolean = {
        val size : Int = geographicMapInterfaceArray.length
        var basicTopViewGeographicMapCellTypeFactory : BasicTopViewGeographicMapCellTypeFactory = null

        {
            var index : Int = 0
            while (index < size) {
                basicTopViewGeographicMapCellTypeFactory = geographicMapInterfaceArray(index).getGeographicMapCellTypeFactory().asInstanceOf[BasicTopViewGeographicMapCellTypeFactory]
                if (basicTopViewGeographicMapCellTypeFactory.BLOCK_CELL_TYPE.isType(geographicMapCellTypeArray(index))) {
                    return true
                }
                index += 1
            }
        }
        return false
    }

    def isOffMap(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType]) : Boolean = {
        val size : Int = geographicMapInterfaceArray.length
        var basicTopViewGeographicMapCellTypeFactory : BasicTopViewGeographicMapCellTypeFactory = null

        {
            var index : Int = 0
            while (index < size) {
                basicTopViewGeographicMapCellTypeFactory = geographicMapInterfaceArray(index).getGeographicMapCellTypeFactory().asInstanceOf[BasicTopViewGeographicMapCellTypeFactory]
                if (basicTopViewGeographicMapCellTypeFactory.OFF_MAP_CELL_TYPE.isType(geographicMapCellTypeArray(index))) {
                    return true
                }
                index += 1
            }
        }
        return false
    }

}


