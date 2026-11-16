/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map


/**  *  * @author user  */
class SimpleGeographicMapCellPositionFactory extends GeographicMapCellPositionFactoryInterface {
    import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory.{NULL_GEOGRAPHIC_MAP_CELL_POSITION as _, *}
    def NULL_GEOGRAPHIC_MAP_CELL_POSITION : GeographicMapCellPosition = _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    override def getInstance(geographicMapInterface : BasicGeographicMap, i_column : Int, i_row : Int, columns : Int, rows : Int, width : Int, height : Int) : GeographicMapCellPosition = {
        return new GeographicMapCellPosition(i_column, i_row, columns, rows, width, height)
    }

}

object SimpleGeographicMapCellPositionFactory {
    val NULL_GEOGRAPHIC_MAP_CELL_POSITION : GeographicMapCellPosition = new GeographicMapCellPosition(-1, -1, -1, -1, -1, -1)

}


