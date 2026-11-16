/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.logic.communication.log.LogUtil

class GeographicMapCellTypeFactory {
    import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellTypeFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //512 should be the max tileid
    private val geographicMapCellTypeArray : Array[GeographicMapCellType] = new Array[GeographicMapCellType](512)

    def get(`type` : Int) : GeographicMapCellType = {
        //        return geographicMapCellType;
        return this.geographicMapCellTypeArray(`type`)
    }

    def getGeographicMapCellTypeArray() : Array[GeographicMapCellType] = {
        return this.geographicMapCellTypeArray
    }

    def getStartType() : Int = {
        throw new RuntimeException()
    }

    def getEndType() : Int = {
        throw new RuntimeException()
    }

    def getEmptyType() : Int = {
        throw new RuntimeException()
    }

    def isPath(cellType : GeographicMapCellType) : Boolean = {
        throw new RuntimeException()
    }

}

object GeographicMapCellTypeFactory {
    private val instance : GeographicMapCellTypeFactory = new GeographicMapCellTypeFactory()

    def getInstance() : GeographicMapCellTypeFactory = {
        return GeographicMapCellTypeFactory.instance
    }

}


