/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.behavior.topview

import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.topview.BasicTopViewGeographicMapCellTypeFactory

/**  *  * @author User  */
class TopViewCharacterBehavior {

    def terrainEvent(layer : AllBinaryLayer, direction : Direction, x : Int, y : Int, geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
    }

    def terrainMove(layer : AllBinaryLayer, geographicMapInterfaceArray : Array[BasicGeographicMap], x : Int, y : Int) : Unit = {
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

}


