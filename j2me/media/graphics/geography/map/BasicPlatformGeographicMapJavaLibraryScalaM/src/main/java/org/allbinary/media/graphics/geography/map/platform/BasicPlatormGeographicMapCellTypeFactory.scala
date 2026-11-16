/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.platform

import _root_.java.util.Enumeration
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellTypeFactory
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.EnumerationUtil

/**  *  * @author User  */
class BasicPlatormGeographicMapCellTypeFactory(param_tileTypeToTileIdsMap : ABHashtable[Object, Object], param_maxTileId : Int) extends GeographicMapCellTypeFactory {

    private val enumerationUtil : EnumerationUtil = EnumerationUtil.getInstance()

    var BLOCK_CELL_TYPE : BasicPlatormGeographicMapCellType = null

    var JUMP_THRU_CELL_TYPE : BasicPlatormGeographicMapCellType = null

    var LADDER_CELL_TYPE : BasicPlatormGeographicMapCellType = null

    private var maxTileId : Int = 0

    //Constructor
    {
        val tileTypeToTileIdsMap : ABHashtable[Object, Object] = param_tileTypeToTileIdsMap
        val maxTileId : Int = param_maxTileId
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF(commonStrings.START, this, commonStrings.INIT)
        this.maxTileId = maxTileId
        //GeographicMapCellTypeFactory.getInstance().EMPTY_CELL_TYPE = 
        new GeographicMapCellType(0, 0)
        //new GeographicMapCellType(1);
        var BLOCK_CELL_TYPE : BasicPlatormGeographicMapCellType = BasicPlatormGeographicMapCellType.createType(1)
        var JUMP_THRU_CELL_TYPE : BasicPlatormGeographicMapCellType = BLOCK_CELL_TYPE
        var LADDER_CELL_TYPE : BasicPlatormGeographicMapCellType = BLOCK_CELL_TYPE
        //final String OTHER = "Other";
        val PLATFORM : String = "Platform"
        val JUMP_TRHU : String = "JumpThru"
        val LADDER : String = "Ladder"
        val enumeration : Enumeration[? <: Object] = tileTypeToTileIdsMap.keys().asInstanceOf[Enumeration[? <: Object]]
        var idsWithTypeList : BasicArrayList = null
        var key : String = null
        var basicPlatormGeographicMapCellType : BasicPlatormGeographicMapCellType = null

        {
            while (this.enumerationUtil.hasMoreElements(enumeration)) {
                key = this.enumerationUtil.nextElement(enumeration).asInstanceOf[String]
                this.logUtil.putF(key, this, commonStrings.INIT)
                idsWithTypeList = tileTypeToTileIdsMap.get(key).asInstanceOf[BasicArrayList]
                basicPlatormGeographicMapCellType = new BasicPlatormGeographicMapCellType(idsWithTypeList)
                if (key.equals(PLATFORM)) {
                    BLOCK_CELL_TYPE = basicPlatormGeographicMapCellType
                }
                if (key.equals(JUMP_TRHU)) {
                    JUMP_THRU_CELL_TYPE = basicPlatormGeographicMapCellType
                }
                if (key.equals(LADDER)) {
                    LADDER_CELL_TYPE = basicPlatormGeographicMapCellType
                }
            }
        }
        this.BLOCK_CELL_TYPE = BLOCK_CELL_TYPE
        this.JUMP_THRU_CELL_TYPE = JUMP_THRU_CELL_TYPE
        this.LADDER_CELL_TYPE = LADDER_CELL_TYPE
        new GeographicMapCellType(this.maxTileId - 1, 0)
        new GeographicMapCellType(this.maxTileId - 2, 0)
    }

    override def getStartType() : Int = {
        //7
        return this.maxTileId - 1
    }

    override def getEndType() : Int = {
        //8
        return this.maxTileId - 2
    }

    override def getEmptyType() : Int = {
        return 0
    }

    override def isPath(cellType : GeographicMapCellType) : Boolean = {
        if (cellType.getType() == 0) {
            return true
        }
        return false
    }

}


