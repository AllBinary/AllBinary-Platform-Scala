/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.event

import _root_.org.allbinary.graphics.CellPosition
import _root_.org.allbinary.graphics.CellPositionFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition

class GeographicMapCellPositionEvent(param_anyType : Object, param_geographicMapCellPosition : CellPosition) extends AllBinaryEventObject(param_anyType) {

    private var geographicMapCellPosition : CellPosition = CellPositionFactory.getInstance().NONE

    //Constructor
    {
        val anyType : Object = param_anyType
        val geographicMapCellPosition : CellPosition = param_geographicMapCellPosition
        this.geographicMapCellPosition = geographicMapCellPosition
    }

    def init(anyType : Object) : Unit = {
        this.setSource(anyType)
    }

    def setGeographicMapCellPosition(geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        this.geographicMapCellPosition = geographicMapCellPosition
    }

    def getGeographicMapCellPosition() : GeographicMapCellPosition = {
        return this.geographicMapCellPosition.asInstanceOf[GeographicMapCellPosition]
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("CellPositionEvent: ")
        stringBuffer.append("\nGeographicMapCellPosition: ")
        stringBuffer.append(StringUtil.getInstance().toString(this.getGeographicMapCellPosition()))
        return stringBuffer.toString()
    }

}


