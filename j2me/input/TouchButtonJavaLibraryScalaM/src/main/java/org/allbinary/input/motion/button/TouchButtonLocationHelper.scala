/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.logic.string.StringMaker

class TouchButtonLocationHelper() {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var totalColumns : Int = 0

    private var totalRows : Int = 0

    private var columnsRemainder : Int = 0

    private var rowsRemainder : Int = 0

    private var columnsRemainderHalf : Int = 0

    private var rowsRemainderHalf : Int = 0

    //Constructor
    {
        var buttonSize : Int = CommonButtons.getInstance().STANDARD_BUTTON_SIZE
        var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        //PreLogUtil.put(commonStrings.START_LABEL + displayInfo.toString(), this, "TouchButtonLocationHelper");
        this.totalColumns = Math.round(displayInfo.getLastWidth().toFloat / buttonSize)
        this.totalRows = Math.round(displayInfo.getLastHeight().toFloat / buttonSize)
        this.columnsRemainder = displayInfo.getLastWidth() % buttonSize
        this.columnsRemainderHalf = (this.columnsRemainder >> 1)
        this.rowsRemainder = displayInfo.getLastHeight() % buttonSize
        this.rowsRemainderHalf = (this.rowsRemainder >> 1)
    }

    def getTotalColumns() : Int = {
        return this.totalColumns
    }

    def getTotalRows() : Int = {
        return this.totalRows
    }

    def getColumnsRemainder() : Int = {
        return this.columnsRemainder
    }

    def getRowsRemainder() : Int = {
        return this.rowsRemainder
    }

    def getColumnsRemainderHalf() : Int = {
        return this.columnsRemainderHalf
    }

    def getRowsRemainderHalf() : Int = {
        return this.rowsRemainderHalf
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("totalColumns: ")
        stringBuffer.appendint(this.totalColumns)
        stringBuffer.append(" totalRows: ")
        stringBuffer.appendint(this.totalRows)
        stringBuffer.append(" columnsRemainder: ")
        stringBuffer.appendint(this.columnsRemainder)
        stringBuffer.append(" rowsRemainder: ")
        stringBuffer.appendint(this.rowsRemainder)
        stringBuffer.append(" columnsRemainderHalf: ")
        stringBuffer.appendint(this.columnsRemainderHalf)
        stringBuffer.append(" rowsRemainderHalf: ")
        stringBuffer.appendint(this.rowsRemainderHalf)
        return stringBuffer.toString()
    }

}


