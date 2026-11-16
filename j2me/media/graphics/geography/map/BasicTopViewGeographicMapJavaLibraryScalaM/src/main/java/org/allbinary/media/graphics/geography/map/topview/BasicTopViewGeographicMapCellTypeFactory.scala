/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.topview

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellTypeFactory
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapCellType
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.HashtableUtil

/**  *  * @author User  */
class BasicTopViewGeographicMapCellTypeFactory(param_tileTypeToTileIdsMap : ABHashtable[Object, Object], param_maxTileId : Int) extends GeographicMapCellTypeFactory {

    var BLOCK_CELL_TYPE : BasicTopViewGeographicMapCellType = null

    var OFF_MAP_CELL_TYPE : BasicTopViewGeographicMapCellType = null

    var FLOOR_CELL_TYPE : BasicTopViewGeographicMapCellType = null

    var DOOR_CELL_TYPE : BasicTopViewGeographicMapCellType = null

    var STAIRS_UP_CELL_TYPE : BasicTopViewGeographicMapCellType = null

    var STAIRS_DOWN_CELL_TYPE : BasicTopViewGeographicMapCellType = null

    var OTHER_CELL_TYPE : BasicTopViewGeographicMapCellType = null

    private var maxTileId : Int = 0

    //    }
    //Constructor
    {
        val tileTypeToTileIdsMap : ABHashtable[Object, Object] = param_tileTypeToTileIdsMap
        val maxTileId : Int = param_maxTileId
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF(commonStrings.START, this, commonStrings.CONSTRUCTOR)
        this.maxTileId = maxTileId
        val basicTopViewGeographicMapStrings : BasicTopViewGeographicMapStrings = BasicTopViewGeographicMapStrings.getInstance()
        //new GeographicMapCellType(0);
        val geographicMapCellTypeFactory : GeographicMapCellTypeFactory = GeographicMapCellTypeFactory.getInstance()
        val geographicMapCellTypeArray : Array[GeographicMapCellType] = geographicMapCellTypeFactory.getGeographicMapCellTypeArray()
        var `type` : Int = 0
        if (geographicMapCellTypeArray(`type`) == null) {
            new RaceTrackGeographicMapCellType(CommonStrings.getInstance().UNKNOWN, `type`, 999, 0)
        } else {
        }
        var BLOCK_CELL_TYPE : BasicTopViewGeographicMapCellType = BasicTopViewGeographicMapCellType.createType(basicTopViewGeographicMapStrings.DEFAULT, 1, 1)
        var OFF_MAP_CELL_TYPE : BasicTopViewGeographicMapCellType = BLOCK_CELL_TYPE
        var FLOOR_CELL_TYPE : BasicTopViewGeographicMapCellType = BLOCK_CELL_TYPE
        var DOOR_CELL_TYPE : BasicTopViewGeographicMapCellType = BLOCK_CELL_TYPE
        var STAIRS_UP_CELL_TYPE : BasicTopViewGeographicMapCellType = BLOCK_CELL_TYPE
        var STAIRS_DOWN_CELL_TYPE : BasicTopViewGeographicMapCellType = BLOCK_CELL_TYPE
        var OTHER_CELL_TYPE : BasicTopViewGeographicMapCellType = BLOCK_CELL_TYPE
        //new GeographicMapCellType(1);
        val keyArray : Array[Object] = HashtableUtil.getInstance().getKeysAsArray(tileTypeToTileIdsMap)
        //final String[] keyArray = (String[]) set.toArray(new String[set.size()]);
        val size : Int = keyArray.length
        var idsWithTypeList : BasicArrayList = null
        var key : String = null
        var basicPlatormGeographicMapCellType : BasicTopViewGeographicMapCellType = null

        {
            var index : Int = 0
            while (index < size) {
                key = keyArray(index).asInstanceOf[String]
                //this.logUtil.putF(key, this, commonStrings.INIT);
                idsWithTypeList = tileTypeToTileIdsMap.get(key).asInstanceOf[BasicArrayList]
                //this.logUtil.putF(new StringMaker().append("key: ").append(key).append(CommonLabels.getInstance().COLON_SEP).append(idsWithTypeList.toString()).toString(), this, commonStrings.INIT);
                if (key.equals(basicTopViewGeographicMapStrings.WALL)) {
                    basicPlatormGeographicMapCellType = new BasicTopViewGeographicMapCellType(basicTopViewGeographicMapStrings.WALL, idsWithTypeList, 1000)
                    BLOCK_CELL_TYPE = basicPlatormGeographicMapCellType
                } else if (key.equals(basicTopViewGeographicMapStrings.OFF_MAP)) {
                    basicPlatormGeographicMapCellType = new BasicTopViewGeographicMapCellType(basicTopViewGeographicMapStrings.OFF_MAP, idsWithTypeList, 1001)
                    OFF_MAP_CELL_TYPE = basicPlatormGeographicMapCellType
                } else if (key.equals(basicTopViewGeographicMapStrings.FLOOR)) {
                    basicPlatormGeographicMapCellType = new BasicTopViewGeographicMapCellType(basicTopViewGeographicMapStrings.FLOOR, idsWithTypeList, 1)
                    FLOOR_CELL_TYPE = basicPlatormGeographicMapCellType
                } else if (key.equals(basicTopViewGeographicMapStrings.DOOR)) {
                    basicPlatormGeographicMapCellType = new BasicTopViewGeographicMapCellType(basicTopViewGeographicMapStrings.DOOR, idsWithTypeList, 1)
                    DOOR_CELL_TYPE = basicPlatormGeographicMapCellType
                } else if (key.equals(basicTopViewGeographicMapStrings.STAIRS_UP)) {
                    basicPlatormGeographicMapCellType = new BasicTopViewGeographicMapCellType(basicTopViewGeographicMapStrings.STAIRS_UP, idsWithTypeList, 1)
                    STAIRS_UP_CELL_TYPE = basicPlatormGeographicMapCellType
                } else if (key.equals(basicTopViewGeographicMapStrings.STAIRS_DOWN)) {
                    basicPlatormGeographicMapCellType = new BasicTopViewGeographicMapCellType(basicTopViewGeographicMapStrings.STAIRS_DOWN, idsWithTypeList, 1)
                    STAIRS_DOWN_CELL_TYPE = basicPlatormGeographicMapCellType
                } else if (key.equals(basicTopViewGeographicMapStrings.OTHER)) {
                    basicPlatormGeographicMapCellType = new BasicTopViewGeographicMapCellType(basicTopViewGeographicMapStrings.OTHER, idsWithTypeList, 1)
                    OTHER_CELL_TYPE = basicPlatormGeographicMapCellType
                }
                index += 1
            }
        }
        this.BLOCK_CELL_TYPE = BLOCK_CELL_TYPE
        this.OFF_MAP_CELL_TYPE = OFF_MAP_CELL_TYPE
        this.FLOOR_CELL_TYPE = FLOOR_CELL_TYPE
        this.DOOR_CELL_TYPE = DOOR_CELL_TYPE
        this.STAIRS_UP_CELL_TYPE = STAIRS_UP_CELL_TYPE
        this.STAIRS_DOWN_CELL_TYPE = STAIRS_DOWN_CELL_TYPE
        this.OTHER_CELL_TYPE = OTHER_CELL_TYPE
        `type` = this.maxTileId - 1
        if (geographicMapCellTypeArray(`type`) == null) {
            new RaceTrackGeographicMapCellType(commonStrings.START, `type`, 1, 0)
        } else {
        }
        `type` = this.maxTileId - 2
        if (geographicMapCellTypeArray(`type`) == null) {
            new RaceTrackGeographicMapCellType(commonStrings.START, `type`, 1, 0)
        } else {
        }
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
        return this.FLOOR_CELL_TYPE.getTypes()(0)
    }

    override def isPath(cellType : GeographicMapCellType) : Boolean = {
        if (this.FLOOR_CELL_TYPE.isType(cellType)) {
            return true
        }
        return false
    }

    override def toString() : String = {
        return new StringMaker().append("key: WALL/BLOCK_CELL_TYPE: ").append(this.BLOCK_CELL_TYPE.toString()).append("key: FLOOR_CELL_TYPE: ").append(this.FLOOR_CELL_TYPE.toString()).append("key: OTHER_CELL_TYPE: ").append(this.OTHER_CELL_TYPE.toString()).append("key: OFF_MAP_CELL_TYPE: ").append(this.OFF_MAP_CELL_TYPE.toString()).append("key: DOOR_CELL_TYPE: ").append(this.DOOR_CELL_TYPE.toString()).append("key: STAIRS_DOWN_CELL_TYPE: ").append(this.STAIRS_DOWN_CELL_TYPE.toString()).append("key: STAIRS_UP_CELL_TYPE: ").append(this.STAIRS_UP_CELL_TYPE.toString()).toString()
    }

}


