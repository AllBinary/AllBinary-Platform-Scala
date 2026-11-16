/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory

class GeographicMapCellType(param_type : Int, param_reset : Int) {
    import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType.{NULL_GEOGRAPHIC_MAP_CELL_TYPE_ARRAY as _, NULL_GEOGRAPHIC_MAP_CELL_TYPE as _, *}
    def NULL_GEOGRAPHIC_MAP_CELL_TYPE_ARRAY : Array[GeographicMapCellType] = _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType.NULL_GEOGRAPHIC_MAP_CELL_TYPE_ARRAY
    def NULL_GEOGRAPHIC_MAP_CELL_TYPE : GeographicMapCellType = _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType.NULL_GEOGRAPHIC_MAP_CELL_TYPE

    val logUtil : LogUtil = LogUtil.getInstance()

    private var `type` : Int = 0

    //   }
    //Constructor
    {
        val `type` : Int = param_type
        val reset : Int = param_reset
        //this.logUtil.putF(Integer.toString(type), this, this.commonStrings.CONSTRUCTOR);
        this.`type` = `type`
        if (`type` != Integer.MIN_VALUE) {
            //this.logUtil.putF("type: " + Integer.toString(type), this, commonStrings.CONSTRUCTOR);
            val geographicMapCellTypeFactory : GeographicMapCellTypeFactory = GeographicMapCellTypeFactory.getInstance()
            val geographicMapCellTypeArray : Array[GeographicMapCellType] = geographicMapCellTypeFactory.getGeographicMapCellTypeArray()
            if ((geographicMapCellTypeArray(`type`) == null) || (reset == 1)) {
                geographicMapCellTypeArray(`type`) = this
            } else {
                if (reset != -1) {
                    throw new RuntimeException()
                }
            }
        }
    }

    def getType() : Int = {
        return this.`type`
    }

    override def toString() : String = {
        return SmallIntegerSingletonFactory.getInstance().getAt(this.`type`).toString()
    }

}

object GeographicMapCellType {
    val NULL_GEOGRAPHIC_MAP_CELL_TYPE_ARRAY : Array[GeographicMapCellType] = new Array[GeographicMapCellType](0)

    val NULL_GEOGRAPHIC_MAP_CELL_TYPE : GeographicMapCellType = new GeographicMapCellType(Integer.MIN_VALUE, 0)

}


