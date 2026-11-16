/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface

class FakeLayerManager(param_gameInfo : GameInfo) extends AllBinaryGameLayerManager(BasicColorFactory.getInstance().BLACK, BasicColorFactory.getInstance().WHITE, param_gameInfo) with GeographicMapCompositeInterface {

    private var geographicMapInterfaceArray : Array[BasicGeographicMap] = BasicGeographicMap.NULL_BASIC_GEOGRAPHIC_MAP_ARRAY

    private var geographicMapCellTypeArray_FakeLayerManager : Array[GeographicMapCellType] = GeographicMapCellType.NULL_GEOGRAPHIC_MAP_CELL_TYPE_ARRAY

    //Constructor
    {
        val gameInfo : GameInfo = param_gameInfo
    }

    override def getGeographicMapInterface() : Array[BasicGeographicMap] = {
        return this.geographicMapInterfaceArray
    }

    override def setGeographicMapInterface(geographicMapInterfaceArray : Array[BasicGeographicMap]) : Unit = {
        this.geographicMapInterfaceArray = geographicMapInterfaceArray
        this.geographicMapCellTypeArray_FakeLayerManager = new Array[GeographicMapCellType](this.geographicMapInterfaceArray.length)
    }

    override def geographicMapCellTypeArray() : Array[GeographicMapCellType] = {
        return this.geographicMapCellTypeArray_FakeLayerManager
    }

}


