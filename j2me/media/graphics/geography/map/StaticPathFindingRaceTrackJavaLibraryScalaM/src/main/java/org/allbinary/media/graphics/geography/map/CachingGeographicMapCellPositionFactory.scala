/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.graphics.CellPosition
import _root_.org.allbinary.util.ABHashtable

class CachingGeographicMapCellPositionFactory(param_geographicMapInterface : BasicGeographicMap) extends BasicGeographicMapCellPositionFactory(param_geographicMapInterface) {

    //Constructor
    {
        val geographicMapInterface : BasicGeographicMap = param_geographicMapInterface
    }

    override def createInstance(i_column : Int, i_row : Int, width : Int, height : Int) : GeographicMapCellPosition = {
        val hashtable : ABHashtable[Object, Object] = GeographicMapCellPositionFactory.getHashtable()
        val cellPositionKey : String = CellPosition.toStringColRow(i_column, i_row)
        var cellPositionCanBeNull : Object = hashtable.get(cellPositionKey)
        if (cellPositionCanBeNull == null) {
            cellPositionCanBeNull = this.geographicMapCellPositionFactoryInterface.getInstance(this.geographicMapInterface, i_column, i_row, this.getColumns(), this.getRows(), width, height)
            this.geographicMapCellPositionArray(i_row)(i_column) = cellPositionCanBeNull.asInstanceOf[GeographicMapCellPosition]
            hashtable.put(cellPositionKey, cellPositionCanBeNull)
        }
        return cellPositionCanBeNull.asInstanceOf[GeographicMapCellPosition]
    }

}


