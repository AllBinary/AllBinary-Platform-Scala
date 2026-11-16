/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.geological.resources

import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.game.rand.MyRandomFactory
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPositionFactoryInterface

/**  *  * @author user  */
class GeologicalGeographicMapCellPositionFactory(param_resourcePerMapCellType : Array[Int]) extends GeographicMapCellPositionFactoryInterface {

    private var resourcePerMapCellType : Array[Int] = null

    //Constructor
    {
        val resourcePerMapCellType : Array[Int] = param_resourcePerMapCellType
        this.resourcePerMapCellType = resourcePerMapCellType
    }

    override def getInstance(geographicMapInterface : BasicGeographicMap, i_column : Int, i_row : Int, columns : Int, rows : Int, width : Int, height : Int) : GeographicMapCellPosition = {
        var tiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        var resources : Int = this.resourcePerMapCellType(tiledLayer.getCell(i_column, i_row)) + MyRandomFactory.getInstance().getAbsoluteNextInt(1000)
        return new GeologicalGeographicMapCellPosition(i_column, i_row, columns, rows, width, height, new GeologicalResource(resources))
    }

}


